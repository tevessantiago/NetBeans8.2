package ar.com.eduit.curso.java.utils.test;

import ar.com.eduit.curso.java.connector.Connector;
import ar.com.eduit.curso.java.entities.Alumno;
import ar.com.eduit.curso.java.entities.Curso;
import ar.com.eduit.curso.java.enums.Semana;
import ar.com.eduit.curso.java.enums.Turnos;
import ar.com.eduit.curso.java.repositories.implementacion.sql.AlumnoR;
import ar.com.eduit.curso.java.repositories.implementacion.sql.CursoR;

public class TestRepository {
    public static void main(String[] args) {
        
        AlumnoR ar = new AlumnoR(Connector.getConnection()); //tengo el objeto de conexion a la base.
        
        Alumno alumno = new Alumno("Josefina", "Alarcon", 32, 1); //No tengo id, eso lo pone la base. Se usa el constructor que no pide id.
        
        ar.save(alumno); //Se guarda en la base.
        
        System.out.println(alumno);
        
        ar.remove(ar.getById(2)); //Se borra el objeto con id=2 para siempre.
        
        alumno = ar.getById(3); //Se le cambia el nombre a la Josefina que tiene id 3.
        if(alumno != null){
            alumno.setNombre("Sergio");
            alumno.setEdad(45);
            ar.update(alumno);
        }
        
        System.out.println("******************************************");
        
        ar.getAll().forEach(System.out::println);        
        //ar.getLikeApellido("go").forEach(System.out::println);
        
        System.out.println("******************************************");
        
        CursoR cr = new CursoR(Connector.getConnection());
        
        Curso curso = new Curso("PHP","Segovia",Semana.MARTES,Turnos.NOCHE);
        
        cr.save(curso);
        
        System.out.println(curso);
        
        cr.remove(cr.getById(8));
        
        curso = cr.getById(10);
        if(curso!=null){
            curso.setDia(Semana.LUNES);
            curso.setTurno(Turnos.TARDE);
            curso.setProfesor("Rivas");
            cr.update(curso);
        }
        
        cr.getAll().forEach(System.out::println);
        //cr.getByProfesor("Gomez").forEach(System.out::println);
        //cr.getLikeTituloProfesorDiaTurno("", "", Semana.MARTES, Turnos.NOCHE)
        //        .forEach(System.out::println);
        
        
        
    }
    
}
