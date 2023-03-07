package org.makerminds.jcoaching.restaurantapp.controller.order;

import java.util.ArrayList;

import org.makerminds.jcoaching.restaurantapp.model.Menu;
import org.makerminds.jcoaching.restaurantapp.model.order.Order;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItem;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItemSize;
import org.makerminds.jcoaching.restaurantapp.model.product.Drink;
import org.makerminds.jcoaching.restaurantapp.model.product.Meal;
import org.makerminds.jcoaching.restaurantapp.model.product.Product;

public class OrderManager {

	
	//switched from order array to an Array list
	private ArrayList<Order> orders = new ArrayList<>();

	//getter for order Array list
	public ArrayList<Order> getOrders() {
		return orders;
	}
	
	
	
	public Order createOrder(Menu menu) {
		
		Order order = new Order();
	
		ArrayList<OrderItem> orderItems = order.getOrderItems();
		addorderItems(order, menu.getMenuItems().get(100), 1, OrderItemSize.XXL);
		addorderItems(order, menu.getMenuItems().get(101), 2, OrderItemSize.MEDIUM);
		addorderItems(order, menu.getMenuItems().get(200), 1, OrderItemSize.LARGE);
		addorderItems(order, menu.getMenuItems().get(201), 2, OrderItemSize.SMALL);

		
		return order;

		
	}

	private void addorderItems(Order order, Product product, int quantity, OrderItemSize orderItemSize) {
		
		OrderItem orderItemMeal = createOrderItem(product, orderItemSize, quantity);
		order.getOrderItems().add(orderItemMeal);
	}

	private OrderItem createOrderItem(Product product, OrderItemSize orderItemSize, int quantity) {
		//provided new method to create order item meal
		return new OrderItem(product, orderItemSize, quantity);
	}
		
	
	
}

