package Product_Class;

public abstract class Product {
	//private variable
	private int productID;
    private String productName;
    private double productPrice;
    private int productQuantity;
    private boolean productStatus = true;		// true = active
    
    /* ----------------------- CONSTRUCTOR ----------------------- */
    //default constructor
    public Product() {}
    
    //parameterized constructor
    public Product(int productID,  String productName, int productQuantity, double productPrice){
        this.productID = productID;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.productStatus = true;
    }
    
    
    /* ----------------------- GETTER ----------------------- */
    public String getProductName() { return this.productName; }
    public double getProductPrice() { return this.productPrice; }
    public int getProductID() { return this.productID; }
    public int getProductQuantity() { return this.productQuantity; }
    public boolean getProductStatus() { return this.productStatus; }
    public abstract String getProductDetail();
    
    
    /* ----------------------- SETTER ----------------------- */
    public void setProductName(String productName) { this.productName = productName; }
    public void setProductPrice(double productPrice) { this.productPrice = productPrice; }
    public void setProductID(int productID) { this.productID = productID; }
    public void setProductQuantity(int productQuantity) { this.productQuantity = productQuantity; }
    public void setProductStatus(boolean productStatus) { this.productStatus = productStatus; }
    
    
    /* ----------------------- METHODS ----------------------- */
    //1) Get total inventory value 
    public double getInventoryValue(){
        return productPrice * productQuantity;
    }
    
    //2) Add product stock
    public void addStock(int addNum){
        if(productStatus == false){
            System.out.println(productName + " is inactive. Please activate it before adding stock.");
        }
        else{
            productQuantity += addNum;
            System.out.println("You have successfully added " + addNum + " unit(s) to the stock for " + productName + ".");
        }
    }
    
    //3) Deduct product stock
    public void deductStock(int deductNum){
    	if (productStatus == true) {
            if (productQuantity >= deductNum) {
                productQuantity -= deductNum;
                System.out.println("You have successfully deducted " + deductNum + " unit(s) to the stock for " + productName + ".");
            } 
            else {
            	System.out.println("CANNOT deduct " + deductNum + " unit(s) from " + productName + " -- only " + productQuantity + " unit(s) available in stock.");
            }
        } 
    	else {
    		System.out.println(productName + " is inactive. Please activate it before deducting stock.");
        }
    }
    
    //4) Override toString to display
    public String toString(){
    	String outputProductPrice = String.format("%,.2f", productPrice);
    	String outputInventoryValue = String.format("%,.2f", getInventoryValue());
    	
        return  ("Item number           : " + this.productID) + 
        		("\nProduct name        	: " + this.productName)+ 
                ("\nPrice (RM)          	: " + outputProductPrice) + 
                ("\nQuantity available  	: " + this.productQuantity)+
                ("\nInventory value (RM)	: " + outputInventoryValue) + 
                ("\nProduct status      	: " + (this.productStatus ? "Active" : "Inactive")) + ("\n");
    }
}
