package org.main.java.org.makerminds.jcoaching.restaurantapp.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.makerminds.jcoaching.restaurantapp.controller.MenuImporter;
import org.makerminds.jcoaching.restaurantapp.model.Menu;
import org.makerminds.jcoaching.restaurantapp.model.product.Product;

import java.awt.BorderLayout;
import javax.swing.JButton;

public class RestaurantAppGUI {

	private JFrame frame;
	//creating DefaultTableModel menuDataTableModel as an instance variable
	private DefaultTableModel menuDataTableModel = new DefaultTableModel();
	//creating a constant MENU_FILE_PATH to provide the path of the menu file
	private final String MENU_FILE_PATH = "/pizza-menu.txt";
	//creating the boolean fromFile
	private boolean fromFile = true;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RestaurantAppGUI window = new RestaurantAppGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RestaurantAppGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// creating the first Swing element --> a JLabel
		JLabel applicationNameLabel = new JLabel("RestaurantApp (JCoaching)");
		applicationNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(applicationNameLabel, BorderLayout.NORTH);
		
		
		// create JTable to display the menu data from backend
		prepareMenuDataForTable();
		JTable table = new JTable(menuDataTableModel);
		
		// create a scroll pane to add the table to be able to see the Header
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(BorderFactory.createTitledBorder("Restaurant Menu"));
		
		// create a panel so the table looks even more neat and organized within the frame
		JPanel panel = new JPanel();
		panel.add(scrollPane);
		
		//creating a JButoon to switch between menus
		JButton switchMenuButton = createSwitchMenuButton(panel);
		panel.add(switchMenuButton);
		frame.getContentPane().add(panel);
		
	}

	
	private void prepareMenuDataForTable() {
		//create the data for table
		String[][] menuArray = createMenuArray();
		// create table Header
		String[] tableHeader = {"ID", "Name", "Price"};
		menuDataTableModel.setDataVector(menuArray, tableHeader);
	}
	
	private Menu getMenu() {
		Menu menu;
		if(fromFile) {
			MenuImporter importer = new MenuImporter();
			menu = importer.importMenu(MENU_FILE_PATH);
		} else {
			menu = new Menu();
			menu.initializeMenuProducts();			
		}
		return menu;
			
		
	}
	
	// created method to create a switch menu button
	private JButton createSwitchMenuButton(JPanel jPanel) {
		JButton switchMenuButton = new JButton("Switch Menu");
		switchMenuButton.setBounds(103, 115, 91, 36);
		switchMenuButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fromFile = fromFile == false ? true : false;
				prepareMenuDataForTable();
			}
		});
		return switchMenuButton;
	}
	
	private String[][] createMenuArray() {
		
		Menu menu = getMenu();
		
		HashMap<Integer, Product> menuItems = menu.getMenuItems();
		String[][] menuArray = new String[menuItems.size()][3];
		
		int i = 0;
		for(Entry<Integer, Product> menuItem : menuItems.entrySet()) {
			Product product = menuItem.getValue();
			menuArray[i][0] = Integer.toString(product.getProductId());
			menuArray[i][1] = product.getName();
			menuArray[i][2] = Double.toString(product.getPrice());
			i++;
		}
		return menuArray;
			
		
	
	}
}


















