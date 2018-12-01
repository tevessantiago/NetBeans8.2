package laboratorio.ejercicio1.entidades;

import java.util.Date;

public abstract class Persona {
    
    private String nombre;
    private Date fechaDeNacimiento;
    
    public Persona(){        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }    
    
}
