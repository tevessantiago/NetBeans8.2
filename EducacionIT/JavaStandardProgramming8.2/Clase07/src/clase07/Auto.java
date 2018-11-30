package clase07;

import java.util.Objects;

public class Auto implements Comparable<Auto> {
   private String marca;
   private String modelo;
   private String color;

    public Auto(String marca, String modelo, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Auto{" + "marca=" + marca + ", modelo=" + modelo + ", color=" + color + '}';
    }

    @Override public int hashCode() { return toString().hashCode(); }
    @Override public boolean equals(Object obj) {
       if(!(obj instanceof Auto)) return false;
       return this.hashCode()==obj.hashCode();
    }
    public String compareString(){
        return (color+","+marca+","+modelo).toLowerCase();
    }
    @Override public int compareTo(Auto auto) {
        return compareString().compareTo(auto.compareString());
    }
   
}