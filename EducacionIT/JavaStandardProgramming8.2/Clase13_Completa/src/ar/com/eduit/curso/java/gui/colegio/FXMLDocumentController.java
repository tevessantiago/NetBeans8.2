package ar.com.eduit.curso.java.gui.colegio;

import ar.com.eduit.curso.java.connector.Connector;
import ar.com.eduit.curso.java.entities.Alumno;
import ar.com.eduit.curso.java.entities.Curso;
import ar.com.eduit.curso.java.enums.Semana;
import ar.com.eduit.curso.java.enums.Turnos;
import ar.com.eduit.curso.java.repositories.implementacion.sql.AlumnoR;
import ar.com.eduit.curso.java.repositories.implementacion.sql.CursoR;
import ar.com.eduit.curso.java.repositories.interfaces.I_AlumnoRepository;
import ar.com.eduit.curso.java.repositories.interfaces.I_CursoRepository;
import ar.com.eduit.curso.java.utils.fx.TableFx;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class FXMLDocumentController implements Initializable { 
    
    private I_AlumnoRepository ar;
    private I_CursoRepository cr;
    private List<Semana> semana = Arrays.asList(Semana.values());
    private List<Turnos> turnos = Arrays.asList(Turnos.values());
    
    //Atributos de la solapa Alumno
    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private TextField txtEdad;
    @FXML private ComboBox<Curso> cmbCurso;
    @FXML private Label lblInfoAlumno;
    @FXML private TableView<Alumno> tblAlumnos;
    @FXML private TextField txtBuscarApe;
    
    //Atributos de la solapa Curso
    @FXML private TextField txtTitulo;
    @FXML private TextField txtProfesor;
    @FXML private ComboBox<Semana> cmbDia;
    @FXML private ComboBox<Turnos> cmbTurno;
    @FXML private Label lblInfoCurso;
    @FXML private TableView<Curso> tblCursos;
    @FXML private TextField txtBuscarCurso;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ar = new AlumnoR(Connector.getConnection());
        cr = new CursoR(Connector.getConnection());
        cargar(); //para que cuando arranque el formulario estén las listas cargadas.
    }

    private void cargar(){ //va a cargar todos los elementos que tengan listas.
        //cargar cmbCursos
        cmbCurso.getItems().clear(); //Si tiene elementos, los estoy borrando.
        cmbCurso.getItems().addAll(cr.getAll()); //Obtiene todos los cursos.
        cmbCurso.getSelectionModel().selectFirst(); //Deja seleccionado como default el primer curso.
        
        //cargar tblAlumnos
        new TableFx<Alumno>().cargar(tblAlumnos, ar.getAll());
        
        //cargar cmbDia
        cmbDia.getItems().clear();
        cmbDia.getItems().addAll(semana);
        cmbDia.getSelectionModel().select(Semana.LUNES);
        
        //cargar cmbTurno
        cmbTurno.getItems().clear();
        cmbTurno.getItems().addAll(turnos);
        cmbTurno.getSelectionModel().selectFirst();
        
        //cargar tblCursos
        new TableFx<Curso>().cargar(tblCursos, cr.getAll());
        
    }

    @FXML private void altaAlumno(ActionEvent event) {
        if(validarAlumno()){
            Alumno alumno = new Alumno(
                    txtNombre.getText(),                    //nombre
                    txtApellido.getText(),                  //apellido
                    Integer.parseInt(txtEdad.getText()),    //edad
                    cmbCurso.getValue().getId()             //getValue me devuelve un objeto curso seleccionado.
            );
            ar.save(alumno);
            lblInfoAlumno.setText("Se dio de alta un alumno id: " + alumno.getId());
            limpiarAlumno();
        }        
        cargar(); //para tenerlas actualizadas
    }
    
    private boolean validarAlumno(){
        //Validar Nombre entre 2 y 45 caracteres
        if(txtNombre.getText().length() < 2 || txtNombre.getText().length() > 45){
            lblInfoAlumno.setText("La longitud del nombre debe ser entre 2 y 45 caracteres.");
            txtNombre.selectAll(); //para que te quede el texto en la casilla seleccionada
            txtNombre.requestFocus(); //para que quede el foco en esa casilla
            return false;
        }
        //Validar Apellido entre 2 y 45 caracteres
        if(txtApellido.getText().length() < 2 || txtApellido.getText().length() > 45){
            lblInfoAlumno.setText("La longitud del apellido debe ser entre 2 y 45 caracteres.");
            txtApellido.selectAll();
            txtApellido.requestFocus();
            return false;
        }
        //Validar Edad que sea entero entre 18 y 120
        try {
            int edad = Integer.parseInt(txtEdad.getText());
            if(edad < 18 || edad > 120){
                lblInfoAlumno.setText("La edad debe ser entre 18 y 120 años.");
                txtEdad.selectAll();
                txtEdad.requestFocus();
                return false;
            }
        } catch (Exception e) {
            lblInfoAlumno.setText("La edad debe ser un numero entero.");
            txtEdad.selectAll();
            txtEdad.requestFocus();
            return false;
        }
        
        return true;
    }
    
    private void limpiarAlumno(){
        txtNombre.setText("");
        txtApellido.setText("");
        txtEdad.setText("");
        cmbCurso.getSelectionModel().selectFirst();
        txtNombre.requestFocus();
    }

    @FXML private void buscarApellido(KeyEvent event) {        
        new TableFx().cargar(tblAlumnos, ar.getLikeApellido(txtBuscarApe.getText()));
    }

    @FXML private void eliminarAlumno(ActionEvent event) {
        Alumno alumno = tblAlumnos.getSelectionModel().getSelectedItem();
        if(alumno == null) return;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Cuidado");
        alert.setContentText("Se borrara un alumno.");
        if(alert.showAndWait().get() == ButtonType.OK){ //va a mostrar el cartel y preguntar si es ok borrar.
            ar.remove(alumno);
        }
        cargar();
    }

    @FXML private void altaCurso(ActionEvent event) {
        if(validarCurso()){
            Curso curso = new Curso(
                    txtTitulo.getText(),
                    txtProfesor.getText(),
                    cmbDia.getValue(),
                    cmbTurno.getValue()
            );
            cr.save(curso);
            lblInfoCurso.setText("Se dio de alta un curso. id: " + curso.getId());
            limpiarCurso();
        }
        cargar();
    }
    
    private boolean validarCurso(){
        
        if(txtTitulo.getText().length() > 20){
            lblInfoCurso.setText("La longitud del titulo debe contener menos de 20 caracteres.");
            txtTitulo.selectAll();
            txtTitulo.requestFocus();
            return false;
        }    
            
        if(txtProfesor.getText().length() > 20){
            lblInfoCurso.setText("La longitud del nombre del profesor debe contener menos de 20 caracteres.");
            txtProfesor.selectAll();
            txtTitulo.requestFocus();
            return false;   
        }
        
        return true;
            
    }
    
    private void limpiarCurso(){
        txtTitulo.setText("");
        txtProfesor.setText("");
        cmbDia.getSelectionModel().select(Semana.LUNES);
        cmbTurno.getSelectionModel().selectFirst();
        txtTitulo.requestFocus();
    }

    @FXML private void buscarCurso(KeyEvent event) {
        new TableFx().cargar(tblCursos, cr.getLikeTitulo(txtBuscarCurso.getText()));
    }

    @FXML private void eliminarCurso(ActionEvent event) {
        Curso curso = tblCursos.getSelectionModel().getSelectedItem();
        if(curso == null) return;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Cuidado");
        alert.setContentText("Se borrara un curso.");
        if(alert.showAndWait().get() == ButtonType.OK){
            ar.getByCurso(curso.getId()).forEach((a) -> ar.remove(a));
            cr.remove(curso);
        }
        cargar();
    }
}
    
