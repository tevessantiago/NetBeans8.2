package ar.com.eduit.curso.java.test;

import ar.com.eduit.curso.java.entities.Direccion;
import ar.com.eduit.curso.java.entities.Persona;

public class TestHerencia {
    public static void main(String[] args) {
        System.out.println("-- dir1 --");
        Direccion dir1 = new Direccion("Lavalle",648,"8","a","CABA");
        System.out.println(dir1);
        
        System.out.println("-- dir2 --");
        Direccion dir2 = new Direccion("Lima",222,"1","b","CABA");
        System.out.println(dir2);
        
        /*System.out.println("-- persona1 --");
        Persona persona1 = new Persona("Ana", "Benitez", 30, dir1);
        System.out.println(persona1);
        persona1.saludar();
        
        System.out.println("-- persona2 --");
        Persona persona2 = new Persona("Diego", "Loza", 22, new Direccion("Maipu",222,"1","c","CABA"));
        System.out.println(persona2);
        persona2.saludar();
        
        System.out.println("-- persona3 --");
        Persona persona3 = new Persona("Jose", "Torres", 33, persona1.getDireccion());
        System.out.println(persona3);
        persona3.saludar(); */
        
    }
}
