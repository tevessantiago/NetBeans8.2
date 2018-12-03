/*
 * Programa.java
 *
 */

package ar.com.educacionit.vehiculos.pruebas;

import ar.com.educacionit.vehiculos.ventanas.VentanaMaestra;
import java.awt.Dimension;

/**
 *
 * @author Sebastian S. Sanga <SebastianSanga@educacionIT.com.ar>
 */
public class Programa {
    
    /**
     * Creates a new instance of Programa
     */
    public Programa() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Construye y visualiza la ventana
        VentanaMaestra v = new VentanaMaestra();
        
        // Establece el tamaño
        v.setSize(1024,650);
        
        // Establece que no se pueda modificar el tamaño de la ventana
        v.setResizable(false);
        
        // Establece la ventana como visible
        v.setVisible(true);
        
    }
    
}
