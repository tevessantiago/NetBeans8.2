package ar.com.eduit.curso.java.connector;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector { //Crea una conexion a cualquier base de datos, cambiando parametros
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/colegio";
    private static String user = "root";
    private static String pass = "";
    private static Connection conn = null;
    private Connector(){}; //constructor privado. No se pueden crear objetos de la conexion.
    public synchronized static Connection getConnection(){ //va a devolver la conexion y me va a asegurar de que sea un objeto unico (y no muchos).
        if (conn == null){ //asegura la instancia unica. Si esta condicion se abre un nuevo puerto por cada conexion que se llame.
            try{
                Class.forName(driver); //Me crea un objeto de la clase indicada en el string del atributo driver.
                conn = DriverManager.getConnection(url, user, pass);
            } catch (Exception e){ System.out.println(e);}
        }
        return conn;
    }
}
