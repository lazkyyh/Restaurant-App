package org.makerminds.jcoaching.restaurantapp.model.product;

public class Meal extends Product {

	private String description;
	
	public Meal(int productId, String name, double price) {
		setProductId(productId);
		setName(name);
		setPrice(price);
	}

	public Meal(int productId, String name, double price, String description) {
		this(productId, name, price);
		this.description = description;
	}
	
	//getter and setter for Description
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
