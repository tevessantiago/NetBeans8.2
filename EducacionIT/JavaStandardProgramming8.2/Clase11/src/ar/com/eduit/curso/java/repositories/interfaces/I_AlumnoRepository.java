package ar.com.eduit.curso.java.repositories.interfaces;

import ar.com.eduit.curso.java.entities.Alumno;
import ar.com.eduit.curso.java.entities.Curso;
import java.util.List;

public interface I_AlumnoRepository {
    
    void save(Alumno alumno); //Entra un objeto Alumno y lo guarda. No importa el origen, pues para esto es la interfaz.
    
    void remove(Alumno alumno);
    
    void update(Alumno alumno);
    
    Alumno getById(int id); //Se ingresa un objeto id y me devuelve un objeto Alumno
    
    List<Alumno> getAll(); //Devuelve una coleccion de alumnos
    
    List<Alumno> getByApellido(String apellido); //Deveulve una lista de alumnos con el mismo apellido.
    
    List<Alumno> getLikeApellido(String apellido); //Devuelve lista de alumnos que contengan parte del apellido que se ingresa. Se ingresa una expresion.
    
    List<Alumno> getLikeApellidoNombre(String apellido, String nombre); //Devuelve lista de alumnos con el apellido y nombre ingresados.
    
    List<Alumno> getByCurso(int idCurso);
    
    List<Alumno> getByCurso(Curso curso);
}
