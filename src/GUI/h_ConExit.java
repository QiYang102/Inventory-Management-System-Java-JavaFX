package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class h_ConExit {

    @FXML
    private Label userNameID;
    
    /* ----------------------- SETTER ----------------------- */
    public void setUserNameID(String userNameID) { this.userNameID.setText(userNameID); }
}
