package clase01;

import javax.swing.JOptionPane;

/**
 * Clase principal del proyecto Clase01 del curso Java Standard.
 * @author Santiago Teves
 */
public class Clase01 {
    /**
     * Punto de entrada del proyecto Clase01.
     * @param args parametros que ingresan desde consola.
     */
    public static void main(String[] args) {
        
        /*
        Curso: Java Standard Programming 8.X
        Días: Miércoles y Viernes 10:00 a 13:00 hs
        Profe: Carlos Ríos  carlos.rios@hotmail.com
        Materiales educativos: alumni.educacionit.com
        user: email     pass: dni
        Material Extra: youtube 'curso de java' 'pildoras informativas'
        Software: JDK 8.X y NetBeans IDE 8.X (Es el IDE que más ayuda brinda)
        JDK: Java Development Kit (Kit de desarrollo Java)(lee el archivo de codigo java y lo ejecuta en binario)
        www.oracle.com
        
        Java es verdaderamente multiplataforma, se desarrolla un .jar y se ejecuta en cualquier SO.
        
        JDK Alternativo: openJDK
        
        Cronograma de Versiones de Java
        LTS Long Time Support (8 años) (Non LTS dura 6meses)
        
        Version         Fecha Liberacion        Fecha Fin de Soporte
        8 LTS           Marzo 2014              Marzo 2022
        9               Septiembre 2017         Marzo 2018
        10              Marzo 2018              Septiembre 2018
        11 LTS          Septiembre 2018         Septiembre 2024
        12              Marzo 2019              Septiembre 2019
        13              Septiembre 2019         Marzo 2020
        14 LTS          Marzo 2020              Marzo 2028
        
        IDE: Integrated Development Enviroment        
        IDEs Alternativos:  Eclipse, IntelliJ, JDeveloper
        */
        
        // Comentarios de una sola linea.
        /* Bloque de comentarios.*/
        /**
         * Comentario Java DOC
         * Se coloca antes de la declaración de clases o de métodos.
         */
        
        // sout TAB atajo de teclado System.out.Println("");
        System.out.println("Hola Mundo!");
        
        //Tipo de datos primitivos
        
        //Tipo de datos boolean      1 byte
        boolean bo=true;
        System.out.println(bo);
        bo=false;
        System.out.println(bo);
        
        //Tipo de datos byte signed  1 byte
        byte by=100;
        System.out.println(by);
        
        /*
            byte by; (signed)
        
            |----|----|
          -128   0    127
        
            bytuU by; (unsigned) NO EXISTE EN JAVA
            |--------|
            0       255
        */
        
        //Tipo de datos short       2 bytes
        short sh=3000;
        System.out.println(sh);
        
        //Tipo de datos int         4 bytes
        int in=40000;
        System.out.println(in);
        
        //Tipo de datos long        8 bytes
        long lo=500000000L;
        System.out.println(lo);
        
        //Tipo de dato char (unicode) 2 bytes unsigned
        char ch=65;
        System.out.println(ch);
        ch+=32;
        System.out.println(ch);
        
        //Tipo de datos float 32 bits
        float fl=9.25f;
        System.out.println(fl);
        
        //Tipo de datos double 64 bits
        double dl=9.25;
        System.out.println(dl);
        
        fl=10;
        dl=10;
        
        System.out.println(fl/3); // Permite expresar un total de 8 digitos. El ultimo es impreciso.
        System.out.println(dl/3); // Permite expresar un total de 17 digitos. El ultimo es impreciso.
        
        fl=100;
        dl=100;
        
        System.out.println(fl/3);
        System.out.println(dl/3);
        
       /*BigDecimal
       (No es primitivo, es una clase. Permite trabajar con decimales de mayor precision que un double. Trabaja de forma decimal y no binario por lo que es precisa.)*/
       
       //Clase String
       String texto="Hola esto es una cadena de caracteres.";
       System.out.println(texto);
       String texto2="Hola"; // Ocupa 8 bytes ya que cada char ocupa 2 bytes
       
       //Hasta JDK 9 String almacena en un vector de caracteres.
       //       texto2 Ocupa 8 bytes.
       // Desde JDK 10 String almacena en un vector de bytes
       //       texto2 ocupa 4 bytes.
       
       /*
            tipo de datos var (a partir de JDK 9/10)
            var var1 = 26;  //int
            var1 = "Hola";  //error tipo de dato incorrecto.
            var var2=2000L; //Long
            var var3=9.55;  //double
            var var4=9.55f; //float
            var var5='g';   //char
            var var6=true   //boolean
            var var7="hola" //String
       */
       
       Object obj=26; // Contenedor global, el usuario puede guardar lo que quiera.
       obj="Hola"; // Es válido, a diferencia del var.
       
        System.out.println(texto);
        //Recorrer texto como un vector. (caracter por caracter)
        for(int a=0;a<texto.length();a++){
            System.out.print(texto.charAt(a));
        }
        System.out.println();
        
        //Imprimir texto todo en mayusculas
        for(int a=0;a<texto.length();a++){
            char car=texto.charAt(a);
            if(car>=97 && car<=122) car-=32; //Si está en el rango de valores minusculas, lo transforma en mayuscula. Tabla ascii.
            System.out.print(car);
        }
        System.out.println();
        
        //Operador Ternario
        char car;
        for(int a=0;a<texto.length();a++){
            car=texto.charAt(a);
            System.out.print((car>=97 && car<=122)?car-=32:car);
        }
        System.out.println();
        System.out.println(texto.toUpperCase());
        System.out.println(texto.toLowerCase());
        
        JOptionPane.showMessageDialog(null, "Curso de Java."); //Clase que permite mostrar un cuadro de dialogo. No esta dentro del paquete Java Lang. Hay que importarla.
        
    } // end main
} // end Clase01
