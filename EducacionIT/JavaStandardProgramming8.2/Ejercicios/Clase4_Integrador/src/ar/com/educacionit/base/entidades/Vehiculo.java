package ar.com.educacionit.base.entidades;

public abstract class Vehiculo {
    
    private int alto;
    private int ancho;
    private int largo;

    public Vehiculo(int alto, int ancho, int largo) {
        this.alto = alto;
        this.ancho = ancho;
        this.largo = largo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "alto=" + alto + "cm" + ", ancho=" + ancho + "cm" + ", largo=" + largo + "cm" + '}';
    }
    

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }
            
}