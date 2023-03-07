package org.makerminds.jcoaching.restaurantapp.model.order;

import java.util.ArrayList;

import org.makerminds.jcoaching.restaurantapp.model.product.Product;

public class Order {
	
	//switched from Array to an Array list
	private ArrayList<OrderItem> orderItems = new ArrayList<>();
	
	//getter for Array ist 
	public ArrayList<OrderItem> getOrderItems() {
		return orderItems;
	}

}	