package springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tshirt1") 
public class Tshirt {

	@Id
	@Column(name = "Id")
	private String id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Color")
	private String color;

	@Column(name = "Gender")
	private String gender;

	@Column(name = "Size")
	private String size;

	@Column(name = "Price")
	private Double price;

	@Column(name = "Rating")
	private Double rating;

	@Column(name = "Availability")
	private String availability;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String colorInput) {
		this.color = colorInput;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String genderInput) {
		this.gender = genderInput;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String sizeInput) {
		this.size = sizeInput;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

}
