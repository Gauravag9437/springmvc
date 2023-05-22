package springmvc.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springmvc.dto.TshirtSearchDto;

@Component
public class inputValidation {

	@Autowired
	private TshirtSearchDto tshirtInput;

	private String getOutputPreference(String preference) {
		String outputPreference = "";
		String out = null;
		List<String> pref = new ArrayList<String>();
		pref.add("BOTH");
		pref.add("PRICE");
		pref.add("RATING");

		try {
			outputPreference = preference.toUpperCase();
			if (pref.contains(outputPreference)) {
				return outputPreference;

			}
		} catch (IllegalArgumentException e) {
			out = null;

		}
		return out;

	}

	private String getGender(String gender) {
		String gender1 = "";
		String gender2 = null;
		List<String> gen = new ArrayList<String>();
		gen.add("M");
		gen.add("F");
		gen.add("U");

		try {
			gender1 = gender.toUpperCase();
			if (gen.contains(gender1)) {

				return gender1;
			}
		} catch (IllegalArgumentException e) {
			gender2 = null;
		}

		return gender2;
	}

	private String getSize(String size) {
		String size1 = "";
		String size2 = null;

		List<String> siz = new ArrayList<String>();
		siz.add("S");
		siz.add("M");
		siz.add("L");
		siz.add("XL");

		try {
			size1 = size.toUpperCase();
			if (siz.contains(size1)) {

				return size1;
			}
		} catch (IllegalArgumentException e) {
			size2 = null;
		}

		return size2;
	}

	private String getColor(String color) {
		String color1 = "";
		String color2 = null;

		List<String> col = new ArrayList<String>();
		col.add("BLACK");
		col.add("BLUE");
		col.add("MAROON");
		col.add("PURPLE");
		col.add("WHITE");
		col.add("GREY");
		col.add("PINK");
		col.add("YELLOW");

		try {
			color1 = color.toUpperCase();
			if (col.contains(color1)) {

				return color1;
			}
		} catch (IllegalArgumentException e) {
			color2 = null;
		}

		return color2;
	}

	public TshirtSearchDto getInput(TshirtSearchDto tshirtSearchDto) {

		String color = getColor(tshirtSearchDto.getColor());
		String size = getSize(tshirtSearchDto.getSize());
		String gender = getGender(tshirtSearchDto.getGender());
		String outputPreference = getOutputPreference(tshirtSearchDto.getPreference());

		tshirtInput.setColor(color);
		tshirtInput.setSize(size);
		tshirtInput.setGender(gender);
		tshirtInput.setPreference(outputPreference);

		return tshirtInput;

	}

}
