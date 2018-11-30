package ar.com.eduit.curso.java.test;

/*import ar.com.eduit.curso.java.entities.Direccion;
import ar.com.eduit.curso.java.entities.Empleado;
import ar.com.eduit.curso.java.entities.Persona;*/
import ar.com.eduit.curso.java.entities.*;
import ar.com.eduit.curso.java.interfaces.I_Archivo;
import ar.com.eduit.curso.java.utils.ArchivoBinario;
import ar.com.eduit.curso.java.utils.ArchivoTexto;
import java.util.Scanner;

public class TestHerencia {
    public static void main(String[] args) throws Exception { //se agrega el throws para evitar la excepcion de la linea 84. Se verá en la clase 8 excepciones.
        System.out.println("-- dir1 --");
        Direccion dir1 = new Direccion("Lavalle",648,"8","a","CABA");
        System.out.println(dir1);
        
        System.out.println("-- dir2 --");
        Direccion dir2 = new Direccion("Lima",222,"1","b","CABA");
        System.out.println(dir2);
        
        /*System.out.println("-- persona1 --");
        Persona persona1 = new Persona("Ana", "Benitez", 30, dir1);
        System.out.println(persona1);
        persona1.saludar();
        
        System.out.println("-- persona2 --");
        Persona persona2 = new Persona("Diego", "Loza", 22, new Direccion("Maipu",222,"1","c","CABA"));
        System.out.println(persona2);
        persona2.saludar();
        
        System.out.println("-- persona3 --");
        Persona persona3 = new Persona("Jose", "Torres", 33, persona1.getDireccion());
        System.out.println(persona3);
        persona3.saludar(); */
        
        System.out.println("-- empleado1 --");
        Empleado empleado1 = new Empleado(1, 60000, "Javier", "Alvarez", 40, dir2);
        System.out.println(empleado1);
        empleado1.saludar();
        
        System.out.println("-- cliente1 --");
        Cliente cliente1 = new Cliente(1, new Cuenta(1, "arg$"), "Cristina", "Molina", 35, dir1); //Me dice que el new cuenta es porque no creamos ninguna cuenta anteriormente.
        System.out.println(cliente1);
        cliente1.saludar();
        
        //Polimorfismo
        Persona p1 = new Empleado(2, 3000, "Matias", "Juarez", 33, dir1); 
        Persona p2 = new Cliente(2, new Cuenta(2,"arg$"), "Veronica", "Mazza", 28, dir2);
        p1.saludar();
        p2.saludar();
        
        //En java todas las clases extienden de Object. Cuando no hay una herencia.
        //Object es un contenedor global. Significa que puede contener cualquier objeto existente en java.
        Object obj1 = new Empleado(3, 40000, "Claudia", "Russo", 34, dir2);
        Object obj2 = "Hola";
        
        //Java lo ve como una persona (a p1), hay que castearlo a empleado con el riesgo de que no lo sea.
        //Casteo: Hay que indicar el contenedor.
        Empleado e2 = (Empleado)p1;
        Empleado e3 = (p1 instanceof Empleado) ? (Empleado)p1 : null; //Si p1 es instancia de Empleado se instancia p1 sino devuelve null.
        
        //Quiero que p2 sea un cliente y depositarle. Si no lo casteo no puedo ver el metodo getCuenta()
        ((Cliente)p2).getCuenta().depositar(30000);
        
        
        
        //Polimorfismo con interfaces
        //I_Archivo archivo;
        I_Archivo archivo = null;
        
        //archivo = new I_Archivo(); No se puede, tengo que construir con una clase que implemente la interface.
        //archivo = new ArchivoTexto();
        //archivo = new ArchivoBinario();
        
        System.out.println("Ingrese 'ArchivoTexto' o 'ArchivoBinario'");
        String entrada = new Scanner(System.in).nextLine();
        
        //Inicializo archivo en base a lo que se ingresa en consola
        /*if(entrada.equalsIgnoreCase("ArchivoTexto")) archivo = new ArchivoTexto();
        if(entrada.equalsIgnoreCase("ArchivoBinario")) archivo = new ArchivoBinario();*/
        
        //Se evita el if instanciando con lo que elige el usuario de una lista de clases.
        archivo = (I_Archivo)Class.forName("ar.com.eduit.curso.java.utils." + entrada).newInstance(); //Me crea un objeto de esa clase que se ingresa, con newInstance. Se castea a archivo porque newInstance devuelve del contenedor Object.
        
        archivo.setText("Texto"); //Texto a escribir dentro del archivo
        System.out.println(archivo.getText());
        archivo.info();        
        
        /*
        Miembros estaticos (static): son miembros que pertenecen a la clase y no a los objetos.
        En el caso de los atributos estaticos, su valor es compartido por todos los objetos.
        En los métodos su comportamiento actúa sobre todos los objetos.
        Puedo usar cualquier miembro estatico sin tener que crear un objeto de la clase.
        */
        
    }
}
