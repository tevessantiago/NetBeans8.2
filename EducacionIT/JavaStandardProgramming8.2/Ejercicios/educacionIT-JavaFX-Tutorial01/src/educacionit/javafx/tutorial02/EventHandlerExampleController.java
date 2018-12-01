/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package educacionit.javafx.tutorial02;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Rodolfo Durante
 */
public class EventHandlerExampleController implements Initializable {

    @FXML
    private TextField field_nombre;
    @FXML
    private TextField field_apellido;
    @FXML
    private CheckBox check_experiencia;
    
    private boolean empty = true;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handlerLlenarButtonAction(ActionEvent event) {
        if (empty) {
            field_nombre.setText("Juan");
            field_apellido.setText("Perez");
            check_experiencia.setSelected(true);
            empty= false;
        } else {
            field_nombre.setText("");
            field_apellido.setText("");
            check_experiencia.setSelected(false);
            empty= true;
        }
    }

}
