package org.makerminds.jcoaching.restaurantapp.controller.menu;

import java.util.Map.Entry;

import org.makerminds.jcoaching.restaurantapp.model.Menu;
import org.makerminds.jcoaching.restaurantapp.model.product.Product;

import java.util.Set;

public class MenuPrinter {
	
	public void printMenu(Menu menu) { 
		
		System.out.println("--------------MENU----------------------------");
		for(Entry<Integer, Product> menuEntry : menu.getMenuItems().entrySet()) {
			Product menuItem = menuEntry.getValue();
			System.out.println(menuItem.getProductId() + " . " + menuItem.getName() + " | " + menuItem.getPrice() + " Euro.");
		}
			
			System.out.println("----------------------------------------------");
			System.out.println(" ");
			
	}
}


		
	
