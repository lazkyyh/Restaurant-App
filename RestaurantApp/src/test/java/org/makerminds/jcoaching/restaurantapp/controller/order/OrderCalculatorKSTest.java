package org.makerminds.jcoaching.restaurantapp.controller.order;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItemSize;

public class OrderCalculatorKSTest {
	
	OrderCalculatorKS orderCalculatorKS = new OrderCalculatorKS();
	
	
	@Test
	public void testGetVatRAte() {
		double vatRate = orderCalculatorKS.getVATRate();
		Assertions.assertEquals(0.18, vatRate);
	}
	@Test
	public void testGetSizeRateAmount() {
		double sizeRateAmount = orderCalculatorKS.getSizeRateAmount(OrderItemSize.SMALL);
		Assertions.assertEquals(0.8, sizeRateAmount);
		
		double sizeRateAmountForMediumSize = orderCalculatorKS.getSizeRateAmount(OrderItemSize.MEDIUM);
		Assertions.assertEquals(1, sizeRateAmountForMediumSize);
		
		double sizeRateAmountForLargeSize = orderCalculatorKS.getSizeRateAmount(OrderItemSize.LARGE);
		Assertions.assertEquals(1.25, sizeRateAmountForLargeSize);
		
		double sizeRateAmountForXXLSize = orderCalculatorKS.getSizeRateAmount(OrderItemSize.XXL);
		Assertions.assertEquals(1.3, sizeRateAmountForXXLSize);
	}
}
