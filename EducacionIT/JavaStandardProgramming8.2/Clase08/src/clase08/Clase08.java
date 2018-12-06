package clase08;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Clase08 {
    public static void main(String[] args) {
        //Clase08 Manejo de Exceptions
        
        //System.out.println(10/0); //Esta linea detiene el programa. Produce una excepcion.
        //System.out.println("Esta linea no se ejecuta!"); // Esta no se ejecuta.
        
        /*
            Estructura try - catch - finally
        
            try{
                //Todas las sentencias que puedan lanzar exception.
                //Estas sentencias tienen más costo de hardware. Son más lentas de ejecutar.
            }catch (Exception e){
                //En catch controlamos el error, no detenemos el programa.
                //Estas sentencias se ejecutan en caso de existir una exception en el bloque try.
                //Se recibe como parametro un objeto de la clase Exception.
            }finally{
                //Este bloque es opcional.
                //Estas sentencias se ejecutan siempre.
                //Las variables creadas en try o catch estan fuera de alcance (out of scope).
            }
            //Estas sentencias se ejecutan siempre.
            //El programa termina normalmente.
        */
        
        /*
        try{
            System.out.println(10/0); //Lanza exception, pero no se detiene el programa, avanza a catch.
            System.out.println("Esta sentencia no se ejecuta.");
        }catch(Exception e){
            System.out.println("Ocurrio un error");
            System.out.println(e); //Se suele guardar en un log, no se suele mostrar al usuario.
        }finally{
            System.out.println("El programa termina normalmente.");
        }
        */
        
        //trycatch + tab genera automaticamente la estructura sin el finally.
        try {
            //GeneradorDeExceptions.generar();
            //GeneradorDeExceptions.generar(true);
            //GeneradorDeExceptions.generar("22x");
            //GeneradorDeExceptions.generar(null, 10);
            //GeneradorDeExceptions.generar("hola", 10);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        //Captura personalizada de Exceptions
        try {
            //GeneradorDeExceptions.generar();
            ////GeneradorDeExceptions.generar("Hola", 20);
            //GeneradorDeExceptions.generar("22x");
            //GeneradorDeExceptions.generar(null, 10);
            FileReader in = new FileReader(new File("c:/text.txt")); //Intento abrir un file que no existe. Al no haber un catch personalizado para su tipo de excepcion va a ir por el catch de Exception.
        } catch(IndexOutOfBoundsException e){ //Clase padre de todos los outofboundsexceptions. Con hacer catch de esta no es necesario aclarar string o array.
            System.out.println("Indice fuera de Rango!");
        } catch (ArithmeticException e) {
            System.out.println("División por 0!");
        } catch (NumberFormatException e){
            System.out.println("Formato de numero incorrecto!");
        } catch (NullPointerException e) {
            System.out.println("Puntero nulo!");
        } catch (Exception e){
            System.out.println("Error no esperado!");
        }
        
        //UnChecked y Checked Exceptions
        String texto = "Hola";
        System.out.println(texto.charAt(2)); //Puede lanzar una UnCheckedException. No estoy obligado a controlar la exception.
        //FileReader in = new FileReader(new File("c:/text.txt")); //Puede lanzar una CheckedException. Debe ser controlada de alguna forma.             
        
        //Exceptions para validar Reglas de negocio
        //Venta de pasajes
        System.out.println("**************************************");
        Vuelo v1 = new Vuelo("aer1111",100);
        Vuelo v2 = new Vuelo("lat1234",100);
        
        try {
            v1.venderPasajes(30); //El main tiene que tener throws de NoHayMasPasajesException, sino tira error de sintaxis.
            v2.venderPasajes(20);
            v1.venderPasajes(50);
            v2.venderPasajes(10);
            v1.venderPasajes(30); //Esta venta lanza una exception
            v2.venderPasajes(10); //Esta venta no se realiza.
            //Para continuar con el resto de las ventas lo ideal seria hacer un bloque trycatch por cada venta.
        } catch (NoHayMasPasajesException ex) { //En caso de no hacer trhows de NoHayMasPasajesException en el main, se puede añadir la clausula trycatch con el ide.
            System.out.println(ex);
        }
        
        System.out.println(v1);
        System.out.println(v2);
        
        //Interface AutoCloseable A partir de Java7
        System.out.println("**************************************");
        //sin try with resources
//        try {
//            EnlaceServidor es = new EnlaceServidor("200.32.44.55");
//      
//        try {
//            
//            es.enviar("Hola");
//            es.recibir();
//            es.close(); //Si no cierro la comunicacion va a quedar el canal abierto.
//        } catch (Exception e) {
//            System.out.println(e);
//            es.close();
//        } catch (Exception ex) {
//            System.out.println("Error de enlace");
//        }
//        }

        //con try with resources para objetos de AutoCloseable Java 7
        //Se diferencia poniendo parentesis luego del try
        //Se cierran automaticamente los enlaces.
        try(
                EnlaceServidor es1 = new EnlaceServidor("22.22.22.22");
                EnlaceServidor es2 = new EnlaceServidor("33.33.33.33");
        ){
            es1.enviar("hola");
            es2.enviar("hola");
            es1.recibir();
            es2.recibir();
        }catch(Exception e){
            System.out.println(e);
        }
        
        //Detectar control de excepciones
        //Diferenciamos excepciones tecnicas con excepciones de negocio
        System.out.println("**************************************");
        try {
            EnlaceServidor es = new EnlaceServidor("11.11.11.11");
            es.enviar("Hola");
            v1.venderPasajes(10);
            es.recibir();
            es.close();
        } catch (NoHayMasPasajesException e) {
            System.out.println(e);
        } catch (IOException e){
            System.out.println("Problemas de conexion a la red.");
        } catch (Exception e){
            e.printStackTrace(); //imprime el error en rojo.
        }
        
        
    }

}
