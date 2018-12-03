/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionit.vehiculos.presentacion.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Control;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author Rodolfo Durante
 */
public abstract class EdicionControlador implements Initializable {

    private List<Control> campos;

    public EdicionControlador() {
        this.campos = new ArrayList<>();
    }

    protected void addCampo(Control field) {
        this.campos.add(field);
    }

    protected boolean validarCampos() {
        for (Control campo : campos) {
            if (campo instanceof TextField) {
                TextField c = (TextField) campo;
                if (c.getText().isEmpty()) {
                    validacionFalla(campo);
                    return false;
                }
            }
            if (campo instanceof TextArea) {
                TextArea c = (TextArea) campo;
                if (c.getText().isEmpty()) {
                    validacionFalla(campo);
                    return false;
                }
            }
        }
        return validacionOk();
    }

    private boolean validacionOk() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText("Esta a punto de guardar los cambios...");
        alert.setContentText("desea continuar?");
        Optional<ButtonType> result = alert.showAndWait();
        return (result.get() == ButtonType.OK);
    }

    private void validacionFalla(Control control) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Datos incompletos");
        alert.setHeaderText("Por favor complete todos los campos");
        alert.setContentText("El campo " + control.getTooltip().getText() + " no puede estar vacio.");
        alert.showAndWait();
        control.requestFocus();
    }

}
