package laboratorio.ejercicio1.pruebas;

import laboratorio.ejercicio1.entidades.Zoologico;

public class Programa {
    
    public static void main(String[] args) {
        
        Zoologico zoo = new Zoologico();
        zoo.abrir();
        zoo.getStatus();
        zoo.alimentarAnimales(200);
        zoo.cerrar();
        zoo.getStatus();
        
    }
    
}
