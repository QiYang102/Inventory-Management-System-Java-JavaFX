package Product_Class;

public class Refrigerator extends Product {
	//Instance variables for Refrigerator
    private String doorDesign;
    private String color;
    private double storageCapacity;
    
    
    /* ----------------------- CONSTRUCTOR ----------------------- */
    //Parameterized constructor
    public Refrigerator(int productID, String productName, int productQuantity, double productPrice, String doorDesign, String color, double capacity) {
    	// Calls the Product class constructor
    	super(productID, productName, productQuantity, productPrice);
        this.doorDesign = doorDesign;
        this.color = color;
        this.storageCapacity = capacity;
    }
    
    
    /* ----------------------- GETTER ----------------------- */
    public String getDoorDesign() { return this.doorDesign; }
    public String getColor() { return this.color; }
    public double getStorageCapacity() { return this.storageCapacity; }
    public String getProductDetail() { return "Door Design	: " + this.doorDesign + 
    										  "\nColor		: " + this.color + 
    										  "\nCapacity		: " + this.storageCapacity; }
    public String getProductType() { return "Refrigerator"; }
    
    
    /* ----------------------- SETTER ----------------------- */
    public void setDoorDesign(String doorDesign) { this.doorDesign = doorDesign; }
    public void setColor(String color) { this.color = color; }
    public void setStorageCapacity(double storageCapacity) { this.storageCapacity = storageCapacity; }
    
    
    /* ----------------------- METHODS ----------------------- */
    //1) Override toString to display
    public String toString(){
    	String outputProductPrice = String.format("%,.2f", super.getProductPrice());
    	String outputInventoryValue = String.format("%,.2f", super.getInventoryValue());
    	
		return  ("Item number         : " + super.getProductID()) +
		        ("\nProduct name        : " + super.getProductName()) +
		        ("\nDoor design         : " + this.doorDesign) +
		        ("\nColor               : " + this.color) +
		        ("\nCapacity (in Litres): " + this.storageCapacity) +
		        ("\nQuantity available  : " + super.getProductQuantity()) +
		        ("\nPrice (RM)          : " + outputProductPrice) +
		        ("\nInventory value (RM): " + outputInventoryValue) +
		        ("\nProduct status      : " + (super.getProductStatus() ? "Active" : "Inactive")) + ("\n");
    }
}
