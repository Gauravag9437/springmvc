package springmvc.service;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc.dao.ProductDao;
import springmvc.dto.TshirtSearchDto;
import springmvc.model.Tshirt;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;

	public ArrayList<Tshirt> getMatchingTshirts(TshirtSearchDto tshirtSearchDto) throws FileNotFoundException {

		ArrayList<Tshirt> tshirtAllData = (ArrayList<Tshirt>) this.productDao.getAllTshirts(tshirtSearchDto);

		return tshirtAllData;
	}

}
