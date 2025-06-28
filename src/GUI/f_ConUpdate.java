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
import javafx.stage.Stage;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;

import Functionality_Class.Validation;
import Functionality_Class.ValidationType;


public class f_ConUpdate implements Initializable {
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

    @FXML
    private TextField quantity;

    @FXML
    private Label quantityLabel;

    @FXML
    private Button updateButton;

    private TranslateTransition currentTransition;
    private Label currentActiveLabel;
    private ValidationType type;
    private c_ConView prevController;
    private Product selectedProduct;

    /* ----------------------- SETTER ----------------------- */
    public void setPrevController(c_ConView prevController){ this.prevController = prevController; }
    public void setSelectedProduct(Product selectedProduct){ this.selectedProduct = selectedProduct; }

    /* ----------------------- INITIALIZE ----------------------- */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setupFieldAnimation(name, nameLabel);
        setupFieldAnimation(option1, option1Label);
        setupFieldAnimation(option2, option2Label);
        setupFieldAnimation(option3, option3Label);
        setupFieldAnimation(quantity, quantityLabel);
        setupFieldAnimation(price, priceLabel);
    }
    
    
    /*
     *  ===================== Update Button Click =====================
     */
    public void updateButtonClick(ActionEvent e) throws Exception {
    	//TV
        if(selectedProduct instanceof TV){
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

            selectedProduct.setProductName(name);
            ((TV) selectedProduct).setScreenType(screenType);
            ((TV) selectedProduct).setResolution(resolution);
            ((TV) selectedProduct).setDisplaySize(displaySize);
            selectedProduct.setProductQuantity(quantity);
            selectedProduct.setProductPrice(price);
        }
        
        //Refrigerator
        else if (selectedProduct instanceof Refrigerator){
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

            selectedProduct.setProductName(name);
            ((Refrigerator)selectedProduct).setDoorDesign(doorDesign);
            ((Refrigerator)selectedProduct).setColor(color);
            ((Refrigerator)selectedProduct).setStorageCapacity(capacity);
            selectedProduct.setProductQuantity(quantity);
            selectedProduct.setProductPrice(price);
        }
        
        //Washing Machine
        else if (selectedProduct instanceof WashingMachine) {
            String name, loadingType, noiseLevel;
            double price;
            int quantity, spinSpeed;

//            name = this.name.getText().trim().isEmpty() ? "Unknown Name" :  this.name.getText().trim();
//            loadingType = this.option1.getText().trim().isEmpty() ? "Unknown Loading Type" :  this.option1.getText().trim();
//            noiseLevel = this.option2.getText().trim().isEmpty() ? "Unknown Noise Level" :  this.option2.getText().trim();
            
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
                       
            selectedProduct.setProductName(name);
            ((WashingMachine)selectedProduct).setSpinSpeed(spinSpeed);
            ((WashingMachine)selectedProduct).setLoadingType(loadingType);
            ((WashingMachine)selectedProduct).setNoiseLevel(noiseLevel);
            selectedProduct.setProductQuantity(quantity);
            selectedProduct.setProductPrice(price);
        }
        
        //Fan
        else {
            String name, fanType;
            double price;
            int quantity, speedLevels, powerConsumption;

//            name = this.name.getText().trim().isEmpty() ? "Unknown Name" :  this.name.getText().trim();
//            fanType = this.option1.getText().trim().isEmpty() ? "Unknown Fan Type" :  this.option1.getText().trim();
            
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
                       
            selectedProduct.setProductName(name);
            ((Fan)selectedProduct).setSpeedLevels(speedLevels);
            ((Fan)selectedProduct).setFanType(fanType);
            ((Fan)selectedProduct).setPowerConsumption(powerConsumption);
            selectedProduct.setProductQuantity(quantity);
            selectedProduct.setProductPrice(price);
        }

        outputLabel.setText("Product update successful");
        outputLabel.setVisible(true);        
        prevController.updateTable();

        // Add a 0.5-second delay before switching to the next scene
        PauseTransition delay = new PauseTransition(Duration.seconds(0.5)); // 3-second delay
        delay.setOnFinished(event -> {
            try {
                Stage stage = (Stage) option1.getScene().getWindow();
                stage.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        delay.play(); // Start the delay
    }
    
    
    /*
     *  ===================== Helper Function =====================
     */
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
    

    public void setTextField(){
        nameLabel.setTranslateY(-25);
        option1Label.setTranslateY(-25);
        option2Label.setTranslateY(-25);
        option3Label.setTranslateY(-25);
        priceLabel.setTranslateY(-25);
        quantityLabel.setTranslateY(-25);

        name.setText(selectedProduct.getProductName());
        if(selectedProduct instanceof TV){
            option1.setText(((TV) selectedProduct).getScreenType());
            option2.setText(((TV) selectedProduct).getResolution());
            option3.setText(((TV) selectedProduct).getDisplaySize());

            option1Label.setText("Screen Type");
            option2Label.setText("Resolution");
            option3Label.setText("Display Size");
        }
        else if(selectedProduct instanceof Refrigerator){
            option1.setText(((Refrigerator) selectedProduct).getDoorDesign());
            option2.setText(((Refrigerator) selectedProduct).getColor());
            option3.setText(Double.toString(((Refrigerator) selectedProduct).getStorageCapacity()));

            option1Label.setText("Door Design");
            option2Label.setText("Color");
            option3Label.setText("Capacity");
        }
        else if(selectedProduct instanceof WashingMachine) {
            option1.setText(Integer.toString(((WashingMachine) selectedProduct).getSpinSpeed()));
            option2.setText(((WashingMachine) selectedProduct).getLoadingType());
            option3.setText(((WashingMachine) selectedProduct).getNoiseLevel());

            option1Label.setText("Spin Speed");
            option2Label.setText("Loading Type");
            option3Label.setText("Noise Level");
        }
        else {
            option1.setText(Integer.toString(((Fan) selectedProduct).getSpeedLevels()));
            option2.setText(((Fan) selectedProduct).getFanType());
            option3.setText(Integer.toString(((Fan) selectedProduct).getPowerConsumption()));

            option1Label.setText("Speed Level");
            option2Label.setText("Fan Type");
            option3Label.setText("Power Consumption");
        }
        quantity.setText(Integer.toString((selectedProduct.getProductQuantity())));
        price.setText(String.format("%.2f", selectedProduct.getProductPrice()));
        outputLabel.setVisible(false);
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
        	field.setPromptText("Cannot be Empty!");
        	label.setTranslateY(-25);
		}
    	field.setStyle("-fx-border-color: red");
    }
}


