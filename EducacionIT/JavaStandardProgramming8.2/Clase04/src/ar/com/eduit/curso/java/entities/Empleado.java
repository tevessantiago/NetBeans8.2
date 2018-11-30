package ar.com.eduit.curso.java.entities;
public class Empleado extends Persona {
    private int nroLegajo;
    private float sBasico;
    
    //Los valores de los parametros se asignan a los atributos.
    //El constructor es un método que instancia los atributos de la clase.
    public Empleado(int nroLegajo, float sBasico, String nombre, String apellido, int edad, Direccion direccion) {
        super(nombre, apellido, edad, direccion); //Se asignan los valores a los atributos de Persona.
        this.nroLegajo = nroLegajo;
        this.sBasico = sBasico;
    }
    
    //Se sobreescribe el metodo saludar, ahora la persona empleado saluda de esta manera.
    @Override
    public void saludar(){
        System.out.println("Hola, soy un empleado.");
    }

    @Override
    public String toString() {
        return "Empleado{" + "nroLegajo=" + nroLegajo + ", sBasico=" + sBasico + super.toString() + '}'; //Super llama a la clase padre (Persona).
    }

    public int getNroLegajo() {
        return nroLegajo;
    }

    public void setNroLegajo(int nroLegajo) {
        this.nroLegajo = nroLegajo;
    }

    public float getsBasico() {
        return sBasico;
    }

    public void setsBasico(float sBasico) {
        this.sBasico = sBasico;
    }   
    
}
