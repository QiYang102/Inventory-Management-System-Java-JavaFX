module OOP_C1 {
	requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
	requires javafx.graphics;
	
    opens Product_Class to javafx.base;
	opens GUI to javafx.graphics, javafx.fxml;
}
