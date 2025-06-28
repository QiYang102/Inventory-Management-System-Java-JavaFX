package GUI;

import Product_Class.Product;
import User_Class.UserInfo;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class a_ConLogin implements Initializable {
    @FXML
    private TextField usernameTextField;

    @FXML
    private Label outputLabel;

    @FXML
    private Label time;

    @FXML
    private Label date;

    private Parent root;
    private Scene scene;
    private Stage stage;
    private Timeline clockTimeline;
    private UserInfo user = new UserInfo();
    private ArrayList<Product> productList = new ArrayList<Product>();
    
    /* ----------------------- SETTER ----------------------- */
    public void setUser(UserInfo user){ this.user = user; }
    public void setProductList(ArrayList<Product> productList){ this.productList = productList; }

    
    /* ----------------------- INITIALIZE ----------------------- */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setupClock();
    }

    
    /* ----------------------- CLOCK SETTING ----------------------- */
    private void setupClock(){
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEEE, MMMM d");

        updateClock(timeFormatter, dateFormatter);

        clockTimeline = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> updateClock(timeFormatter, dateFormatter))
        );
        clockTimeline.setCycleCount(Timeline.INDEFINITE);
        clockTimeline.play();
    }
    
    private void updateClock(DateTimeFormatter timeFormatter, DateTimeFormatter dateFormatter) {
        LocalDateTime now = LocalDateTime.now();
        Platform.runLater(() -> {
            time.setText(now.format(timeFormatter));
            date.setText(now.format(dateFormatter));
        });
    }

    /* ----------------------- BUTTON CLICK ----------------------- */
    
    /*
     *  ===================== Login Button Click =====================
     */
    @FXML
    public void loginButtonClick(ActionEvent e) {
    	usernameTextField.focusedProperty().addListener((obs, oldVal, newVal) -> {
    	    if (newVal) {
    	        usernameTextField.setStyle("");
    	        usernameTextField.setPromptText("ex Johnson Ming"); // Or your default placeholder
    	    }
    	});
    	
        String username = usernameTextField.getText().trim();
        String userID = generateUserID(username);

        user.setUsername(username);
        user.setUserID(userID);
        
        if(userID.isEmpty()) {
        	return;
        }
        
        outputLabel.setText("Welcome " + user.getUserID());

        // Add a 0.5-second delay before switching to the next scene
        PauseTransition delay = new PauseTransition(Duration.seconds(0.5));
        delay.setOnFinished(event -> {
            try {
                // Load the next scene after the delay
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/MenuScene.fxml"));
                root = loader.load();
                stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();

                b_ConMenu nextController = loader.getController();
                nextController.setUser(user);
                nextController.setProductList(productList);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        delay.play(); // Start the delay
    }

    /* ----------------------- METHOD ----------------------- */
    //1) Generate user id
    private String generateUserID(String username){
        char initial;
        String subname = "";
        String userID;

        //Case 1: user name contain space (first character + last name)
        if (username.contains(" ")) {
            initial = username.charAt(0);
            subname = username.substring(findLastSpaceIndex(username) + 1);
            userID = initial + subname;
        }
        //Case 2: user name does not contain space (guest)
        else if (!username.contains(" ") && !username.isEmpty())
            userID = "guest";
        //Case 3: user name is empty (error)
        else {
        	usernameTextField.clear();
        	usernameTextField.setPromptText("Username cannot be Empty!");
        	usernameTextField.setStyle("-fx-border-color: red");
        	userID = "";
        }
        return userID;
    }
    
    //2) Helper function to find last space index
    private int findLastSpaceIndex(String username){
        int curr = username.indexOf(" ");
        int next = username.indexOf(" ", curr + 1);

        while(next != -1){
            curr = next;
            next = username.indexOf(" ", curr + 1);
        }

        return curr;
    }
}

