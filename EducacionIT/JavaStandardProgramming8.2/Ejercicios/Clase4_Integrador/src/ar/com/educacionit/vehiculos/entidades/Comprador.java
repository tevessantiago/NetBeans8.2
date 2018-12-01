package ar.com.educacionit.vehiculos.entidades;

import ar.com.educacionit.base.entidades.Persona;

public class Comprador extends Persona {
    
    double presupuesto;

    public Comprador(String nombre, String apellido, String numeroDocumento, double presupuesto) {
        super(nombre, apellido, numeroDocumento);
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString() {
        return "Comprador{" + "presupuesto=" + presupuesto + " " + super.toString() + '}';
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }    
    
}
