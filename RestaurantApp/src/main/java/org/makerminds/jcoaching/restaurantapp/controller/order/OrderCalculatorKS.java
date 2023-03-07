package org.makerminds.jcoaching.restaurantapp.controller.order;

import java.util.ArrayList;

import org.makerminds.jcoaching.restaurantapp.exceptions.InvalidOrderItemSizeException;
import org.makerminds.jcoaching.restaurantapp.model.order.Order;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderAmount;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItem;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItemSize;
import org.makerminds.jcoaching.restaurantapp.model.product.Product;

public class OrderCalculatorKS extends AbstractOrderCalculator {
	
	private final double VAT_RATE = 0.18;

	public double getSizeRateAmount(OrderItemSize orderItemSize) {

		switch(orderItemSize) {
			case SMALL: 
				return 0.8;
			case MEDIUM:
				return 1;
			case LARGE:
				return 1.25;
			case XXL:
				return 1.3;	
			default:
				throw new InvalidOrderItemSizeException("NO VALID ORDER ITEM SIZE: " + orderItemSize);
		}
	}
	
	

	@Override
	protected double getVATRate() {
		return VAT_RATE;
	}

}

