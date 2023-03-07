package org.makerminds.jcoaching.restaurantapp.controller.order;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItemSize;

public class OrderCalculatorGERTest {

	OrderCalculatorGER orderCalculatorGER = new OrderCalculatorGER();
	
	@Test
	public void testGetVatRate() {
		double vatRate = orderCalculatorGER.getVATRate();
		Assertions.assertEquals(0.19, vatRate);
	}
	
	@Test
	public void testGetSizeRateAmount() {
		double sizeRateAmount = orderCalculatorGER.getSizeRateAmount(OrderItemSize.SMALL);
		Assertions.assertEquals(0.8, sizeRateAmount);
		
		double sizeRateAmountForMediumSize = orderCalculatorGER.getSizeRateAmount(OrderItemSize.MEDIUM);
		Assertions.assertEquals(1, sizeRateAmountForMediumSize);
		
		double sizeRateAmountForLargeSize = orderCalculatorGER.getSizeRateAmount(OrderItemSize.LARGE);
		Assertions.assertEquals(1.25, sizeRateAmountForLargeSize);
		
		double sizeRateAmountForXXLSize = orderCalculatorGER.getSizeRateAmount(OrderItemSize.XXL);
		Assertions.assertEquals(1.3, sizeRateAmountForXXLSize);
	}
}

		
		
	
	
	

