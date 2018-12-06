package clase08;
public class Vuelo {
    private String nombre;
    private int cantidad;

    public Vuelo(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Vuelo[" + "nombre=" + nombre + ", cantidad=" + cantidad + ']';
    }
    
    public synchronized void venderPasajes(int cantidad) throws NoHayMasPasajesException{ //Throws avisa que puede lanzar la excepcion especificada. Synchronized es para evitar que dos usuarios compren pasajes a la vez, se espera a que el primer usuario termine la transaccion para que el segundo usuario llame al method.
        if(this.cantidad < cantidad) throw new NoHayMasPasajesException(nombre,cantidad); //Al hacer throw se corta el control del metodo y no se continua ejecutando. Se lanza la excepcion. Para usar Throw tiene que haber un Throws en la declaracion del metodo.
        this.cantidad -= cantidad;
    }
}
