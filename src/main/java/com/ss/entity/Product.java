package com.ss.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;


@Entity
@Table(name = "product")
public class Product {
	
	public Product(int model_id, String model_name, double price, String color,
			String category, String gender, int size, String brand,
			String details, int availability, String rating, Set<Order> order) {
		this.model_id = model_id;
		this.model_name = model_name;
		this.price = price;
		this.color = color;
		this.category = category;
		this.gender = gender;
		this.size = size;
		this.brand = brand;
		this.details = details;
		this.availability = availability;
		this.rating = rating;
		this.order = order;
	}

	@Id
	@Column(name="model_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int model_id;
	
	@Column(name="model_name")
	private String model_name;
	
	@Column(name="price")
	private double price;
	
	@Column(name="color")
	private String color;
	
	@Column(name="category")
	private String category;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="size")
	private int size;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="details")
	private String details;
	
	@Column(name="availability")
	private int availability;
	
	@Column(name="rating")
	private String rating;

	//Baeldung says: "whoever owns the foreign key column gets the @JoinColumn annotation"
	@OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Set<Order> order;
	 
  
	/*
	 * @OneToOne(mappedBy = "product", cascade =
	 * CascadeType.ALL)
	 * 
	 * @PrimaryKeyJoinColumn private Order order;
	 */
	
	public Product(int model_id, String model_name, double price, String color,
			String category, String gender, int size, String brand, String details,
			int availability, String rating) {
		this.model_id = model_id;
		this.model_name = model_name;
		this.price = price;
		this.color = color;
		this.category = category;
		this.gender = gender;
		this.size = size;
		this.brand = brand;
		this.details = details;
		this.availability = availability;
		this.rating = rating;
	}


	public Product() {
	}


	public Product(String model_name, Double price, String color, String category, 
			String gender, int size, String brand, String details, int availability,
			String rating) {
		this.model_name = model_name;
		this.price = price;
		this.color = color;
		this.category = category;
		this.gender = gender;
		this.size = size;
		this.brand = brand;
		this.details = details;
		this.availability = availability;
		this.rating = rating;
		
	}
	
	public int getModel_id() {
		return model_id;
	}


	public void setModel_id(int model_id) {
		this.model_id = model_id;
	}


	public String getModel_name() {
		return model_name;
	}


	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


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


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}


	public int getAvailability() {
		return availability;
	}


	public void setAvailability(int availability) {
		this.availability = availability;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getCategory() {
		return category;
	}
	
	
	
}
