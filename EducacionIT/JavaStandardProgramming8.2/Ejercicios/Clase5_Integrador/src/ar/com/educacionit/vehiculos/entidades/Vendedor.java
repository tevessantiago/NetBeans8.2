package ar.com.educacionit.vehiculos.entidades;

import ar.com.educacionit.base.entidades.Persona;

public class Vendedor extends Persona {
    
    int cantAutosVendidos;

    public Vendedor(String nombre, String apellido, String numeroDocumento, int cantAutosVendidos) {
        super(nombre, apellido, numeroDocumento);
        this.cantAutosVendidos = cantAutosVendidos;
    }

    @Override
    public String toString() {
        return "Vendedor{" + "cantAutosVendidos=" + cantAutosVendidos + " " + super.toString() + '}';
    }

    public int getCantAutosVendidos() {
        return cantAutosVendidos;
    }

    public void setCantAutosVendidos(int cantAutosVendidos) {
        this.cantAutosVendidos = cantAutosVendidos;
    }    
    
}
