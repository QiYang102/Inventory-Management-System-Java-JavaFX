package Product_Class;

public class TV extends Product {
	//Instance variables for TV
    private String screenType;
    private String resolution;
    private String displaySize;
    
    
    /* ----------------------- CONSTRUCTOR ----------------------- */
    //Parameterized constructor
    public TV(int productID, String productName, int productQuantity, double productPrice, String screenType, String resolution, String displaySize){
        super(productID, productName,productQuantity ,productPrice);
        this.screenType = screenType;
        this.resolution = resolution;
        this.displaySize = displaySize;
    }
    
    
    /* ----------------------- GETTER ----------------------- */
    public String getScreenType() { return this.screenType; }
    public String getResolution() { return this.resolution; }
    public String getDisplaySize() { return this.displaySize; }
    public String getProductDetail() { return "Screen Type	: " + this.screenType + 
    										  "\nResolution	: " + this.resolution + 
    										  "\nDisplay Size	: " + this.displaySize; }
    public String getProductType() { return "TV"; }
    
    
    /* ----------------------- SETTER ----------------------- */
    public void setScreenType(String screenType) { this.screenType = screenType; }
    public void setResolution(String resolution) { this.resolution = resolution; }
    public void setDisplaySize(String displaySize) { this.displaySize = displaySize; }
    
    
    /* ----------------------- METHODS ----------------------- */
    //1) Override toString to display
    public String toString(){
    	String outputProductPrice = String.format("%,.2f", super.getProductPrice());
    	String outputInventoryValue = String.format("%,.2f", super.getInventoryValue());
    	
        return  ("Item number         : " + super.getProductID()) +
                ("\nProduct name        : " + super.getProductName()) +
                ("\nScreen type         : " + this.screenType) +
                ("\nResolution          : " + this.resolution) +
                ("\nDisplay size        : " + this.displaySize) +
                ("\nQuantity available  : " + super.getProductQuantity()) +
                ("\nPrice (RM)          : " + outputProductPrice) +
                ("\nInventory value (RM): " + outputInventoryValue) +
                ("\nProduct status	    : " + (super.getProductStatus() ? "Active" : "Inactive")) + ("\n"); 
    }
}
