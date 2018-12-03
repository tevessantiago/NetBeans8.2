/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionit.vehiculos.presentacion.controladores;

import ar.com.educacionit.vehiculos.presentacion.ventanas.Ventanas;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rodolfo Durante
 */
public class AutosVentanaControlador extends ConcesionariaControlador implements Initializable {

    @FXML
    private Button btn_close;

    @FXML
    private Button btn_new;

    @FXML
    private Button btn_edit;

    @FXML
    private Button btn_delete;

    @FXML
    private TextArea txt_description;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btn_edit.setDisable(true);
        btn_delete.setDisable(true);
        txt_description.setEditable(false);
    }

    @FXML
    private void abrirAutosEdicion(ActionEvent event) {
        Stage stage = (Stage) btn_close.getScene().getWindow();
        super.mainApp.mostrarVentanaModal(Ventanas.AutosEdicion, stage);
    }

    @FXML
    private void cerrarVentana(ActionEvent event) {
        Stage stage = (Stage) btn_close.getScene().getWindow();
        stage.close();
    }

}
