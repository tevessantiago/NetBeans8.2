package ar.com.eduit.curso.java.utils.test;

import ar.com.eduit.curso.java.connector.Connector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class TestConnector {
    public static void main(String[] args) throws Exception {
        
        Connector.getConnection().createStatement().execute( //Execute no puede ejecutar un select.
                "insert into alumnos (nombre,apellido,edad,idCurso) values "
                + "('Mario','Sosa',23,1)"
        );
        
        Connection conn = Connector.getConnection();
        String query="insert into alumnos (nombre,apellido,edad,idCurso) values "
                + "('Hernan','Corre',23,1)";        
        Statement st=conn.createStatement(); //Es un objeto que representa una sentencia sql.
        st.execute(query);
        
        Connector.getConnection().createStatement().execute( //Execute no puede ejecutar un select.
                "insert into alumnos (nombre,apellido,edad,idCurso) values "
                + "('Ana','Gomez',23,1)"
        ); //No abre una nueva, me trae la ya existente.
        
        conn = Connector.getConnection();
        query="insert into alumnos (nombre,apellido,edad,idCurso) values "
                + "('Carolina','Mendez',23,1)";        
        st=conn.createStatement(); //Es un objeto que representa una sentencia sql.
        st.execute(query);
        
        //Select
        ResultSet rs = Connector.getConnection().createStatement().executeQuery(
                "select * from alumnos"
        );
        //Se muestran los registros guardados en rs
        while(rs.next()){ //true si hay nuevo registro, false si no hay
            System.out.println(
                    rs.getInt("id") + "\t" + 
                    rs.getString("nombre") + "\t" +
                    rs.getString("apellido") + "\t" +
                    rs.getInt("edad") + "\t" +
                    rs.getInt("idCurso"));
        }
        
        
        
        System.out.println("Presione ENTER para terminar.");
        new Scanner(System.in).nextLine();
        
        //conn.close(); Quiero se abra el programa inicie la conexion y una vez termine la ejecucion automaticamente se cierre.
    } //El hecho de pasar por esta llave hace que se pierda el scope, se cierre la conexion.
}
