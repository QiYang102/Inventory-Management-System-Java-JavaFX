package GUI;

import Product_Class.Fan;
import Product_Class.Product;
import Product_Class.Refrigerator;
import Product_Class.TV;
import Product_Class.WashingMachine;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Duration;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import Functionality_Class.Validation;
import Functionality_Class.ValidationType;


public class d_ConAddDelete implements Initializable {

    @FXML
    private ChoiceBox<String> productChoice;

    @FXML
    private TextField quantity;

    @FXML
    private Label quantityLabel;

    @FXML
    private Button addButton;

    @FXML
    private TextField itemNumber;

    @FXML
    private Label itemNumberLabel;

    @FXML
    private TextField name;

    @FXML
    private Label nameLabel;

    @FXML
    private TextField option1;

    @FXML
    private Label option1Label;

    @FXML
    private TextField option2;

    @FXML
    private Label option2Label;

    @FXML
    private TextField option3;

    @FXML
    private Label option3Label;

    @FXML
    private Label outputLabel;

    @FXML
    private TextField price;

    @FXML
    private Label priceLabel;

    private TranslateTransition currentTransition;
    private Label currentActiveLabel;
    private ValidationType type;
    private final String[] product = { "TV", "Refrigerator", "Washing Machine", "Fan" };
    private ArrayList<Product> productList = new ArrayList<Product>();
    private c_ConView prevController;
    private static int product_counter = 0;

    /* ----------------------- SETTER ----------------------- */
    public void setProductList(ArrayList<Product> productList){ this.productList = productList; }
    public void setPrevController(c_ConView prevController){ this.prevController = prevController; }

    
    /* ----------------------- INITIALIZE ----------------------- */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        productChoice.getItems().addAll(product);

        hideAllFields();

        productChoice.setOnAction(this::setLabelShow);

        setupFieldAnimation(name, nameLabel);
        setupFieldAnimation(option1, option1Label);
        setupFieldAnimation(option2, option2Label);
        setupFieldAnimation(option3, option3Label);
        setupFieldAnimation(quantity, quantityLabel);
        setupFieldAnimation(price, priceLabel); 
    }

    /*
     *  ===================== Add Button Click =====================
     */
    public void addButtonClick(ActionEvent e) throws Exception {
        Product newProduct;
        
        //TV
        if(productChoice.getValue().equals("TV")){
            String name, screenType, resolution, displaySize;
            double price;
            int quantity;

//            name = this.name.getText().trim().isEmpty() ? "Unknown Name" :  this.name.getText().trim();
//            screenType = this.option1.getText().trim().isEmpty() ? "Unknown Screen Type" :  this.option1.getText().trim();
//            resolution = this.option2.getText().trim().isEmpty() ? "Unknown Resolution" :  this.option2.getText().trim();
//            displaySize = this.option3.getText().trim().isEmpty() ? "Unknown Display Size" :  this.option3.getText().trim();
            
            boolean c1 = true, c2 = true, c3 = true, c4 = true, c5, c6;
            
            if(this.name.getText().trim().isEmpty()) {
            	errorField(this.name, ValidationType.EMPTY, nameLabel);
            	c1 = false;
            }
            if(this.option1.getText().trim().isEmpty()) {
            	errorField(this.option1, ValidationType.EMPTY, option1Label);
            	c2 = false;
            }
            if(this.option2.getText().trim().isEmpty()) {
            	errorField(this.option2, ValidationType.EMPTY, option2Label);
            	c3 = false;
            }
            if(this.option3.getText().trim().isEmpty()) {
            	errorField(this.option3, ValidationType.EMPTY, option3Label);
            	c3 = false;
            }
            
            c5 = checkDoubleField(this.price, 0d, priceLabel);
            c6 = checkIntField(this.quantity, 1, quantityLabel);
            
            if(c1 && c2 && c3 && c4 && c5 && c6) {
            	name = this.name.getText().trim();
            	screenType = this.option1.getText().trim();
            	resolution = this.option2.getText().trim();
            	displaySize = this.option3.getText().trim();
            	price = Double.parseDouble(this.price.getText());
            	quantity = Integer.parseInt(this.quantity.getText());
            }           
            else {
            	return;
            }

            newProduct = new TV(product_counter++, name, quantity, price, screenType, resolution, displaySize);
        }
        
        //Refrigerator
        else if (productChoice.getValue().equals("Refrigerator")) {
            String name, doorDesign, color;
            double price, capacity;
            int quantity;

//            name = this.name.getText().trim().isEmpty() ? "Unknown Name" :  this.name.getText().trim();
//            doorDesign = this.option1.getText().trim().isEmpty() ? "Unknown Door Design" :  this.option1.getText().trim();
//            color = this.option2.getText().trim().isEmpty() ? "Unknown Color" :  this.option2.getText().trim();
            
            boolean c1 = true, c2 = true, c3 = true, c4, c5, c6;
            
            if(this.name.getText().trim().isEmpty()) {
            	errorField(this.name, ValidationType.EMPTY, nameLabel);
            	c1 = false;
            }
            if(this.option1.getText().trim().isEmpty()) {
            	errorField(this.option1, ValidationType.EMPTY, option1Label);
            	c2 = false;
            }
            if(this.option2.getText().trim().isEmpty()) {
            	errorField(this.option2, ValidationType.EMPTY, option2Label);
            	c3 = false;
            }
            
            c4 = checkDoubleField(option3, 0d, option3Label);
            c5 = checkDoubleField(this.price, 0d, priceLabel);
            c6 = checkIntField(this.quantity, 1, quantityLabel);
            
            if(c1 && c2 && c3 && c4 && c5 && c6) {
            	name = this.name.getText().trim();
            	doorDesign = this.option1.getText().trim();
            	color = this.option2.getText().trim();
            	capacity = Double.parseDouble(this.option3.getText().trim());
            	price = Double.parseDouble(this.price.getText());
            	quantity = Integer.parseInt(this.quantity.getText());
            }           
            else {
            	return;
            }
                       
            newProduct = new Refrigerator(product_counter++, name, quantity, price, doorDesign, color, capacity);
        }
        
        //Washing Machine
        else if(productChoice.getValue().equals("Washing Machine")) {
            String name, loadingType, noiseLevel;
            double price;
            int quantity, spinSpeed;

//            name = this.name.getText().trim().isEmpty() ? "Unknown Name" :  this.name.getText().trim();
//            loadingType = this.option1.getText().trim().isEmpty() ? "Unknown Door Design" :  this.option1.getText().trim();
//            noiseLevel = this.option2.getText().trim().isEmpty() ? "Unknown Color" :  this.option2.getText().trim();
            
            boolean c1 = true, c2 = true, c3 = true, c4, c5, c6;
            
            if(this.name.getText().trim().isEmpty()) {
            	errorField(this.name, ValidationType.EMPTY, nameLabel);
            	c1 = false;
            }
            if(this.option1.getText().trim().isEmpty()) {
            	errorField(this.option2, ValidationType.EMPTY, option2Label);
            	c2 = false;
            }
            if(this.option2.getText().trim().isEmpty()) {
            	errorField(this.option3, ValidationType.EMPTY, option3Label);
            	c3 = false;
            }
            
            c4 = checkIntField(option1, 1, option1Label);
            c5 = checkDoubleField(this.price, 0d, priceLabel);
            c6 = checkIntField(this.quantity, 1, quantityLabel);
            
            if(c1 && c2 && c3 && c4 && c5 && c6) {
            	name = this.name.getText().trim();
            	loadingType = this.option2.getText().trim();
            	noiseLevel = this.option3.getText().trim();
            	spinSpeed = Integer.parseInt(this.option1.getText().trim());
            	price = Double.parseDouble(this.price.getText());
            	quantity = Integer.parseInt(this.quantity.getText());
            }           
            else {
            	return;
            }
                       
            newProduct = new WashingMachine(product_counter++, name, quantity, price, spinSpeed, loadingType, noiseLevel);
        }
        
        //Fan
        else {
            String name, fanType;
            double price;
            int quantity, speedLevels, powerConsumption;

//            name = this.name.getText().trim().isEmpty() ? "Unknown Name" :  this.name.getText().trim();
//            fanType = this.option1.getText().trim().isEmpty() ? "Unknown Door Design" :  this.option1.getText().trim();
            
            boolean c1 = true, c2 = true, c3, c4, c5, c6;
            
            if(this.name.getText().trim().isEmpty()) {
            	errorField(this.name, ValidationType.EMPTY, nameLabel);
            	c1 = false;
            }
            if(this.option2.getText().trim().isEmpty()) {
            	errorField(this.option2, ValidationType.EMPTY, option2Label);
            	c2 = false;
            }
            
            c3 = checkIntField(option1, 1, option1Label);
            c4 = checkIntField(option3, 1, option3Label);
            c5 = checkDoubleField(this.price, 0d, priceLabel);
            c6 = checkIntField(this.quantity, 1, quantityLabel);
            
            if(c1 && c2 && c3 && c4 && c5 && c6) {
            	name = this.name.getText().trim();
            	fanType = this.option1.getText().trim();
            	speedLevels = Integer.parseInt(this.option1.getText().trim());
            	powerConsumption = Integer.parseInt(this.option3.getText().trim());
            	price = Double.parseDouble(this.price.getText());
            	quantity = Integer.parseInt(this.quantity.getText());
            }           
            else {
            	return;
            }
                       
            newProduct = new Fan(product_counter++, name, quantity, price, speedLevels, fanType, powerConsumption);
        }

        productList.add(newProduct);
        prevController.addTable(newProduct);

        outputLabel.setText("Product added successfully");
        outputLabel.setVisible(true);

        PauseTransition delay = new PauseTransition(Duration.seconds(2));
        delay.setOnFinished(event -> {
            try {
                outputLabel.setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        delay.play();
        clearAllFields();
    }

    
    /*
     *  ===================== Helper function =====================
     */
    private void hideAllFields() {
        addButton.setVisible(false);

        name.setVisible(false);
        nameLabel.setVisible(false);

        option1.setVisible(false);
        option1Label.setVisible(false);

        option2.setVisible(false);
        option2Label.setVisible(false);

        option3.setVisible(false);
        option3Label.setVisible(false);

        price.setVisible(false);
        priceLabel.setVisible(false);

        quantity.setVisible(false);
        quantityLabel.setVisible(false);

        outputLabel.setVisible(false);
    }

    private void showAllFields() {
        addButton.setVisible(true);

        name.setVisible(true);
        nameLabel.setVisible(true);

        option1.setVisible(true);
        option1Label.setVisible(true);

        option2.setVisible(true);
        option2Label.setVisible(true);

        option3.setVisible(true);
        option3Label.setVisible(true);

        price.setVisible(true);
        priceLabel.setVisible(true);

        quantity.setVisible(true);
        quantityLabel.setVisible(true);
    }

    private void clearAllFields() {
        name.clear();
        name.setStyle("");
        name.setPromptText("");
        nameLabel.setTranslateY(0);

        option1.clear();
        option1.setStyle("");
        option1.setPromptText("");
        option1Label.setTranslateY(0);

        option2.clear();
        option2.setStyle("");
        option2.setPromptText("");
        option2Label.setTranslateY(0);

        option3.clear();
        option3.setStyle("");
        option3.setPromptText("");
        option3Label.setTranslateY(0);

        price.clear();
        price.setStyle("");
        price.setPromptText("");
        priceLabel.setTranslateY(0);

        quantity.clear();
        quantity.setStyle("");
        quantity.setPromptText("");
        quantityLabel.setTranslateY(0);
    }

    private void setLabelShow(ActionEvent event){
    	clearAllFields();
        if(productChoice.getValue().equals("TV")){
            option1Label.setText("Screen Type");
            option2Label.setText("Resolution");
            option3Label.setText("Display Size");
        }
        else if(productChoice.getValue().equals("Refrigerator")){
            option1Label.setText("Door Design");
            option2Label.setText("Color");
            option3Label.setText("Capacity (in Litres)");
        }
        else if(productChoice.getValue().equals("Washing Machine")) {
            option1Label.setText("Spin Speed");
            option2Label.setText("Loading Type");
            option3Label.setText("Noise Level");
        }
        else {
            option1Label.setText("Speed Levels");
            option2Label.setText("Fan Type");
            option3Label.setText("Power Consumption");
        }
        showAllFields();
    }
    
    private void setupFieldAnimation(TextField field, Label label) {
        TranslateTransition transition = new TranslateTransition(Duration.millis(150), label);
        transition.setInterpolator(Interpolator.EASE_BOTH);

        field.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal) {
                // Stop any ongoing animation
                if (currentTransition != null) {
                    currentTransition.stop();
                }
                
                field.setStyle("");
                field.setPromptText("");

                // Animate current label up
                transition.setToY(-25);
                transition.play();

                // Update current transition and label
                currentTransition = transition;
                currentActiveLabel = label;
            }
            else if (label == currentActiveLabel) {
                // Animate back down only if it's the active label
                if(field.getText().isEmpty()){
                    transition.setToY(0);
                    transition.play();
                }

                // Clear references
                currentTransition = null;
                currentActiveLabel = null;
            }
        });
    }
    
    
    /*
     *  ===================== Validation Function =====================
     */
    private boolean checkDoubleField(TextField field, double first_option, Label label) {
		type = Validation.doubleInputValidation(field.getText(), first_option);
		
		if(type == ValidationType.CORRECT) {
			return true;
		}
		else if(type == ValidationType.DOUBLE_ONLY) {
			errorField(field, ValidationType.DOUBLE_ONLY, label);
			return false;
		}
		else if (type == ValidationType.OUT_OF_RANGE) {
			errorField(field, ValidationType.OUT_OF_RANGE, label);
			return false;
		}
		else {
			errorField(field, ValidationType.EMPTY, label);
			return false;
		}
    }
    
    private boolean checkIntField(TextField field, int first_option, Label label) {
		type = Validation.intInputValidation(field.getText(), first_option);
		
		if(type == ValidationType.CORRECT) {
			return true;
		}
		else if(type == ValidationType.INTEGER_ONLY) {
			errorField(field, ValidationType.INTEGER_ONLY, label);
			return false;
		}
		else if (type == ValidationType.OUT_OF_RANGE) {
			errorField(field, ValidationType.OUT_OF_RANGE, label);
			return false;
		}
		else {
			errorField(field, ValidationType.EMPTY, label);
			return false;
		}
    }
    
    private void errorField(TextField field, ValidationType type, Label label) {
		if(type == ValidationType.INTEGER_ONLY) {
			field.clear();
        	field.setPromptText("Enter integer only!");
        	label.setTranslateY(-25);
		}
		else if(type == ValidationType.DOUBLE_ONLY) {
			field.clear();
        	field.setPromptText("Enter double only!");
        	label.setTranslateY(-25);
		}
		else if (type == ValidationType.OUT_OF_RANGE) {
			field.clear();
        	field.setPromptText("Out of Range!");
        	label.setTranslateY(-25);
		}
		else {
			field.clear();
        	field.setPromptText("Cannot be empty!");
        	label.setTranslateY(-25);
		}
    	field.setStyle("-fx-border-color: red");
    }
}

