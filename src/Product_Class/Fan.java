package Product_Class;

public class Fan extends Product {
	//Instance variables for Fan
	private int speedLevels;
    private String fanType; // e.g., "Ceiling", "Table", "Wall-mounted"
    private int powerConsumption; // in Watts

    /* ----------------------- CONSTRUCTOR ----------------------- */
    //Parameterized constructor
    public Fan(int productID, String productName, int productQuantity, double productPrice,  int speedLevels, String fanType, int powerConsumption) {
        super(productID, productName,productQuantity ,productPrice);
        this.speedLevels = speedLevels;
        this.fanType = fanType;
        this.powerConsumption = powerConsumption;
    }

    /* ----------------------- GETTER ----------------------- */
    public int getSpeedLevels() { return speedLevels; }
    public String getFanType() { return fanType; }
    public int getPowerConsumption() { return powerConsumption; }
    public String getProductDetail() { return "Speed Levels			: " + this.speedLevels + 
    										  "\nFan Type				: " + this.fanType + 
    										  "\nPower Comsumption	: " + this.powerConsumption + "W" ;}
    public String getProductType() { return "Fan"; }
    

    /* ----------------------- SETTER ----------------------- */
    public void setSpeedLevels(int speedLevels) { this.speedLevels = speedLevels; }
    public void setFanType(String fanType) { this.fanType = fanType; }
    public void setPowerConsumption(int powerConsumption) { this.powerConsumption = powerConsumption; }

    /* ----------------------- METHODS ----------------------- */
    //1) Override toString to display
    @Override
    public String toString() {
    	String outputProductPrice = String.format("%,.2f", super.getProductPrice());
    	String outputInventoryValue = String.format("%,.2f", super.getInventoryValue());
    	
        return  ("Item number         : " + super.getProductID()) +
                ("\nProduct name        : " + super.getProductName()) +
                ("\nFan type            : " + this.fanType) +
                ("\nSpeed levels        : " + this.speedLevels) +
                ("\nPower consumption   : " + this.powerConsumption + "W") +
                ("\nQuantity available  : " + super.getProductQuantity()) +
                ("\nPrice (RM)          : " + outputProductPrice) +
                ("\nInventory value (RM): " + outputInventoryValue) +
                ("\nProduct status      : " + (super.getProductStatus() ? "Active" : "Inactive")) + ("\n");
    }
}


