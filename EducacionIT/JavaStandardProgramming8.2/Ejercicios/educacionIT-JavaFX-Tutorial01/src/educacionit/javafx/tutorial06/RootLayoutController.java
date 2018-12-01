/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package educacionit.javafx.tutorial06;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Rodolfo Durante
 */
public class RootLayoutController implements Initializable {

    private Runner mainApp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void handleOpenContact(ActionEvent event) {
        this.mainApp.showContactABM();
    }

    @FXML
    private void handleOpenWindow(ActionEvent event) {
        this.mainApp.showInternalWindow();
    }

    @FXML
    private void handleCloseMenu(ActionEvent event) {
        Platform.exit();
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param runner
     */
    public void setMainApp(Runner runner) {
        this.mainApp = runner;
    }

}
