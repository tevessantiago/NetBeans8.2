/*
 * Comprador.java
 *
 */
package ar.com.educacionit.vehiculos.entidades;

import ar.com.educacionit.base.entidades.Persona;

/**
 *
 * @author Sebastian S. Sanga <SebastianSanga@educacionIT.com.ar>
 */
public class Comprador extends Persona {

    /**
     * Creates a new instance of Comprador
     */
    public Comprador() {
    }

    public Comprador(String nombre, String apellido, String nroDocumento, double presupuesto) {
        super(nombre, apellido, nroDocumento);
        setPresupuesto(presupuesto);
    }

    // Atributos
    private double presupuesto;

    public String toString() {
        return super.toString() + " Presupuesto: $" + getPresupuesto();
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

}
