package laboratorio.ejercicio1.entidades;

public class Cuidador extends Persona {
    
    private int cantidadDeRaciones;
    
    public Cuidador(int cantidadDeRaciones){
        this.cantidadDeRaciones = cantidadDeRaciones;
    }
    
    
    /*informará si la cantidad de raciones que le entregaron al cuidador
    fue suficiente para alimentar a todos los animales*/
    //CANTIDAD_ANIMALES = 25 y RACIONES_POR_ANIMAL = 5
    
    public void alimentarAnimales(){
        int racionesNecesarias = Zoologico.CANTIDAD_ANIMALES * Zoologico.RACIONES_POR_ANIMAL;
        if(this.cantidadDeRaciones < racionesNecesarias){
            System.out.println("La cantidad de raciones no es suficiente");
        } else{
            System.out.println("Animales alimentados");
        }
    }
    
}
