package org.makerminds.jcoaching.restaurantapp.model;

public class Restaurant {
    // Java convention for attribute name - small letters
	// <Type> <name=of-attribute>
	// String (Text), int (number), double. float, char, boolean
	
	private String name;
	private String address;
	
	public Restaurant(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	
	//Getter for name attributes
	public String getName() {
		return name;
	}

	
	//Setter for name attribute
	public void setName(String name) {
		
		this.name = name;
		
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	//shortcut for generate: alt + shift + S 
}

	
