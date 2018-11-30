package clase02;
public class Empleado {
    private int nLegajo;
    private String nombre;
    private int edad;
    private float sBasico;

    public Empleado(int nLegajo, String nombre, int edad, float sBasico) {
        this.nLegajo = nLegajo;
        this.nombre = nombre;
        this.edad = edad;
        this.sBasico = sBasico;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nLegajo=" + nLegajo + ", nombre=" + nombre + ", edad=" + edad + ", sBasico=" + sBasico + '}';
    }

    public int getnLegajo() {
        return nLegajo; //Devuelve el valor del atributo de la clase
    }

    public void setnLegajo(int nLegajo) {
        this.nLegajo = nLegajo; //Permite que el usuario cambie el valor del atributo de la clase.
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getsBasico() {
        return sBasico;
    }

    public void setsBasico(float sBasico) {
        this.sBasico = sBasico;
    }
    
    
}
