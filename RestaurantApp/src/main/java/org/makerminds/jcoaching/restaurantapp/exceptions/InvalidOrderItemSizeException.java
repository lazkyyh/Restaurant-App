package org.makerminds.jcoaching.restaurantapp.exceptions;

@SuppressWarnings("serial")
public class InvalidOrderItemSizeException extends RuntimeException{

	public InvalidOrderItemSizeException(String message) {
		super(message);
	}

}
