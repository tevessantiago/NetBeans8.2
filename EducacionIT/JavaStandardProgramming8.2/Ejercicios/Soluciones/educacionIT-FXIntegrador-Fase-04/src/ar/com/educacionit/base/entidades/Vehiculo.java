package ar.com.educacionit.base.entidades;
/*
 * Vehiculo.java
 *
 */

/**
 *
 * @author Sebastian S. Sanga <SebastianSanga@educacionIT.com.ar>
 */
public abstract class Vehiculo {

    /**
     * Creates a new instance of Vehiculo
     */
    public Vehiculo() {
    }

    public Vehiculo(int ancho, int largo, int altura) {
        setAncho(ancho);
        setLargo(largo);
        setAltura(altura);
    }

    public String toString() {
        return "Altura:" + altura + "cm - Ancho:" + ancho + "cm - Largo:" + largo;
    }

    // Atributos
    private int ancho;
    private int largo;
    private int altura;

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

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

}
