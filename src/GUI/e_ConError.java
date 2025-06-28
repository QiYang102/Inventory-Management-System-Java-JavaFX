package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class e_ConError {

    @FXML
    private Button closeButton;
    
    /*
     *  ===================== Close Button Click =====================
     */
    @FXML
    void closeButtonClick(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

}

