package GUI;

import Product_Class.Product;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;

import Functionality_Class.Validation;
import Functionality_Class.ValidationType;

public class g_ConAmount implements Initializable {

    @FXML
    private TextField amountField;

    @FXML
    private Label amountLabel;

    private c_ConView prevController;
    private Product selectedProduct;
    private boolean add;
    private TranslateTransition transition;
    private ValidationType type;

    /* ----------------------- SETTER ----------------------- */
    public void setPrevController(c_ConView prevController){ this.prevController = prevController; }
    public void setSelectedProduct(Product selectedProduct){ this.selectedProduct = selectedProduct; }
    public void setAdd(boolean add){ this.add = add; }
    
    /* ----------------------- INITIALIZE ----------------------- */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        transition = new TranslateTransition(Duration.millis(150), amountLabel);
        transition.setInterpolator(Interpolator.EASE_BOTH);
        setupFocusListener();
    }
    
    
    /*
     *  ===================== Confirm Button Click =====================
     */
    public void confirmButtonClick(ActionEvent event) throws Exception{
    	int amount;
    	
        if(checkIntField(amountField, 1)) {
        	amount = Integer.parseInt(amountField.getText());
        }
        else {
        	return;
        }
        
        if(add){
            selectedProduct.addStock(amount);
        }
        else{
        	if(amount > selectedProduct.getProductQuantity()) {
        		amountField.clear();
        		amountField.setPromptText("Not enought stock!");
            	amountField.setStyle("-fx-border-color: red");
            	return;
        	}
        	else {
                selectedProduct.deductStock(amount);
        	}
        }
        prevController.updateTable();
        Stage stage = (Stage) amountField.getScene().getWindow();
        stage.close();
    }

    
    /*
     *  ===================== Helper Function =====================
     */
    private void setupFocusListener() {
        amountField.focusedProperty().addListener((obs, oldVal, newVal) -> {
            transition.stop();

            if (newVal) {
                // Focus gained animation
                transition.setToY(-20);
                amountField.setStyle("");
                amountField.setPromptText("");
                
            } else {
                // Focus lost animation
                if(amountField.getText().isEmpty()){
                    transition.setToY(0);
                }
            }

            transition.play();
        });
    }
    
    
    /*
     *  ===================== Validation Function =====================
     */
    private boolean checkIntField(TextField field, int first_option) {
		type = Validation.intInputValidation(field.getText(), first_option);
		
		if(type == ValidationType.CORRECT) {
			return true;
		}
		else if(type == ValidationType.INTEGER_ONLY) {
			errorField(field, ValidationType.INTEGER_ONLY);
			return false;
		}
		else if (type == ValidationType.OUT_OF_RANGE) {
			errorField(field, ValidationType.OUT_OF_RANGE);
			return false;
		}
		else {
			errorField(field, ValidationType.EMPTY);
			return false;
		}
    }
    
    private void errorField(TextField field, ValidationType type) {
		if(type == ValidationType.INTEGER_ONLY) {
			field.clear();
        	field.setPromptText("Enter integer only!");
		}
		else if(type == ValidationType.DOUBLE_ONLY) {
			field.clear();
        	field.setPromptText("Enter double only!");
		}
		else if (type == ValidationType.OUT_OF_RANGE) {
			field.clear();
        	field.setPromptText("Out of Range!");
		}
		else {
			field.clear();
        	field.setPromptText("Cannot be Empty!");
		}
    	field.setStyle("-fx-border-color: red");
    }
}


