package User_Class;

import java.util.Scanner;

public class UserInfo {
	//Private variable
    private String username;
    private String userID;
    
    
    /* ----------------------- GETTER ----------------------- */
    public String getUserID(){ return this.userID; }
    public String getUsername(){ return this.username; }

    
    /* ----------------------- SETTER ----------------------- */
    public void setUserID(String userID){ this.userID = userID; }
    public void setUsername(String username){ this.username = username; }
    
    
    /* ----------------------- METHODS ----------------------- */
    //1) Get user name
    public void getUserName(Scanner scanner) {        
        while (true) {
            System.out.println("==========================================================");
	        System.out.print("Name: ");
        	this.username = scanner.nextLine().trim();
	        System.out.println("==========================================================");
        	
        	if (!(this.username.isEmpty())) { break; }
        	else { System.out.println("The name CANNOT be empty!\n"); }
        }
    }
    
    //2) Generate userID according to condition
    public void generateUserID() {
        char initial;
        String subname = "";

        //Case 1: user name contain space (first character + last name)
        if (username.contains(" ")) {
            initial = username.charAt(0);
            subname = username.substring(findLastSpaceIndex(username) + 1);
            userID = initial + subname;
        }
        // Case 2: user name does not contain space (guest)
        else if (!username.contains(" ")) {
            userID = "guest";
        }
    }
    
    //2.1) Function call by generateUserID to find the last space index
    private int findLastSpaceIndex(String username) {
    	int curr = username.indexOf(" ");
    	int next = username.indexOf(" ", curr + 1);
    	
    	while(next != -1) {
    		curr = next;
    		next = username.indexOf(" ", curr + 1);
    	}
    	
    	return curr;
    }

    //3) Show user information
    public void showUserInfo() {
        System.out.println("Name	: " + username + 
        				   "\nUserID	: " + userID);
        if (username.contains(" ")) {
        	System.out.println("You have logged in as " + userID + ".");
        }
        else {
        	System.out.println("You have logged in as a " + userID + ".");
        }
    }
}

