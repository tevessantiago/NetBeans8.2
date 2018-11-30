package ar.com.eduit.curso.java.entities;
public class Cliente extends Persona {
    private int nro;
    private Cuenta cuenta;

    public Cliente(int nro, Cuenta cuenta, String nombre, String apellido, int edad, Direccion direccion) {
        super(nombre, apellido, edad, direccion);
        this.nro = nro;
        this.cuenta = cuenta;
    }
    
    @Override
    public void saludar(){
        System.out.println("Hola, soy un cliente.");
    }

    @Override
    public String toString() {
        return "Cliente{" + "nro=" + nro + ", cuenta=" + cuenta + super.toString() + '}';
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }   
    
}
