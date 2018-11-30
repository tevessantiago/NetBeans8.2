package ar.com.eduit.curso.java.entities;
public abstract class Persona { //Es abstract, no puedo crear objetos.
    private String nombre;
    private String apellido;
    private int edad;
    private Direccion direccion;

    public Persona(String nombre, String apellido, int edad, Direccion direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.direccion = direccion; //Si creemos que una persona puede mudarse, hay que agregar setter.
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", direccion=" + direccion + '}';
    }
    
    public void saludar(){
        System.out.println("Hola, soy una persona.");
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public Direccion getDireccion() {
        return direccion;
    }
    
    
}
