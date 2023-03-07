package org.main.java.org.makerminds.jcoaching.restaurantapp;


import java.util.Scanner;

import org.makerminds.jcoaching.restaurantapp.controller.LocationManager;
import org.makerminds.jcoaching.restaurantapp.controller.menu.MenuPrinter;
import org.makerminds.jcoaching.restaurantapp.controller.order.OrderManager;
import org.makerminds.jcoaching.restaurantapp.controller.order.OrderPrinter;
import org.makerminds.jcoaching.restaurantapp.enums.ApplicationMode;
import org.makerminds.jcoaching.restaurantapp.enums.Location;
import org.makerminds.jcoaching.restaurantapp.model.Client;
import org.makerminds.jcoaching.restaurantapp.model.Menu;
import org.makerminds.jcoaching.restaurantapp.model.Restaurant;
import org.makerminds.jcoaching.restaurantapp.model.order.Order;


public class RestaurantApp {

	
	private static Location currentLocation;

	// start of application - Java main method
	 
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String []args) { 
			
		ApplicationMode selectedApplicationMode = getApplicationMode();
		getCurrentLocation();
		validateApplicationMode(selectedApplicationMode);
		
	}  // end of method
	
	private static void getCurrentLocation() {
			
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("Please select your location (type number): ").append(System.lineSeparator())
		.append("1. " + Location.KOSOVO.name()).append(System.lineSeparator())
		.append("2. " + Location.GERMANY.name());
		
		System.out.println(stringBuilder.toString());
		
		int selectedLocataionId = scanner.nextInt();
		
		currentLocation = LocationManager.getLocationFromString(selectedLocataionId);
	}
	
	private static ApplicationMode getApplicationMode() {
		
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("Please select an application mode (type number): ").append(System.lineSeparator())
		.append("1. " + ApplicationMode.ORDER.name()).append(System.lineSeparator())
		.append("2. " + ApplicationMode.TABLERESERVATION.name());
		
		System.out.println(stringBuilder.toString());
		int selectedApplicationModeId = scanner.nextInt();
		ApplicationMode selectedApplicationMode = getSelectedApplicationModeFromId(selectedApplicationModeId);
		
		return selectedApplicationMode;
	}

	private static ApplicationMode getSelectedApplicationModeFromId(int selectedApplicationModeId) {
		
		switch (selectedApplicationModeId) {
		case 1:
			return ApplicationMode.ORDER;
		case 2:
			return ApplicationMode.TABLERESERVATION;
			default:
				return null;
		}
		
	}
	
	private static void runTableReservationProcess() {
		
		System.out.println("Table number 3 was reserved sucessfulLy!");  	
	}
	
	
	private static void validateApplicationMode(ApplicationMode applicationMode) {
		
		switch(applicationMode) { 
		case ORDER: 
			//Created new method for order process
			runOrderProcess();
			break;
		case TABLERESERVATION:
			runTableReservationProcess();
			//Created new method for table reservation process
			break;
			default: throw new IllegalArgumentException("NO VALIC APPLICATION MODE SELECTED! ");
		}
		
		
	}

	private static void runOrderProcess() {
		
		Restaurant restaurant = new Restaurant("Ora", "Rruga e Restaurantit" );

		Client client = new Client("Filan Fisteku", "+38348177122");
		
		Menu menu = new Menu();
		menu.initializeMenuProducts();
		
		MenuPrinter menuPrinter = new MenuPrinter();
		menuPrinter.printMenu(menu);

		OrderManager orderManager = new OrderManager(); 
		Order order =  orderManager.createOrder(menu);
		
		orderManager.getOrders().add(order);
		
		calculateAnddPrintOrderDetails(restaurant, client, order);
	}
		
	private static void calculateAnddPrintOrderDetails(Restaurant restaurant, Client client, Order order) {
			
		OrderPrinter orderPrinter = new OrderPrinter();
		orderPrinter.printOrderInfo(client, restaurant, order, currentLocation);
			
	}
	
		
	
}


