package ar.com.eduit.curso.java.entities;
public class ClientePersona {
    private int nro;
    private String nombre;
    private String apellido;
    private Cuenta cuenta;

    public ClientePersona(int nro, String nombre, String apellido, int nroCuenta) {
        this.nro = nro;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuenta = new Cuenta(nroCuenta, "arg$");
    }

    @Override
    public String toString() {
        return "ClientePersona{" + "nro=" + nro + ", nombre=" + nombre + ", apellido=" + apellido + ", cuenta=" + cuenta + '}';
    }
    
    public int getNro() {
        return nro;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }    
    
}
