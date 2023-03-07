package org.makerminds.jcoaching.restaurantapp.controller.order;

import java.util.ArrayList;

import org.makerminds.jcoaching.restaurantapp.enums.Location;
import org.makerminds.jcoaching.restaurantapp.model.Client;
import org.makerminds.jcoaching.restaurantapp.model.Restaurant;
import org.makerminds.jcoaching.restaurantapp.model.order.Order;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderAmount;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItem;
import org.makerminds.jcoaching.restaurantapp.model.product.Product;

//created new class for order printing
public class OrderPrinter {


	private void printOrderInfoHeader(Client client) {
		System.out.println("Order from: " + client.getName() + " : ");
		System.out.println("----------------------------------------------");
	}
	
	private void printOrderItemInfo(OrderItem orderItem) {
		Product product = orderItem.getProduct();
		double totalOrderItemPrice = orderItem.getOrderItemPrice() * orderItem.getQuantity();
		System.out.println(orderItem.getQuantity() + "x : | "   + product.getProductId() +". " + product.getName()  + " | " 
				+ orderItem.getOrderItemPrice() + " | " + totalOrderItemPrice + " Euro");
	}
	
	private void printOrderInfoFooter(Restaurant restaurant, Order order, Location location) {
		IOrderCalculator orderCalculator = getOrderCalculator(location);
		OrderAmount orderAmount = orderCalculator.calculateOrderAmount(order);
		int vatRate = (int) orderCalculator.getVATRate(false);

		 System.out.println("----------------------------------------------");
		 System.out.println("The total price of the order is: ");
		 System.out.println("SUB TOTAL:  " + orderAmount.getTotalOrderAmount() + " Euro.");
		 // dynamic vat rate print based on vat rate parameter
		 System.out.println("VAT: " + vatRate + " %: " + orderAmount.getTotalOrderAmountVAT() + " Euro.");
		 System.out.println("TOTAL: " + orderAmount.getTotalOrderAmountWithVAT() + " Euro.");
		 System.out.println("----------------------------------------------");
		 System.out.println(restaurant.getName() + " in " + restaurant.getAddress());
	}
	
	
	private static IOrderCalculator getOrderCalculator(Location currentLocation) {
		
		if(currentLocation == null) {
			throw new IllegalArgumentException("Current lcoation must not be null!");
		}
		else
		switch(currentLocation) {
		case KOSOVO:
			return new OrderCalculatorKS();
		case GERMANY:
			return new OrderCalculatorGER();
			default:
				System.err.println("Current location is invalid ");
				return null;
		}	
	}
	
	public void printOrderInfo(Client client, Restaurant restaurant, Order order, Location location) {
		IOrderCalculator orderCalculator = getOrderCalculator(location);
		printOrderInfoHeader(client);
		ArrayList<OrderItem> orderProducts = order.getOrderItems();
		
		for(OrderItem orderItem : orderProducts) {
			orderCalculator.calculateOrderItemPrice(orderItem);
			printOrderItemInfo(orderItem);
		}
		printOrderInfoFooter(restaurant, order, location);	  
	}
}