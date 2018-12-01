/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package educacionit.javafx.tutorial04;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Rodolfo Durante
 */
public class FillDataExampleController implements Initializable {
    @FXML
    private Label lbl_name_value;
    @FXML
    private Label lbl_lastname_value;
    @FXML
    private Label lbl_address_value;
    @FXML
    private Label lbl_phone_value;
    @FXML
    private Label lbl_cell_value;
    @FXML
    private Label lbl_email_value;
    @FXML
    private Button btn_exit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lbl_name_value.setText("Juan");
        lbl_lastname_value.setText("Perez");
        lbl_address_value.setText("Castro Barros 333 - C.A.B.A.");
        lbl_phone_value.setText("11-4956-7878");
        lbl_cell_value.setText("15-6787-2356");
        lbl_email_value.setText("juan.perez@educacionit.com");
    }    

    @FXML
    private void handlerBtnExit(ActionEvent event) {
        Platform.exit();
    }
    
    
}
