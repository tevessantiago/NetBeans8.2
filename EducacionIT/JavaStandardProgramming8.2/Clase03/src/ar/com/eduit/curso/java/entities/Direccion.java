package ar.com.eduit.curso.java.entities;
public class Direccion {
    
    private String calle;
    private int nro;
    private String piso;
    private String depto;
    private String ciudad;

    public Direccion(String calle, int nro, String piso, String depto, String ciudad) {
        this.calle = calle;
        this.nro = nro;
        this.piso = piso;
        this.depto = depto;
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Direccion{" + "calle=" + calle + ", nro=" + nro + ", piso=" + piso + ", depto=" + depto + ", ciudad=" + ciudad + '}';
    }    
    
}
