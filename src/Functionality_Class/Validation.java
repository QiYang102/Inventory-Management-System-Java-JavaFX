package Functionality_Class;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Product_Class.Product;

public class Validation {
	
	/* ----------------------------------------- Validation for Console Part -----------------------------------------*/
	
    /*
     * ====================================== 1. Check input for only integer ======================================
     */
	public static int intInputValidation(Scanner scanner, String msg) {
        boolean isAllDigit;
        int int_input = -1;

        do {
        	System.out.print(msg);
            isAllDigit = true;
        	try {
        		int_input = scanner.nextInt();
        	}
        	catch(InputMismatchException e) {
        		System.out.println("Please enter numeric number only!");
        		isAllDigit = false;
        	}
        	catch(NumberFormatException e) {
        		System.out.println("Please enter numeric number only!");
        		isAllDigit = false;
        	}
        	
            scanner.nextLine();
        } while (!isAllDigit);
        return int_input;
	}
	
    /*
     * ====================================== 2. Check input for only integer and above the first valid option  ======================================
     */
	public static int intInputValidation(Scanner scanner, int first_option, String msg) {
        boolean isAllDigit, isInRange;
        int int_input = -1;

        do {
        	System.out.print(msg);
            isAllDigit = true;
            isInRange = true;
        	try {
        		int_input = scanner.nextInt();
        		
                if (int_input < first_option) {
                	System.out.println("Please select " + first_option + " or above only!");
                    isInRange = false;
                }
        	}
        	catch(InputMismatchException e) {
        		System.out.println("Please enter numeric number only!");
        		isAllDigit = false;
        	}
        	catch(NumberFormatException e) {
        		System.out.println("Please enter numeric number only!");
        		isAllDigit = false;
        	}
        	
            scanner.nextLine();
        } while (!isAllDigit || !isInRange);
        return int_input;
    }
	
    /*
     * ====================================== 3. Check input for only integer and between the first and last option  ======================================
     */
	public static int intInputValidation(Scanner scanner, int first_option, int last_option, String msg) {
        boolean isAllDigit, isInRange;
        int int_input = -1;

        do {
        	System.out.print(msg);
            isAllDigit = true;
            isInRange = true;
        	try {
        		int_input = scanner.nextInt();
        		
                if (int_input < first_option || int_input > last_option) {
                	System.out.println("Please select " + first_option + " to " + last_option + " only!");
                    isInRange = false;
                }
        	}
        	catch(InputMismatchException e) {
        		System.out.println("Please enter numeric number only!");
        		isAllDigit = false;
        	}
        	catch(NumberFormatException e) {
        		System.out.println("Please enter numeric number only!");
        		isAllDigit = false;
        	}
        	
            scanner.nextLine();
        } while (!isAllDigit || !isInRange);
        return int_input;
    }
	
	
    /*
     * ====================================== 4. Check input for only double and above first option  ======================================
     */
	public static double doubleInputValidation(Scanner scanner, double first_option, String msg) {
        boolean isAllDigit, isInRange;
        double double_input = -1;

        do {
        	System.out.print(msg);
            isAllDigit = true;
            isInRange = true;
        	try {
        		double_input = scanner.nextDouble();
        		
                if (double_input < first_option) {
                	System.out.println("Please select " + first_option + " or above only!");
                    isInRange = false;
                }
        	}
        	catch(InputMismatchException e) {
        		System.out.println("Please enter numeric number only!");
        		isAllDigit = false;
        	}
        	        
            scanner.nextLine();
        } while (!isAllDigit || !isInRange);
        return double_input;
    }
	
	
    /*
     * ====================================== 5. Check input for only integer and number exists in productID  ======================================
     */
    public static int productValidation(ArrayList<Product> productList, Scanner scanner, String msg) {
        int int_input;
        boolean isValid = false;

        do {
            int_input = intInputValidation(scanner, msg);

            for (int i = 0; i < productList.size(); i++) {
                if (int_input == productList.get(i).getProductID()) {
                    return i;
                }
            }

            if (!isValid) {
                System.out.println("Please enter a valid item number!");
            }
        } while (true);
    }
    
    
	/* ----------------------------------------- Validation for GUI Part -----------------------------------------*/
	
    /*
     * ====================================== 1. Check input for only integer and above the first valid option  ======================================
     */
	public static ValidationType intInputValidation(String input, int first_option) {
        int int_input = -1;

    	try {
    		if(input.isEmpty()) {
    			return ValidationType.EMPTY;
    		}
    		
    		int_input = Integer.parseInt(input);
    		
            if (int_input < first_option) {
            	return ValidationType.OUT_OF_RANGE;
            }
    	}
    	catch(InputMismatchException e) {
    		return ValidationType.INTEGER_ONLY;
    	}
    	catch(NumberFormatException e) {
    		return ValidationType.INTEGER_ONLY;
    	}
        return ValidationType.CORRECT;
    }
	
	/*
     * ====================================== 2. Check input for only integer and between the first and last option  ======================================
     */
	public static ValidationType intInputValidation(String input, int first_option, int last_option) {
        int int_input = -1;

    	try {
    		if(input.isEmpty()) {
    			return ValidationType.EMPTY;
    		}
    		
    		int_input = Integer.parseInt(input);
    		
            if (int_input < first_option || int_input > last_option) {
            	return ValidationType.OUT_OF_RANGE;
            }
    	}
    	catch(InputMismatchException e) {
    		return ValidationType.INTEGER_ONLY;
    	}
    	catch(NumberFormatException e) {
    		return ValidationType.INTEGER_ONLY;
    	}
        return ValidationType.CORRECT;
    }
	
    /*
     * ====================================== 3. Check input for only double and above first option  ======================================
     */
	public static ValidationType doubleInputValidation(String input, double first_option) {
        double double_input = -1;

    	try {
    		if(input.isEmpty()) {
    			return ValidationType.EMPTY;
    		}
    		
    		double_input = Double.parseDouble(input);
    		
            if (double_input < first_option) {
            	return ValidationType.OUT_OF_RANGE;
            }
    	}
    	catch(InputMismatchException e) {
    		return ValidationType.DOUBLE_ONLY;
    	}
    	catch(NumberFormatException e) {
    		return ValidationType.DOUBLE_ONLY;
    	}
        return ValidationType.CORRECT;
    }
}
