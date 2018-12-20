package ar.com.eduit.curso.java.repositories.interfaces;

import ar.com.eduit.curso.java.entities.Alumno;
import ar.com.eduit.curso.java.entities.Curso;
import ar.com.eduit.curso.java.enums.Semana;
import ar.com.eduit.curso.java.enums.Turnos;
import java.util.List;

public interface I_CursoRepository {
    
    void save(Curso curso);    
    void remove(Curso curso);    
    void update(Curso curso);    
    Curso getById(int id);    
    Curso getByAlumno(int idAlumno);    
    Curso getByAlumno(Alumno alumno); //Ingresa el objeto alumno y devuelve objeto curso    
    List<Curso> getAll(); //A medir que sea factible en la base, que no haya mucha carga en memoria.    
    List<Curso> getByTitulo(String titulo);    
    List<Curso> getLikeTitulo(String titulo);    
    List<Curso> getByProfesor(String profesor);    
    List<Curso> getLikeProfesor(String profesor);    
    List<Curso> getLikeTituloProfesor(String titulo, String profesor); //Corregir esta línea en la clase 11. 
    List<Curso> getLikeTituloProfesorDiaTurno(String titulo, String profesor, Semana dia, Turnos turno);
}
