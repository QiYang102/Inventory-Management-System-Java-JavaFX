package GUI;

import Product_Class.Product;
import User_Class.UserInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.util.ArrayList;

public class b_ConMenu {
    @FXML
    private Button addStockButton;

    @FXML
    private Button deactiveProductButton;

    @FXML
    private Button deductStockButton;

    @FXML
    private Button viewProductButton;

    @FXML
    private Pane outputPane;

    @FXML
    private Pane productPane;
    
    @FXML
    private Pane updateDetailPane;
    
    @FXML
    private Pane addStockPane;
    
    @FXML
    private Pane deductStockPane;
    
    @FXML
    private Pane deactivatePane;
    
    @FXML
    private Pane exitPane;

    private Parent root;
    FXMLLoader loader;
    c_ConView nextController;
    private UserInfo user = new UserInfo();
    private ArrayList<Product> productList = new ArrayList<Product>();
    
    /* ----------------------- SETTER ----------------------- */
    public void setUser(UserInfo user){ this.user = user; }
    public void setProductList(ArrayList<Product> productList){ this.productList = productList; }


    /* ----------------------- BUTTON CLICK ----------------------- */
    
    /*
     *  ===================== View Product Button Click =====================
     */
    public void viewProductButtonClick(ActionEvent event) throws Exception{
        clearAllButtonColor();
        productPane.setStyle("-fx-background-color: #00d9ff");

        loader = new FXMLLoader(getClass().getResource("/FXML/ViewScene.fxml"));

        root = loader.load();
        outputPane.getChildren().addAll(root);

        nextController = loader.getController();
        nextController.setProductList(productList);
        nextController.setOutputTable();
        nextController.addDeleteSetup();
    }

    /*
     *  ===================== Update Product Detail Button Click =====================
     */
    public void updateDetailButtonClick(ActionEvent event) throws Exception{
        clearAllButtonColor();
        updateDetailPane.setStyle("-fx-background-color: #00d9ff");

        loader = new FXMLLoader(getClass().getResource("/FXML/ViewScene.fxml"));

        root = loader.load();
        outputPane.getChildren().addAll(root);

        nextController = loader.getController();
        nextController.setProductList(productList);
        nextController.setOutputTable();
        nextController.updateSetup();
    }
    
    /*
     *  ===================== Add Stock Button Click =====================
     */
    public void addStockButtonClick(ActionEvent event) throws Exception {
        clearAllButtonColor();
        addStockPane.setStyle("-fx-background-color: #00d9ff");

        loader = new FXMLLoader(getClass().getResource("/FXML/ViewScene.fxml"));

        root = loader.load();
        outputPane.getChildren().addAll(root);

        nextController = loader.getController();
        nextController.setProductList(productList);
        nextController.setOutputTable();
        nextController.addStockSetup();
    }

    /*
     *  ===================== Deduct Stock Button Click =====================
     */
    public void deductStockButtonClick(ActionEvent event) throws Exception{
        clearAllButtonColor();
        deductStockPane.setStyle("-fx-background-color: #00d9ff");

        loader = new FXMLLoader(getClass().getResource("/FXML/ViewScene.fxml"));

        root = loader.load();
        outputPane.getChildren().addAll(root);

        nextController = loader.getController();
        nextController.setProductList(productList);
        nextController.setOutputTable();
        nextController.deductStockSetup();
    }

    /*
     *  ===================== Deactivate / Activate Product Button Click =====================
     */
    public void deactiveProductButtonClick(ActionEvent event) throws Exception{
        clearAllButtonColor();
        deactivatePane.setStyle("-fx-background-color: #00d9ff");

        loader = new FXMLLoader(getClass().getResource("/FXML/ViewScene.fxml"));

        root = loader.load();
        outputPane.getChildren().addAll(root);

        nextController = loader.getController();
        nextController.setProductList(productList);
        nextController.setOutputTable();
        nextController.deactivateSetup();
    }

    /*
     *  ===================== Exit Button Click =====================
     */
    public void exitButtonClick(ActionEvent event) throws Exception{
        clearAllButtonColor();
        exitPane.setStyle("-fx-background-color: #00d9ff");
        
        String userNameID = user.getUsername() + " (" + user.getUserID() + ")";
        
        FXMLLoader exitLoader = new FXMLLoader(getClass().getResource("/FXML/ExitScene.fxml"));
        
        Parent root2 = exitLoader.load();
        Stage stage2 = new Stage();
        stage2.setTitle("Logout");
        stage2.setScene(new Scene(root2));
        Image icon = new Image(getClass().getResource("/Image/Snipaste_2025-04-23_23-19-14-removebg-preview.png").toExternalForm());
        stage2.getIcons().add(icon);
        stage2.show();
        stage2.setResizable(false);
        
        h_ConExit next = exitLoader.getController();
        next.setUserNameID(userNameID);
        
        Stage exit = (Stage) exitPane.getScene().getWindow();
        exit.close();
    }

    //Helper function to clear all button color
    private void clearAllButtonColor(){
        productPane.setStyle("-fx-background-color: white");
        updateDetailPane.setStyle("-fx-background-color: white");
        addStockPane.setStyle("-fx-background-color: white");
        deductStockPane.setStyle("-fx-background-color: white");
        deactivatePane.setStyle("-fx-background-color: white");
        exitPane.setStyle("-fx-background-color: white");
    }
}

