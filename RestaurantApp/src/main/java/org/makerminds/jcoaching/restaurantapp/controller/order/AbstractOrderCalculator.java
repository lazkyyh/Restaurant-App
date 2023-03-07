package org.makerminds.jcoaching.restaurantapp.controller.order;

import java.util.ArrayList;

import org.makerminds.jcoaching.restaurantapp.exceptions.InvalidOrderItemSizeException;
import org.makerminds.jcoaching.restaurantapp.model.order.Order;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderAmount;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItem;
import org.makerminds.jcoaching.restaurantapp.model.product.Product;

public abstract class AbstractOrderCalculator implements IOrderCalculator {

	protected abstract double getVATRate();
		
	public double getVATRate(boolean decimal) {	
	if(decimal) {
		return getVATRate();
	}
	else {	
		return getVATRate() * 100;
		}
	}

	/** 
	*calculates the total order amount of the given order. 
	*
	* @param the order the total amount should be calculated from
	* @return total order amount
	*/
	public double calculatorTotalOrderAmount(Order order) {
		ArrayList<OrderItem> orderItems = order.getOrderItems();
		double totalOrderAmount = 0.0;
		
		for(OrderItem orderItem : orderItems) {
			totalOrderAmount += calculateOrderItemPrice(orderItem);
		}
		return totalOrderAmount;
	}

	public double calculateOrderItemPrice(OrderItem orderItem) {
		double orderItemPriceIncludingSizeRate = calculateOrderItemPriceIncludingSizeRate(orderItem);
		return orderItemPriceIncludingSizeRate * orderItem.getQuantity();
	}

	private double calculateOrderItemPriceIncludingSizeRate(OrderItem orderItem) {
		// default size rate amount set to 1 (100%)
		double sizeRateAmount = 1;
		// exception handling with try-catch
		try {
			sizeRateAmount = getSizeRateAmount(orderItem.getOrderItemSize());
		} catch (InvalidOrderItemSizeException e) {
			System.out.println("No valid order item size for item" + orderItem.getProduct().getName() 
			+ ". Default size rate amount (100%) will be applied.");
		}
		
		Product product = orderItem.getProduct();
		double totalOrderItemPriceSingle =  product.getPrice() * sizeRateAmount;
		orderItem.setOrderItemPrice(totalOrderItemPriceSingle);
		return totalOrderItemPriceSingle;
	}
	
	/**
	 * calculates the VAT amount of the given total order amount.
	 *
	 * @param total order amount
	 * @return total order amount with VAT
	 */
	public double calculateTotalOrderAmountVAT(double totalOrderAmount) {
		return totalOrderAmount * getVATRate();
	}
	
	public OrderAmount calculateOrderAmount(Order order) {
		// call the method to calculate the total order amount from object OrderCalculator 
		double totalOrderAmount = calculatorTotalOrderAmount(order);
		// calculate also the VAT amount and add teh total order amount with VAT as an own variable
		double totalOrderAmountVAT =  calculateTotalOrderAmountVAT(totalOrderAmount);
		double totalOrderAmountWithVAT = totalOrderAmount + totalOrderAmountVAT;
		
		OrderAmount orderAmount = new OrderAmount(totalOrderAmount, totalOrderAmountVAT, totalOrderAmountWithVAT);
		return orderAmount;
	}
	
	
	
}
	





























