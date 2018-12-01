package laboratorio.ejercicio1.entidades;

public class Zoologico {
    
    public static final int CANTIDAD_ANIMALES = 25;
    public static final int RACIONES_POR_ANIMAL = 5;
    private boolean abierto = false; 
    
    public Zoologico(){
        
    }
    
    public void abrir(){
        this.abierto = true;
    }
    
    //deberá instanciar a un Cuidador pasándole la cantidad de raciones en el constructor del mismo
    public void alimentarAnimales(int unaCantidadDeRaciones){
        
        Cuidador cuidador = new Cuidador(unaCantidadDeRaciones);
        cuidador.alimentarAnimales();
        
    }
    
    public void getStatus(){
        if (this.abierto == true){
            System.out.println("El zoologico esta abierto");
        } else{
            System.out.println("El zoologico esta cerrado");
        }
    }
    
    public void cerrar(){
        this.abierto = false;
    }
    
    public boolean isAbierto(){
        return abierto; 
    }
}
