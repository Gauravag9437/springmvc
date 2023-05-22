package springmvc.dto;

import org.springframework.stereotype.Component;

@Component
public class TshirtSearchDto {

	private String color;
	private String gender;
	private String size;
	private String preference;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "TshirtSearchDto [color=" + color + ", gender=" + gender + ", size=" + size + ", preference="
				+ preference + "]";
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getPreference() {
		return preference;
	}

	public void setPreference(String preference) {
		this.preference = preference;
	}

}
