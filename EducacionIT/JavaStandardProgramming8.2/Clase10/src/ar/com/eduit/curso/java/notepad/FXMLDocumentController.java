package ar.com.eduit.curso.java.notepad;
import ar.com.eduit.curso.java.utils.files.text.FileText;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
public class FXMLDocumentController implements Initializable {
    @FXML private TextArea txaTexto;
    @FXML
    private AnchorPane form;
    @Override public void initialize(URL url, ResourceBundle rb) { }    
    @FXML private void nuevo(ActionEvent event) { //Va a borrar el contenido de textarea para empezar uno nuevo
        if(txaTexto.getText().isEmpty()) return;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setContentText("¿Desea borrar el texto e iniciar uno nuevo?");
        if(alert.showAndWait().get()==ButtonType.OK) txaTexto.setText("");
    }
    @FXML private void abrir(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Abrir un archivo de texto.");
        fc.getExtensionFilters().add(new ExtensionFilter("Archivos de texto", "*.txt")); //Filtro para abrir unicamente archivos de texto.
        File file = fc.showOpenDialog(form.getScene().getWindow()); //Indicar cual es el componente padre. Para que el foco se mantenga en el filechooser. El filechooser devuelve un objeto de tipo file, en esta linea lo capturo con el File file =
        if(file == null) return; // Si no eligió ningún archivo salimos del metodo.
        txaTexto.setText(new FileText(file).getText());
    }
    @FXML private void guardar(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Guardar archivo de texto");
        fc.getExtensionFilters().add(new ExtensionFilter("Archivos de texto", "*.txt"));
        File file = fc.showSaveDialog(form.getScene().getWindow());
        if(file == null) return;
        /*
            
        */
        new FileText(file).setText(txaTexto.getText()); // Esto es lo mismo que hacer: FileText ftext = new FileText(file); La unica diferencia es que no le proporciono identificador al nuevo objeto.
    }
    @FXML private void acerca(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Bloc de Notas.");
        alert.setContentText("Curso Java.\nDiciembre 2018.");
        alert.show();
    }
    @FXML private void salir(ActionEvent event) {
        System.exit(0);
    }
}
