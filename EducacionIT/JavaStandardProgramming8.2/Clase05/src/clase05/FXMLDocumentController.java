package clase05;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javax.swing.JOptionPane;

public class FXMLDocumentController implements Initializable {
    
    private ToggleGroup grupoEstado;
        
    @FXML //Con esto llamo desde la vista
    private TextField txtNombre;
    @FXML
    private CheckBox chkBici;
    @FXML
    private CheckBox chkMoto;
    @FXML
    private CheckBox chkAuto;
    @FXML
    private TextArea txaTexto;
    @FXML
    private RadioButton radSoltero;
    @FXML
    private RadioButton radCasado;
    @FXML
    private RadioButton radViudo;
    @FXML
    private RadioButton radDivorciado;
    @FXML
    private ComboBox<String> cmbColores; //Dentro del tag se pone el tipo de dato de la lista
        
    //Haciendo click derecho en FXMLDocument.fxml y presionando make controller, se crean los atributos y methodos declarados en la vista.
    @FXML 
    private void aceptar(ActionEvent evt){
        String nombre = txtNombre.getText(); //Devuelve el texto que está en el campo de texto en la vista
        //JOptionPane.showMessageDialog(null, "Hola " + nombre);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Hola " + nombre);
        alert.showAndWait();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Inicializa el grupoEstado
        grupoEstado = new ToggleGroup();
        grupoEstado.getToggles().addAll(radSoltero,radCasado,radViudo,radDivorciado); //Para seleccionar un solo elemento de los radio checkbox
        radSoltero.setSelected(true); //Por default deja el estado civil como soltero
        
        //carga de cmbColores
        cmbColores.getItems().addAll("Rojo", "Verde", "Azul", "Blanco", "Negro", "Gris");
        cmbColores.getSelectionModel().selectFirst(); //Deja seleccionado por default el primero, en este caso Rojo.
        
        
    }    

    @FXML
    private void agregar(ActionEvent event) {
        
        String texto = "";
        
        if(txtNombre.getText().length()>=2){ //Si hay dos o más letras...
            texto += "Nombre: " + txtNombre.getText() + ".\n";
            if(chkBici.isSelected()) texto += "Tiene Bici.\n";
            if(chkMoto.isSelected()) texto += "Tiene Moto.\n";
            if(chkAuto.isSelected()) texto += "Tiene Auto.\n";
            texto += "Estado Civil: " + ((RadioButton)grupoEstado.getSelectedToggle()).getText() + ".\n"; //Se castea a RadioButton para poder utilizar el getText
            String color = cmbColores.getValue(); //El color elegido en cmbColores
            texto += "Color: " + color + ".\n";
            
            //Se traduce el color a ingles porque al aplicar el estilo se pide color en ingles. Para poner el color como fondo del textArea.
            switch(color){ //Lo ideal sería resolverlo con un mapa, se verá en la clase 7
                case "Rojo"     : color = "red";        break;
                case "Verde"    : color = "green";      break;
                case "Azul"     : color = "blue";       break;
                case "Blanco"   : color = "white";      break;
                case "Negro"    : color = "black";      break;
                case "Gris"     : color = "gray";       break;
                default         : color = "gray";
            }
            txaTexto.setStyle("-fx-control-inner-background:" + color + ";");
        }
        
        
        limpiar();
        txaTexto.setText(texto);
    }
    
    private void limpiar(){
        txtNombre.setText("");
        txtNombre.requestFocus();
        chkBici.setSelected(false);
        chkMoto.setSelected(false);
        chkAuto.setSelected(false);
        radSoltero.setSelected(true); //Vuelve a dejar el default seleccionado
        cmbColores.getSelectionModel().selectFirst(); //Vuelve a dejar el default seleccionado
    }
}
