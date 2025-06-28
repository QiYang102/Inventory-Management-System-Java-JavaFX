package Product_Class;

public class WashingMachine extends Product {
	//Instance variables for WashingMachine
    private int spinSpeed;
    private String loadingType;
    private String noiseLevel;

    
    /* ----------------------- CONSTRUCTOR ----------------------- */
    //Parameterized constructor
    public WashingMachine(int productID, String productName, int productQuantity, double productPrice, int spinSpeed, String loadingType, String noiseLevel) {
    	super(productID, productName,productQuantity ,productPrice);
        this.spinSpeed = spinSpeed;
        this.loadingType = loadingType;
        this.noiseLevel = noiseLevel;
    }

    
    /* ----------------------- GETTER ----------------------- */
    public int getSpinSpeed() { return this.spinSpeed; }
    public String getLoadingType() { return this.loadingType; }
    public String getNoiseLevel() { return this.noiseLevel; }
    public String getProductDetail() { return "Spin Speed	: " + this.spinSpeed + 
    									      "\nLoading Type	: " + this.loadingType+ 
    									      "\nNoise Level	: " + this.noiseLevel; }
    public String getProductType() { return "Washing\nMachine"; }
    
    /* ----------------------- SETTER ----------------------- */
    public void setSpinSpeed(int spinSpeed) { this.spinSpeed = spinSpeed; }
    public void setLoadingType(String loadingType) { this.loadingType = loadingType; }
    public void setNoiseLevel(String noiseLevel) { this.noiseLevel = noiseLevel; }

    
    /* ----------------------- METHODS ----------------------- */
    //1) Override toString to display
    @Override
    public String toString() {
    	String outputProductPrice = String.format("%,.2f", super.getProductPrice());
    	String outputInventoryValue = String.format("%,.2f", super.getInventoryValue());

        return  ("Item number         : " + super.getProductID()) +
                ("\nProduct name        : " + super.getProductName()) +
                ("\nSpin speed (RPM)    : " + this.spinSpeed) +
                ("\nLoading type        : " + this.loadingType) +
                ("\nNoise level         : " + this.noiseLevel) +
                ("\nQuantity available  : " + super.getProductQuantity()) +
                ("\nPrice (RM)          : " + outputProductPrice) +
                ("\nInventory value (RM): " + outputInventoryValue) +
                ("\nProduct status      : " + (super.getProductStatus() ? "Active" : "Inactive")) + ("\n"); 
    }
}
