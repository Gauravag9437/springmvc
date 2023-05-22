package springmvc.dao;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import springmvc.dto.TshirtSearchDto;
import springmvc.model.Tshirt;

@Repository
public class ProductDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public List<Tshirt> getAllRecords(TshirtSearchDto inputData) {

		List<Tshirt> user = new ArrayList<Tshirt>();
		String sortWith = "";

		if (inputData.getPreference().equalsIgnoreCase("rating")) {
			sortWith = "order by Rating desc";
		} else if (inputData.getPreference().equalsIgnoreCase("price")) {
			sortWith = "order by Price";
		} else {
			sortWith = "order by Rating desc, Price";
		}

		try {
			String q = "from Tshirt where Color='" + inputData.getColor() + "' and Gender='" + inputData.getGender()
					+ "' and Size='" + inputData.getSize() + "'" + sortWith + "";
			user = (List<Tshirt>) this.hibernateTemplate.find(q);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return user;
	}

	@Transactional
	private void readCsvFile(String file) {
		try {
			CSVParser parser = new CSVParserBuilder().withSeparator('|').build();
			CSVReader reader = new CSVReaderBuilder(new FileReader(file)).withCSVParser(parser).withSkipLines(1)
					.build();
			String[] nextLine;

			while ((nextLine = reader.readNext()) != null) {
				Tshirt tshirt = new Tshirt();
				tshirt.setId(nextLine[0]);
				tshirt.setName(nextLine[1]);
				tshirt.setColor(nextLine[2].toUpperCase());
				tshirt.setGender(nextLine[3].toUpperCase());
				tshirt.setSize(nextLine[4].toUpperCase());
				tshirt.setPrice(Double.parseDouble(nextLine[5]));
				tshirt.setRating(Double.parseDouble(nextLine[6]));
				tshirt.setAvailability(nextLine[7]);

				this.hibernateTemplate.saveOrUpdate(tshirt);

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (CsvValidationException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Transactional
	public List<Tshirt> getAllTshirts(TshirtSearchDto inputData) {

		readCsvFile("C:\\Users\\gauravagrawal01\\eclipse-workspace\\springmvc\\src\\main\\resources\\Adidas.csv");
		readCsvFile("C:\\Users\\gauravagrawal01\\eclipse-workspace\\springmvc\\src\\main\\resources\\Nike.csv");
		readCsvFile("C:\\Users\\gauravagrawal01\\eclipse-workspace\\springmvc\\src\\main\\resources\\Puma.csv");

		List<Tshirt> user1 = getAllRecords(inputData);

		return user1;
	}

}
