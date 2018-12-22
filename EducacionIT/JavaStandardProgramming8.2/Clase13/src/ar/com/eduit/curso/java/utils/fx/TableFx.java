package ar.com.eduit.curso.java.utils.fx;

import java.lang.reflect.Field;
import java.util.List;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableFx <E> {
    public void cargar(TableView<E> tbl, List<E> list){
        if(tbl == null) return;
        tbl.getColumns().clear(); //Si no es nulo, le borro las columnas.
        tbl.getItems().clear(); //Borro las filas que puede haber en la lista para poder empezar de nuevo.
        if(list == null || list.isEmpty()) return;
        
        E e = list.get(0); //Un objeto que va a ser igual al primer elemento de la lista.
        for(Field f : e.getClass().getDeclaredFields()){ //Se recorren los atributos del objeto e.
            TableColumn c = new TableColumn(f.getName()); //Se crea una columna de cada campo con su respectivo nombre.
            c.setCellValueFactory(new PropertyValueFactory(f.getName())); //A cada una de las columnas se le pone el tipo de datos.
            tbl.getColumns().add(c); //Agrega la columna que estoy creando en el momento a la tabla.
        }
        tbl.getItems().addAll(list); //Se agregan todas las filas.
    }
}
