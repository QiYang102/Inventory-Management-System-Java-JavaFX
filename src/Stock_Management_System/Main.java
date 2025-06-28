package Stock_Management_System;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import Functionality_Class.ConsoleUtils;
import Functionality_Class.Validation;
import Product_Class.Product;
import User_Class.UserInfo;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Initialization
        Scanner scanner = new Scanner(System.in);
        int int_input;
        final int first_option_sceneA = 0;
        final int last_option_sceneA = 1;
        ArrayList<Product> productList = new ArrayList<>();

        // User Section
        UserInfo user1 = new UserInfo();
        user1.getUserName(scanner);
        user1.generateUserID();
        user1.showUserInfo();
        
        ConsoleUtils.pauseScreen(scanner);
        System.out.print("\n\n");
        System.out.println("==========================================================");
        System.out.println("    		 Welcome to the SMS!      ");
        System.out.println("==========================================================");
        showDateTime();
        System.out.println("==========================================================");
        System.out.println("|                Prepared By:                            |");
        System.out.println("|                1) K'NG HUI XUAN  2400373               |");
        System.out.println("|                2) LEE ZHI EN     2205000               |");
        System.out.println("|                3) TEO QIYANG     2206185               |");
        System.out.println("|                4) WONG YEN MING  2205035               |");
        System.out.println("==========================================================\n");

        int_input = Validation.intInputValidation(scanner, first_option_sceneA, last_option_sceneA, "Do you like to add any product? (1-yes | 0-exit): ");

        if (int_input == 1) {
            StockManagement.addProduct(productList, scanner);
            ConsoleUtils.pauseScreen(scanner);

            boolean program_control = true;
            final int first_option_sceneB = 0;
            final int last_option_sceneB = 5;
            while (program_control) {
                System.out.println("\nWhat would you like to perform?");
                System.out.println("1. View Product" +
                        		 "\n2. Product Operation" +
                        		 "\n3. Add Stock" +
                        		 "\n4. Deduct Stock" +
                        		 "\n5. Generate Report" +
                        		 "\n0. Exit");

                // Validation
                int_input = Validation.intInputValidation(scanner, first_option_sceneB, last_option_sceneB, "Input: ");

                switch (int_input) {
                    // Exit Program
                    case 0: {
                        program_control = false;
                        break;
                    }
                    // View Product
                    case 1: {
                        StockManagement.viewProduct(productList, scanner);
                        ConsoleUtils.pauseScreen(scanner);
                        break;
                    }
                    // Product Operation
                    case 2: {
                    	ConsoleUtils.pauseScreen(scanner);
                        StockManagement.productOperation(productList, scanner);
                        ConsoleUtils.pauseScreen(scanner);
                        break;
                    }
                    // Add Stock
                    case 3: {
                        StockManagement.addStock(productList, scanner);
                        ConsoleUtils.pauseScreen(scanner);
                        break;
                    }
                    case 4: {
                        StockManagement.deductStock(productList, scanner);
                        ConsoleUtils.pauseScreen(scanner);
                        break;
                    }
                    // Deduct Stock
                    case 5: {
                        StockManagement.generateReport(productList);
                        ConsoleUtils.pauseScreen(scanner);
                        break;
                    }
                }

            }
        }
        
	    // Input = 0
        System.out.println("\n\n==========================================================");
        System.out.println("  	   Program Terminated Successfully     ");
        System.out.println("==========================================================");

        // Print user information clearly
        System.out.println("\nUser Information:");
        System.out.println(user1.getUsername() + " (" + user1.getUserID() + ")");

        // Program termination message
        System.out.println("\nYou have terminated the program.");
        System.out.println("\nSee you later~");

        System.out.println("\nPress Enter to exit...");
    }


    public static void showDateTime() {
        // Creating current date and time
        LocalDateTime now = LocalDateTime.now();

        // Defining format
        DateTimeFormatter date_format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter time_format = DateTimeFormatter.ofPattern("HH:mm:ss a");

        // Applying format
        String formatted_date = now.format(date_format);
        String formatted_time = now.format(time_format);
        System.out.println("Date: " + formatted_date + "\t\t\tTime: " + formatted_time);
        System.out.println();
    }
}
