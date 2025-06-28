package GUI;

import Product_Class.Product;
import User_Class.UserInfo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class z_App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(z_App.class.getResource("/FXML/LoginScene.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setTitle("UTAR SMS System");
        stage.setScene(scene);
        stage.setResizable(false);
        
        Image icon = new Image(getClass().getResource("/Image/Snipaste_2025-04-23_23-19-14-removebg-preview.png").toExternalForm());
        stage.getIcons().add(icon);
        stage.show();

        UserInfo user = new UserInfo();
        ArrayList<Product> productList = new ArrayList<Product>();

        a_ConLogin nextController = fxmlLoader.getController();
        nextController.setUser(user);
        nextController.setProductList(productList);
    }

    public static void main(String[] args) { launch();}
}

