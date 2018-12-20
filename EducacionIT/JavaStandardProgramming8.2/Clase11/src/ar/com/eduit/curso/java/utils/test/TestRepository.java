package ar.com.eduit.curso.java.utils.test;

import ar.com.eduit.curso.java.connector.Connector;
import ar.com.eduit.curso.java.entities.Alumno;
import ar.com.eduit.curso.java.repositories.implementacion.sql.AlumnoR;

public class TestRepository {
    public static void main(String[] args) {
        
        AlumnoR ar = new AlumnoR(Connector.getConnection()); //tengo el objeto de conexion a la base.
        
        Alumno alumno = new Alumno("Josefina", "Alarcon", 32, 1); //No tengo id, eso lo pone la base. Se usa el constructor que no pide id.
        
        ar.save(alumno); //Se guarda en la base.
        
        System.out.println(alumno);
        
        //ar.getAll().forEach(System.out::println);
        
        ar.getLikeApellido("go").forEach(System.out::println);
    }
    
}
