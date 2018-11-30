package ar.com.eduit.curso.java.interfaces;
public interface I_Archivo {
    /*
        Interfaces
        - No tienen atributos ni constructores.
        - Tiene métodos abstractos y constantes.
        - Todos los miembros (metodos o constantes declaradas) de una interface son públicos.
        - Una clase puede implementar todas las interfaces que necesite. (En la herencia no)
    
        Los métodos abstractos no tienen código en su declaración, las clases que implementan la
        interface deben (están obligadas) completar el código.
    */
    
    /**
     * La javaDoc es heredada.
     * Todas las clases que usen estan interfaz, van a ver este javaDoc.
     * @param texto 
     */
    void setText(String texto); //Es abstracto sin necesidad de poner abstract. Tampoco hace falta poner public porque todos los miembros de la interface son pubicos.
    String getText();
    
    /*
    Métodos Default JDK 8
        A partir de Java 8 existen los métodos default en Java, son métodos de interfaces
        que pueden tener código dentro de la declaración.
    */
    default void info(){
        System.out.println("Interface I_Archivo");
    }
}
