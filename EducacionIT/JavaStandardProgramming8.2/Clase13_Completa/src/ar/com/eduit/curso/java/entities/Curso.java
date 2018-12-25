/*
 * Representa la tabla Curso
 */
package ar.com.eduit.curso.java.entities;

import ar.com.eduit.curso.java.enums.Semana;
import ar.com.eduit.curso.java.enums.Turnos;

public class Curso {
    
    private int id;
    private String titulo;
    private String profesor;
    private Semana dia;
    private Turnos turno;

    public Curso() {
    }

    public Curso(String titulo, String profesor, Semana dia, Turnos turno) {
        this.titulo = titulo;
        this.profesor = profesor;
        this.dia = dia;
        this.turno = turno;
    }

    public Curso(int id, String titulo, String profesor, Semana dia, Turnos turno) {
        this.id = id;
        this.titulo = titulo;
        this.profesor = profesor;
        this.dia = dia;
        this.turno = turno;
    }

    @Override
    public String toString() {
        //return "Curso[" + "id=" + id + ", titulo=" + titulo + ", profesor=" + profesor + ", dia=" + dia + ", turno=" + turno + ']';
        return titulo + ", " + profesor + ", " + dia + ", " + turno;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public Semana getDia() {
        return dia;
    }

    public void setDia(Semana dia) {
        this.dia = dia;
    }

    public Turnos getTurno() {
        return turno;
    }

    public void setTurno(Turnos turno) {
        this.turno = turno;
    }
    
    
}
