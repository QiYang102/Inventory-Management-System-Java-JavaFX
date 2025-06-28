package Stock_Management_System;

import Product_Class.Fan;
import Product_Class.Product;
import Product_Class.Refrigerator;
import Product_Class.TV;
import Product_Class.WashingMachine;

import java.util.ArrayList;
import java.util.Scanner;

import Functionality_Class.Validation;
import Functionality_Class.ConsoleUtils;

public class StockManagement {
	//Private variable 
	private static int product_counter = 0;	
	
	/* -------------------------------------- METHODS -------------------------------------- */
    public static int getProductNum(Scanner scanner) {
        int int_input;
        final int first_option = 0;

        int_input = Validation.intInputValidation(scanner, first_option, "How many items to add?: ");

        return int_input;
    }
    
    /*
     * ====================================== Option 1 (View Product) ======================================
     */
    public static void viewProduct(ArrayList<Product> productList, Scanner scanner) {

        if (productList.isEmpty()) {
            System.out.println("\nThere is no product!");
            System.out.println("Please add a product first!");
        }
        else {
            System.out.println("\nProduct List:");
            System.out.println("----------------------------------------");
            
         // Loop through the product list and print each product
            for (Product p : productList) {
                System.out.println(p);
            }
        }
    }
    
    /*
     * ====================================== Option 2 (Product Operation) ======================================
     */
    public static void productOperation(ArrayList<Product> productList, Scanner scanner ) {
        
            int int_input = 0;

            do {
                System.out.println("\nWhat would you like to perform?");
                System.out.println("1. Add Product");
                System.out.println("2. Remove Product");
                System.out.println("3. Edit Product Details");
                System.out.println("4. Continue Product");
                System.out.println("5. Discontinue Product");
                System.out.println("0. Back");


                int_input = Validation.intInputValidation(scanner, 0, 5, "Input: ");
                switch (int_input) {
                    // Go back
                    case 0: {
                        break;
                    }
                    // Adding Product
                    case 1: {
                        addProduct(productList, scanner);
                        ConsoleUtils.pauseScreen(scanner);
                        break;
                    }
                    // Removing Product
                    case 2: {
                        removeProduct(productList, scanner);
                        ConsoleUtils.pauseScreen(scanner);
                        break;
                    }
                    // Editing Product
                    case 3: {
                        editProduct(productList, scanner);
                        ConsoleUtils.pauseScreen(scanner);
                        break;
                    }
                    // Continuing Product
                    case 4: {
                        continueProduct(productList, scanner);
                        ConsoleUtils.pauseScreen(scanner);
                        break;
                    }
                    // Discontinuing Product
                    case 5: {
                        discontinueProduct(productList, scanner);
                        ConsoleUtils.pauseScreen(scanner);
                        break;
                    }
                }
            } while (int_input != 0);
        }
    
    /*
     * ====================================== Option 2.1 (Add product) ======================================
     */
    public static void addProduct(ArrayList<Product> productList, Scanner scanner) {
        int int_input, quantity_to_add = 0;
        final int first_option = 1, last_option = 4;

        quantity_to_add = Validation.intInputValidation(scanner, 1, "How many items to add?: ");

        for (int i = 0; i < quantity_to_add; i++) {

            // Displaying Available Products and let user chose
            int_input = Validation.intInputValidation(scanner, first_option, last_option, "\nPlease select which product to add" +
																		            	  "\n1. TV" +
																		                  "\n2. Refrigerator" +
																		                  "\n3. Washing Machine" +
																		                  "\n4. Fan" +
																		                  "\nInput: ");
            
            int product_num = int_input;
            System.out.println();
            
            switch (product_num) {
                // TV
                case 1: {
                    String name, screen_type, resolution, display_size;
                    int quantity = 0;
                    double price = 0d;
                    
                    while(true) {
                        System.out.print("Name              : ");
                        name = scanner.nextLine().trim();
                        
                        if(name.isEmpty()) {
                        	System.out.println("Name CANNOT be empty!!");
                        }
                        else {
                        	break;
                        }
                    }
                    
                    while(true) {
        	            System.out.print("Screen type       : ");
        	            screen_type = scanner.nextLine().trim();
                        
                        if(screen_type.isEmpty()) {
                        	System.out.println("Screen type CANNOT be empty!!");
                        }
                        else {
                        	break;
                        }
                    }    	            
    	            
                    while(true) {
                        System.out.print("Screen resolution : ");
                        resolution = scanner.nextLine().trim();
                        
                        if(resolution.isEmpty()) {
                        	System.out.println("Resolution CANNOT be empty!!");
                        }
                        else {
                        	break;
                        }
                    }    	            

                    while(true) {
                        System.out.print("Display size      : ");
                        display_size = scanner.nextLine().trim();
                        
                        if(display_size.isEmpty()) {
                        	System.out.println("Display size CANNOT be empty!");
                        }
                        else {
                        	break;
                        }
                    }                      

                    quantity = Validation.intInputValidation(scanner, 1, "Quantity          : ");
                    price = Validation.doubleInputValidation(scanner, 0d, "Price             : ");
                    
                    productList.add(new TV(product_counter++, name, quantity, price, screen_type, resolution, display_size));
                    System.out.println("You have successfully added a TV-type product to the list!");
                    break;
                }

                // Refrigerator
                case 2: {
                    String name, door_design, color;
                    double capacity = 0d, price = 0d;
                    int quantity = 0;
                    
                    while(true) {
                        System.out.print("Name              : ");
                        name = scanner.nextLine().trim();
                        
                        if(name.isEmpty()) {
                        	System.out.println("Name CANNOT be empty!");
                        }
                        else {
                        	break;
                        }
                    }

                    while(true) {
        	            System.out.print("Door design       : ");
        	            door_design = scanner.nextLine().trim();
                        
                        if(door_design.isEmpty()) {
                        	System.out.println("Door design CANNOT be empty!");
                        }
                        else {
                        	break;
                        }
                    }
                    
                    while(true) {
                        System.out.print("Color             : ");
                        color = scanner.nextLine().trim();
                        
                        if(color.isEmpty()) {
                        	System.out.println("Color CANNOT be empty!");
                        }
                        else {
                        	break;
                        }
                    }   	            
                    										
                    capacity = Validation.doubleInputValidation(scanner, 0d, "Capacity          : ");
                    quantity = Validation.intInputValidation(scanner, 1, "Quantity          : ");
                    price = Validation.doubleInputValidation(scanner, 0d, "Price             : ");
                    
                    productList.add(new Refrigerator(product_counter++, name, quantity, price, door_design, color, capacity));
                    System.out.println("You have successfully added a refrigerator-type product to the list!");
                    break;
                }

                // Washing Machine
                case 3: {
                    String name, loading_type, noise_level;
                    int quantity = 0, spin_speed = 0;
                    double price = 0d;
                    
                    while(true) {
                        System.out.print("Name              : ");
                        name = scanner.nextLine().trim();
                        
                        if(name.isEmpty()) {
                        	System.out.println("Name CANNOT be empty!");
                        }
                        else {
                        	break;
                        }
                    }
                    
                    while(true) {
        	            System.out.print("Loading type      : ");
        	            loading_type = scanner.nextLine().trim();
                        
                        if(loading_type.isEmpty()) {
                        	System.out.println("Loading type CANNOT be empty!");
                        }
                        else {
                        	break;
                        }
                    }
                    
                    while(true) {
                        System.out.print("Noise level       : ");
                        noise_level = scanner.nextLine().trim();
                        
                        if(noise_level.isEmpty()) {
                        	System.out.println("Noise level CANNOT be empty!");
                        }
                        else {
                        	break;
                        }
                    }
                      	         

                    spin_speed = Validation.intInputValidation(scanner, 0, "Spin speed        : ");
                    quantity = Validation.intInputValidation(scanner, 1, "Quantity          : ");
                    price = Validation.doubleInputValidation(scanner, 0d, "Price             : ");

                    productList.add(new WashingMachine(product_counter++, name, quantity, price, spin_speed, loading_type, noise_level));
                    System.out.println("You have successfully added a washing machine-type product to the list!");
                    break;
                }
                
                //Fan
                case 4: {
                    String name, fanType;
                    int speedLevels, powerConsumption, quantity;
                    double price;

                    while(true) {
                        System.out.print("Name                  : ");
                        name = scanner.nextLine().trim();
                        
                        if(name.isEmpty()) {
                        	System.out.println("Name CANNOT be empty!");
                        }
                        else {
                        	break;
                        }
                    }

                    while(true) {
                        System.out.print("Fan type              : ");
                        fanType = scanner.nextLine().trim();
                        
                        if(fanType.isEmpty()) {
                        	System.out.println("Fan type CANNOT be empty!");
                        }
                        else {
                        	break;
                        }
                    }
                             
                    speedLevels = Validation.intInputValidation(scanner, 1, "Speed levels          : ");
                    powerConsumption = Validation.intInputValidation(scanner, 1, "Power consumption (W) : ");
                    quantity = Validation.intInputValidation(scanner, 1, "Quantity              : ");
                    price = Validation.doubleInputValidation(scanner, 0d, "Price                 : ");
                    productList.add(new Fan(product_counter++, name, quantity, price, speedLevels, fanType, powerConsumption));
                    System.out.println("You have successfully added a fan-type product to the list!");
                    break;
                }
            }
        }
    }

    
    /*
     * ====================================== Option 2.2 (Remove product) ======================================
     */
    public static void removeProduct(ArrayList<Product> productList, Scanner scanner) {
        if (productList.isEmpty()) {
            System.out.println("\nThere is no product!");
            System.out.println("Please add a product first!");
        }
        else {
            int int_input = -1;
            int product_index = -1;
            
            System.out.println("\nProduct(s) Available: ");
            System.out.println("----------------------------------------");
            for (int i = 0; i < productList.size(); i++) {
                System.out.println("Product ID  : " + productList.get(i).getProductID());
                System.out.println("Name        : " + productList.get(i).getProductName());
                System.out.println();
            }
            
            int_input = Validation.productValidation(productList, scanner, "Select the item number to remove the product: ");
            product_index = int_input;
            
            productList.remove(product_index);

            System.out.println("You have successfully removed the item number of " + int_input + " from the list!");
        }
    }

    
    /*
     * ====================================== Option 2.3 (Edit Product) ======================================
     */
    public static void editProduct(ArrayList<Product> productList, Scanner scanner) {
        if (productList.isEmpty()) {
            System.out.println("\nThere is no product!");
            System.out.println("Please add a product first!");
        }
        else {
        	System.out.println("\nProduct(s) Available: ");
            System.out.println("----------------------------------------");
            for (int i = 0; i < productList.size(); i++) {
                System.out.println("Product ID  : " + productList.get(i).getProductID());
                System.out.println("Name        : " + productList.get(i).getProductName());
                System.out.println();
            }
            
            int int_input = Validation.productValidation(productList, scanner, "Select the item number to edit detail: ");
            int product_index = int_input;

            // TV instance
            if (productList.get(product_index) instanceof TV) {
                TV thisTV = (TV) productList.get(product_index);

                // Displaying Edit Menu
                System.out.println("\nWhich detail do you want to update?");
                System.out.println("Please select 1 - 5 or 0 to back");
                System.out.println("1. Product name   : " + thisTV.getProductName());
                System.out.println("2. Screen type    : " + thisTV.getScreenType());
                System.out.println("3. Resolution     : " + thisTV.getResolution());
                System.out.println("4. Display size   : " + thisTV.getDisplaySize());
                System.out.println("5. Price          : " + String.format("%.2f", thisTV.getProductPrice()));
                System.out.println("0. Back");

                int int_option = Validation.intInputValidation(scanner, 0, 5, "Input: ");
                System.out.println();
                
                switch (int_option) {
                    // Go Back
                    case 0: {
                        break;
                    }
                    // Editing Name
                    case 1: {
                        String new_name;
                        System.out.println("Name: " + thisTV.getProductName());
                        while(true) {
                        	System.out.print("New name: ");
                        	new_name = scanner.nextLine().trim();
                            
                            if(new_name.isEmpty()) {
                            	System.out.println("Name CANNOT be empty!");
                            }
                            else {
                            	break;
                            }
                        }
                        System.out.print("You have successfully set it from " + thisTV.getProductName() + " to " + new_name + ".");
                        thisTV.setProductName(new_name);
                        break;
                    }
                    // Editing Screen Type
                    case 2: {
                        String new_screen_type;
                        System.out.println("Screen type: " + thisTV.getScreenType());
                        while(true) {
                            System.out.print("New screen type: ");
                            new_screen_type = scanner.nextLine().trim();
                            
                            if(new_screen_type.isEmpty()) {
                            	System.out.println("Screen type CANNOT be empty!");
                            }
                            else {
                            	break;
                            }
                        } 
                        System.out.print("You have successfully set it from " + thisTV.getScreenType() + " to " + new_screen_type + ".");
                        thisTV.setScreenType(new_screen_type);
                        break;
                    }
                    // Editing Screen Resolution
                    case 3: {
                        String new_resolution = thisTV.getResolution();
                        System.out.println("Screen resolution: " + thisTV.getResolution());
                        while(true) {
                            System.out.print("New resolution: ");
                            new_resolution = scanner.nextLine().trim();
                            
                            if(new_resolution.isEmpty()) {
                            	System.out.println("Resolution CANNOT be empty!");
                            }
                            else {
                            	break;
                            }
                        }    
                        System.out.print("You have successfully set it from " + thisTV.getResolution() + " to " + new_resolution + ".");
                        thisTV.setResolution(new_resolution);
                        break;
                    }
                    // Editing Display Size
                    case 4: {
                        String new_display_size = thisTV.getDisplaySize();
                        System.out.println("Screen display size: " + thisTV.getDisplaySize());
                        while(true) {
                            System.out.print("New display size: ");
                            new_display_size = scanner.nextLine().trim();
                            
                            if(new_display_size.isEmpty()) {
                            	System.out.println("Display size CANNOT be empty!");
                            }
                            else {
                            	break;
                            }
                        }  
                        System.out.print("You have successfully set it from " + thisTV.getDisplaySize() + " to " + new_display_size + ".");
                        thisTV.setResolution(new_display_size);
                        break;
                    }
                    // Editing Price
                    case 5: {
                        double new_price = thisTV.getProductPrice();
                        System.out.println("Price: " + thisTV.getProductPrice());
                        new_price = Validation.doubleInputValidation(scanner, 0d, "New price: ");
                        System.out.print("You have successfully set it from " + thisTV.getProductPrice() + " to " + new_price + ".");
                        thisTV.setProductPrice(new_price);
                        break;
                    }
                }
            }

            // Refrigerator instance
            else if (productList.get(product_index) instanceof Refrigerator) {
                Refrigerator thisRef = (Refrigerator) productList.get(product_index);
                System.out.println("\nWhich detail do you want to update?");
                System.out.println("1. Product name   : " + thisRef.getProductName());
                System.out.println("2. Door design    : " + thisRef.getDoorDesign());
                System.out.println("3. Color          : " + thisRef.getColor());
                System.out.println("4. Capacity       : " + thisRef.getStorageCapacity());
                System.out.println("5. Price          : " + String.format("%.2f", thisRef.getProductPrice()));
                System.out.println("0. Back");

                int int_option = Validation.intInputValidation(scanner, 0, 5, "Input: ");
                System.out.println();
                
                switch (int_option) {
                    // Go Back
                    case 0: {
                        break;
                    }
                    // Editing Name
                    case 1: {
                        String new_name;
                        System.out.println("Name: " + thisRef.getProductName());
                        while(true) {
                        	System.out.print("New name: ");
                        	new_name = scanner.nextLine().trim();
                            
                            if(new_name.isEmpty()) {
                            	System.out.println("Name CANNOT be empty!");
                            }
                            else {
                            	break;
                            }
                        }
                        System.out.print("You have successfully set it from " + thisRef.getProductName() + " to " + new_name + ".");
                        thisRef.setProductName(new_name);
                        break;
                    }
                    // Editing Door Design
                    case 2: {
                        String new_door_design;
                        System.out.println("Door design: " + thisRef.getDoorDesign());
                        while(true) {
                            System.out.print("New door design: ");
                            new_door_design = scanner.nextLine();
                            
                            if(new_door_design.isEmpty()) {
                            	System.out.println("Door design CANNOT be empty!");
                            }
                            else {
                            	break;
                            }
                        }
                        System.out.print("You have successfully set it from " + thisRef.getDoorDesign() + " to " + new_door_design + ".");
                        thisRef.setDoorDesign(new_door_design);
                        break;
                    }
                    // Editing Color
                    case 3: {
                        String new_color;
                        System.out.println("Color: " + thisRef.getColor());
                        while(true) {
                            System.out.print("New color: ");
                            new_color = scanner.nextLine();
                            
                            if(new_color.isEmpty()) {
                            	System.out.println("Color CANNOT be empty!");
                            }
                            else {
                            	break;
                            }
                        }   
                        System.out.print("You have successfully set it from " + thisRef.getColor() + " to " + new_color + ".");
                        thisRef.setColor(new_color);
                        break;
                    }
                    // Editing Capacity
                    case 4: {
                        double new_capacity = thisRef.getStorageCapacity();
                        System.out.println("Capacity: " + thisRef.getStorageCapacity());
                        new_capacity = Validation.doubleInputValidation(scanner, 0d, "New capacity: ");
                        System.out.print("You have successfully set it from " + thisRef.getStorageCapacity() + " to " + new_capacity + ".");
                        thisRef.setStorageCapacity(new_capacity);
                        break;
                    }
                    // Editing Price
                    case 5: {
                        double new_price = thisRef.getProductPrice();
                        System.out.println("Price: " + thisRef.getProductPrice());
                        new_price = Validation.doubleInputValidation(scanner, 0d, "New price: ");
                        System.out.print("You have successfully set it from " + thisRef.getProductPrice() + " to " + new_price + ".");
                        thisRef.setProductPrice(new_price);
                        break;
                    }
                }
            }
            // Washing Machine instance
            else if (productList.get(product_index) instanceof WashingMachine) {
                WashingMachine thisWM = (WashingMachine) productList.get(product_index);
                System.out.println("\nWhich detail do you want to update?");
                System.out.println("1. Product name   : " + thisWM.getProductName());
                System.out.println("2. Spin speed     : " + thisWM.getSpinSpeed());
                System.out.println("3. Loading type   : " + thisWM.getLoadingType());
                System.out.println("4. Noise level    : " + thisWM.getNoiseLevel());
                System.out.println("5. Price          : " + String.format("%.2f", thisWM.getProductPrice()));
                System.out.println("0. Back");
                
                int int_option = Validation.intInputValidation(scanner, 0, 5, "Input: ");
                System.out.println();
                
                switch (int_option) {
                    // Go Back
                    case 0: {
                        break;
                    }
                    // Editing Name
                    case 1: {
                        String new_name;
                        System.out.println("Name: " + thisWM.getProductName());
                        while(true) {
                        	System.out.print("New name: ");
                        	new_name = scanner.nextLine().trim();
                            
                            if(new_name.isEmpty()) {
                            	System.out.println("Name CANNOT be empty!");
                            }
                            else {
                            	break;
                            }
                        }
                        System.out.print("You have successfully set it from " + thisWM.getProductName() + " to " + new_name + ".");
                        thisWM.setProductName(new_name);
                        break;
                    }
                    // Editing Spin Speed
                    case 2: {
                        int new_spin_speed = thisWM.getSpinSpeed();
                        System.out.println("Spin speed: " + thisWM.getSpinSpeed());
                        new_spin_speed = Validation.intInputValidation(scanner, 0, "New spin speed: ");
                        System.out.print("You have successfully set it from " + thisWM.getSpinSpeed() + " to " + new_spin_speed + ".");
                        thisWM.setSpinSpeed(new_spin_speed);
                        break;
                    }
                    // Editing Loading Type
                    case 3: {
                        String new_loading_type;
                        System.out.println("Loading type: " + thisWM.getLoadingType());
                        while(true) {
                            System.out.print("New loading type: ");
                            new_loading_type = scanner.nextLine();
                            
                            if(new_loading_type.isEmpty()) {
                            	System.out.println("Loading type CANNOT be empty!");
                            }
                            else {
                            	break;
                            }
                        }
                        System.out.print("You have successfully set it from " + thisWM.getLoadingType() + " to " + new_loading_type + ".");
                        thisWM.setLoadingType(new_loading_type);
                        break;
                    }
                    // Editing Noise Level
                    case 4: {
                        String new_noise_level;
                        System.out.println("Noise level: " + thisWM.getNoiseLevel());
                        while(true) {
                            System.out.print("New noise level: ");
                            new_noise_level = scanner.nextLine();
                            
                            if(new_noise_level.isEmpty()) {
                            	System.out.println("Noise level CANNOT be empty!");
                            }
                            else {
                            	break;
                            }
                        }
                        System.out.print("You have successfully set it from " + thisWM.getNoiseLevel() + " to " + new_noise_level + ".");
                        thisWM.setNoiseLevel(new_noise_level);
                        break;
                    }
                    // Editing Price
                    case 5: {
                        double new_price = thisWM.getProductPrice();
                        System.out.println("Price: " + thisWM.getProductPrice());
                        new_price = Validation.doubleInputValidation(scanner, 0d, "New price: ");
                        System.out.print("You have successfully set it from " + thisWM.getProductPrice() + " to " + new_price + ".");
                        thisWM.setProductPrice(new_price);
                        break;
                    }
                }
            }
            else if (productList.get(product_index) instanceof Fan) {
                Fan thisFan = (Fan) productList.get(product_index);
                System.out.println("\nWhich detail do you want to update?");
                System.out.println("1. Product name     : " + thisFan.getProductName());
                System.out.println("2. Fan type         : " + thisFan.getFanType());
                System.out.println("3. Speed levels     : " + thisFan.getSpeedLevels());
                System.out.println("4. Power consumption: " + thisFan.getPowerConsumption() + " W");
                System.out.println("5. Price            : " + String.format("%.2f", thisFan.getProductPrice()));
                System.out.println("0. Back");

                int int_option = Validation.intInputValidation(scanner, 0, 5, "Input: ");
                System.out.println();

                switch (int_option) {
                	// Go Back
                    case 0: {
                        break;
                    }
                    // Edit name
                    case 1: {
                        String new_name;
                        System.out.println("Name: " + thisFan.getProductName());
                        while(true) {
                        	System.out.print("New name: ");
                        	new_name = scanner.nextLine().trim();
                            
                            if(new_name.isEmpty()) {
                            	System.out.println("Name CANNOT be empty!");
                            }
                            else {
                            	break;
                            }
                        }
                        System.out.println("You have successfully set it from " + thisFan.getProductName() + " to " + new_name + ".");
                        thisFan.setProductName(new_name);
                        break;
                    }
                    // Edit Fan Type
                    case 2: {
                        String new_type;
                        System.out.println("Fan type: " + thisFan.getFanType());
                        while(true) {
                            System.out.print("New fan type: ");
                            new_type = scanner.nextLine().trim();
                            
                            if(new_type.isEmpty()) {
                            	System.out.println("Fan type CANNOT be empty!");
                            }
                            else {
                            	break;
                            }
                        }
                        System.out.println("You have successfully set it from " + thisFan.getFanType() + " to " + new_type + ".");
                        thisFan.setFanType(new_type);
                        break;
                    }
                    // Edit Speed Level
                    case 3: {
                        int new_speed;
                        System.out.println("Speed levels: " + thisFan.getSpeedLevels());
                        new_speed = Validation.intInputValidation(scanner, 1, 10, "New speed levels (1-10): ");
                        System.out.println("You have successfully set it from " + thisFan.getSpeedLevels() + " to " + new_speed + ".");
                        thisFan.setSpeedLevels(new_speed);
                        break;
                    }
                    // Edit Power Consumption
                    case 4: {
                        int new_power;
                        System.out.println("Power consumption (W): " + thisFan.getPowerConsumption());
                        new_power = Validation.intInputValidation(scanner, 1, 500, "New power consumption (W): ");
                        System.out.println("You have successfully set it from " + thisFan.getPowerConsumption() + "W to " + new_power + "W.");
                        thisFan.setPowerConsumption(new_power);
                        break;
                    }
                    // Edit price
                    case 5: {
                        double new_price = thisFan.getProductPrice();
                        System.out.println("Price: " + thisFan.getProductPrice());
                        new_price = Validation.doubleInputValidation(scanner, 0d, "New price: ");
                        System.out.println("You have successfully set it from " + thisFan.getProductPrice() + " to " + new_price + ".");
                        thisFan.setProductPrice(new_price);
                        break;
                    }
                }
            }
        }
    }

    /*
     * ====================================== Option 2.4 (Continue Product) ======================================
     */
    public static void continueProduct(ArrayList<Product> productList, Scanner scanner) {

        if (productList.isEmpty()) {
            System.out.println("\nThere is no product!");
            System.out.println("Please add a product first!");
        }
        else {
            boolean isAllActivated = true;
            int int_input, index = -1;
            ArrayList<Product> temp_productList = new ArrayList<>();
            
            System.out.println();
         // Showing Current Inactive Product
            for (int i = 0; i < productList.size(); i++) {
                if (!productList.get(i).getProductStatus()) {
                    isAllActivated = false;
                    System.out.println(productList.get(i).toString());
                    temp_productList.add(productList.get(i));
                }
            }
            System.out.println();

            if (isAllActivated) {
                System.out.println("\nAll product(s) is/are activated. Nothing to be continued.");
            } 
            else {
                System.out.println();
                int_input = Validation.productValidation(temp_productList, scanner, "Select the item number to continue the product: ");
                for(int i = 0; i < productList.size(); i++) {
                	if(productList.get(i).getProductID() == temp_productList.get(int_input).getProductID()) {
                		index = i;
                	}
                }
                productList.get(index).setProductStatus(true);
                System.out.println("You have successfully continued the product with the item number of " + productList.get(index).getProductID() + ".");
            }
        }
    }


    /*
     * ====================================== Option 2.5 (Discontinue Product) ======================================
     */
    public static void discontinueProduct(ArrayList<Product> productList, Scanner scanner) {

        if (productList.isEmpty()) {
            System.out.println("\nThere is no product!");
            System.out.println("Please add a product first!");
        }
        else {
            int int_input, index = 1;
            boolean isAllInactivated = true;
            ArrayList<Product> temp_productList = new ArrayList<>();
            
            System.out.println();
            // Showing Current Active Product
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getProductStatus()) {
                    isAllInactivated = false;                  
                    System.out.println(productList.get(i).toString());
                    temp_productList.add(productList.get(i));
                }
            }
            System.out.println();
            
            if (isAllInactivated) {
                System.out.println("\nAll product(s) is/are inactivated. Nothing to be discontinued.");
            } 
            else {
                // Verifying Product Number
                System.out.println();
                int_input = Validation.productValidation(temp_productList, scanner, "Select the item number to discontinue the product: ");
                for(int i = 0; i < productList.size(); i++) {
                	if(productList.get(i).getProductID() == temp_productList.get(int_input).getProductID()) {
                		index = i;
                	}
                }
                productList.get(index).setProductStatus(false);
                System.out.println("You have successfully discontinued the product with the item number of " + productList.get(index).getProductID() + ".");
            }
        }
    }

    /*
     * ====================================== Option 3 (Add stock) ======================================
     */
    public static void addStock(ArrayList<Product> productList, Scanner scanner) {

        if (productList.isEmpty()) {
            System.out.println("\nThere is no product!");
            System.out.println("Please add a product first!");
        }
        else {
            int product_index, int_input, num_to_add;
            
            System.out.println("\nProduct(s) Available: ");
            System.out.println("----------------------------------------");
            for (int i = 0; i < productList.size(); i++) {
                System.out.println("ProductID     : " + productList.get(i).getProductID());
                System.out.println("Product Name  : " + productList.get(i).getProductName());
                System.out.println("Quantity      : " + productList.get(i).getProductQuantity());
                System.out.println();
            }

            System.out.println();

            // Verifying Product Number
            int_input = Validation.productValidation(productList, scanner, "Select the item number to add stock: ");
            product_index = int_input;
            System.out.println();

            // Verifying Valid Number
            System.out.println("You have selected " + productList.get(product_index).getProductName());
            System.out.println("----------------------------------------");
            System.out.println("ProductID\t: " + productList.get(product_index).getProductID());
            System.out.println("Quantity\t: " + productList.get(product_index).getProductQuantity());
            System.out.println();
            
            // Verifying Valid Number
            int_input = Validation.intInputValidation(scanner, 1, "How many stock to add?: ");
            num_to_add = int_input;

            // Adding Product
            productList.get(product_index).addStock(num_to_add);
        }
    }


    /*
     * ====================================== Option 4 (Deduct Stock) ======================================
     */
    public static void deductStock(ArrayList<Product> productList, Scanner scanner) {

        if (productList.isEmpty()) {
            System.out.println("\nThere is no product!");
            System.out.println("Please add a product first!");
        }
        else {
            int product_index, num_to_deduct, int_input;
            
            System.out.println("\nProduct(s) Available: ");
            System.out.println("----------------------------------------");
            for (int i = 0; i < productList.size(); i++) {
                System.out.println("ProductID     : " + productList.get(i).getProductID());
                System.out.println("Product Name  : " + productList.get(i).getProductName());
                System.out.println("Quantity      : " + productList.get(i).getProductQuantity());
                System.out.println();
            }

            // Verifying Product Number
            System.out.println();
            int_input = Validation.productValidation(productList, scanner, "Select the item number to deduct stock: ");
            product_index = int_input;
            System.out.println();

            // Verifying Valid Number
            System.out.println("You have selected " + productList.get(product_index).getProductName());
            System.out.println("----------------------------------------");
            System.out.println("ProductID\t: " + productList.get(product_index).getProductID());
            System.out.println("Quantity\t: " + productList.get(product_index).getProductQuantity());
            System.out.println();

            // Verifying Valid Number
            int_input = Validation.intInputValidation(scanner, 1, "How many stock to deduct?: ");
            num_to_deduct = int_input;

            // Deducting Product
            productList.get(product_index).deductStock(num_to_deduct);
        }
    }


    /*
     * ====================================== Option 5 (Generate report) ======================================
     */
    public static void generateReport(ArrayList<Product> productList) {

        if (productList.isEmpty()) {
            System.out.println("\nThere is no product!");
            System.out.println("Please add a product first!");
        }
        else {
            boolean hasTV = false, hasRef = false, hasWM = false, hasFan = false;
            double TVTotalValue = 0d, RefTotalValue = 0d, WMTotalValue = 0d, FanTotalValue = 0d;
            int TVQuantity = 0, RefQuantity = 0, WMQuantity = 0, FanQuantity = 0;
            int TVCount = 0, RefCount = 0, WMCount = 0, FanCount = 0;

            for (int i = 0; i < productList.size(); i++) {
                Product product = productList.get(i);
                if (product instanceof TV) {
                    TVTotalValue += product.getInventoryValue();
                    TVQuantity += product.getProductQuantity();
                    TVCount++;
                    hasTV = true;
                } 
                else if (product instanceof Refrigerator) {
                    RefTotalValue += product.getInventoryValue();
                    RefQuantity += product.getProductQuantity();
                    RefCount++;
                    hasRef = true;
                } 
                else if (product instanceof WashingMachine) {
                    WMTotalValue += product.getInventoryValue();
                    WMQuantity += product.getProductQuantity();
                    WMCount++;
                    hasWM = true;
                } 
                else if (product instanceof Fan) {
                    FanTotalValue += product.getInventoryValue();
                    FanQuantity += product.getProductQuantity();
                    FanCount++;
                    hasFan = true;
                }
            }

            if (hasTV) {
                System.out.println("\nTV");
                System.out.println("----------------------------------------");
                System.out.println("There are " + TVCount + " type(s) of TV");
                System.out.println("Total quantity : " + TVQuantity);
                System.out.println("Total value    : RM" + String.format("%.2f",TVTotalValue));
            }

            if (hasRef) {
                System.out.println("\nRefrigerator");
                System.out.println("----------------------------------------");
                System.out.println("There are " + RefCount + " type(s) of Refrigerator");
                System.out.println("Total quantity  : " + RefQuantity);
                System.out.println("Total value     : RM" + String.format("%.2f",RefTotalValue));
            }

            if (hasWM) {
                System.out.println("\nWashing machine");
                System.out.println("----------------------------------------");
                System.out.println("There are " + WMCount + " type(s) of Washing Machine");
                System.out.println("Total quantity  : " + WMQuantity);
                System.out.println("Total value     : RM" + String.format("%.2f",WMTotalValue));
            }
            
            if (hasFan) {
                System.out.println("\nFan");
                System.out.println("----------------------------------------");
                System.out.println("There are " + FanCount + " type(s) of Fan");
                System.out.println("Total quantity  : " + FanQuantity);
                System.out.println("Total value     : RM" + String.format("%.2f",FanTotalValue));
            }
        }
    }
}

