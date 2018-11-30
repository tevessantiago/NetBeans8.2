package clase06;

public class Clase06 {
    public static void main(String[] args) {
        //Clase06
        //Todas las clases heredan de la clase Object
        
        //Clase interna
        class Test{
            
        }
        
        class Test2 extends Test{
            int dato;

            public Test2(int dato) {
                this.dato = dato;
            }

            @Override
            public String toString() {
                return "Test2{" + "dato=" + dato + '}';
            }

            /*@Override
            public int hashCode() {
                int hash = 3;
                hash = 41 * hash + this.dato;
                return hash;
            } //Genera el mismo hash en base al estado del atributo. Generado automaticamente con netbeas.*/
            
            @Override
            public int hashCode() {
                return toString().hashCode(); //tostring ya crea un hashcode en base al estado de los atributos
            } 

            /*@Override
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null) {
                    return false;
                }
                if (getClass() != obj.getClass()) {
                    return false;
                }
                final Test2 other = (Test2) obj;
                if (this.dato != other.dato) {
                    return false;
                }
                return true;
            } //Generado automaticamente con netbeans*/
            @Override
            public boolean equals(Object obj) {
                if(!(obj instanceof Test2)) return false;
                return this.toString().equals(obj.toString());
            } 
            
            
            
        }//end class Test2
        
        Test2 t1 = new Test2(2);
        
        System.out.println(t1.getClass()); //Se pide cual es su objeto de clase, cual es su clase.
        //class clase06.Clase06$1Test2 -> Test2 como clase interna de Clase06
        System.out.println(t1.getClass().getName()); //Se pide el nombre de la clase. Sin la palabra class.
        System.out.println(t1.getClass().getSimpleName()); //Se pide únicamente el nombre la clase del objeto sin la ruta para llegar a ella.
        System.out.println(t1.getClass().getSuperclass().getName()); //Se pide la clase padre del objeto. Devuelve Test.
        System.out.println(t1.getClass().getSuperclass().getSuperclass().getName()); //Se pide el nombre de la clase padre de Test. Hereda de object.
        System.out.println(t1.getClass().getSuperclass().getSuperclass().getSuperclass()); //Object no tiene clase padre.
        
        String st = "Hola";
        System.out.println(st.getClass().getName());
        System.out.println(st.getClass().getSuperclass().getName()); // Devuelve Object, String no tiene clase padre.
        
        Test2 x1 = new Test2(2); //Nuevo espacio en memoria
        Test2 x2 = x1; // Mismo espacio en memoria que x1
        Test2 x3 = new Test2(2); //Nuevo espacio en memoria
        Test2 x4 = new Test2(3); //Nuevo espacio en memoria
        String x5 = "2";
        
        //método .hashCode() 
        // heredado de object
        //Cuando dos objetos tienen el mismo hash, son el mismo objeto.
        System.out.println("x1.hashCode()= " + x1.hashCode());
        System.out.println("x2.hashCode()= " + x2.hashCode());
        System.out.println("x3.hashCode()= " + x3.hashCode());
        System.out.println("x4.hashCode()= " + x4.hashCode());
        System.out.println("x5.hashCode()= " + x5.hashCode()); //String tiene el metodo hashcode redefinido. 50 es el numero 2 en la tabla ascii.
        
        //método .equals()
        //Heredado de object
        //compara objetos. compara los hashcodes.
        System.out.println("x1.equals(x1)= " + x1.equals(x1));
        System.out.println("x1.equals(x2)= " + x1.equals(x2));
        System.out.println("x1.equals(x3)= " + x1.equals(x3));
        System.out.println("x1.equals(x4)= " + x1.equals(x4));
        System.out.println("x1.equals(x5)= " + x1.equals(x5));
        
        //Quiero que dos objetos con el mismo estado sean considerados el mismo objeto. Que al compararlos devuelva true.
        //Se redefinieron hashcode y equals en la clase Test2.
        
        //Clase String
        //Almacena en un vector de caracteres (hasta java 9, a partir de java 10 se almacena en un vector de bytes)
        String texto1 = "Esto es una cadena de caracteres.";
        String texto2 = new String("Hola");
        char[] vector = {'h','o','l','a'};
        String texto3 = new String(vector);
        
        //.charAt() devuelve el caracter en el indice indicado
        System.out.println(texto1.charAt(10));
        
        //.trim() corta los espacios que están delante y detrás del string
        System.out.println(" hola hola  ".trim());
        
        //.contains() devuelve un booleano avisando si existe el string dado
        System.out.println(texto1.contains("una"));
        System.out.println(texto1.contains("hola"));
        
        //.startsWith() .endsWith() devuelve un booleano avisano si empieza o termina como el string dado
        System.out.println(texto1.startsWith("Esto"));
        System.out.println(texto1.startsWith("Hola"));
        System.out.println(texto1.endsWith("res."));
        System.out.println(texto1.endsWith("chau"));
        
        //.subString devuelve los caracteres del string dentro del rango indicado
        System.out.println(texto1.substring(10));
        System.out.println(texto1.substring(10, 20));
        
        //.length() devuelve la longitud del vector de caracteres
        System.out.println(texto1.length());
        
        //.equals() .equalsIgnoreCase()
        System.out.println(texto2.equals("hola"));
        System.out.println(texto2.equalsIgnoreCase("HOLA"));
        
        //.toUppercase() .tolowerCase()
        System.out.println(texto1.toLowerCase());
        System.out.println(texto1.toUpperCase());
        
        //.split() se le pasa un caracter, en este caso vacio. Y genera un vector separado por ese caracter indicado.
        String[] palabras = texto1.split(" ");
        for(int a=0; a<palabras.length; a++) System.out.println(palabras[a]);
        
        //StringBuilder StringBuffer
        String x = "";
        System.out.println(x + "\t" + x.hashCode());
        x+="h";
        System.out.println(x + "\t" + x.hashCode());
        x+="o";
        System.out.println(x + "\t" + x.hashCode());
        x+="l";
        System.out.println(x + "\t" + x.hashCode());
        x+="a";
        System.out.println(x + "\t" + x.hashCode());
        //Cambia el hashcode debido a que java crea un nuevo objeto cada vez que se agrega una letra.
        
        //StringBuffer sb = new StringBuffer();
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.toString() + "\t" + sb.hashCode());
        sb.append("h");
        System.out.println(sb.toString() + "\t" + sb.hashCode());
        sb.append("o");
        System.out.println(sb.toString() + "\t" + sb.hashCode());
        sb.append("l");
        System.out.println(sb.toString() + "\t" + sb.hashCode());
        sb.append("a");
        System.out.println(sb.toString() + "\t" + sb.hashCode());
        //Mismo hashcode ya que trabaja sobre el mismo objeto.
        
        x = "";
        /*System.out.println("Memoria: " + Runtime.getRuntime().totalMemory());
        long memoria = Runtime.getRuntime().totalMemory();
        for(int a=0; a<=200000; a++) x+="x"; //tarda mucho en ejecutar.
        System.out.println("Memoria: " + Runtime.getRuntime().totalMemory());
        System.out.println("Total Memoria: " + (memoria - Runtime.getRuntime().totalMemory()));*/
        //Quiso demostrar que antes de hacer el for había más memoria libre que después de hacerlo.
        
        System.out.println("Memoria: " + Runtime.getRuntime().totalMemory());
        long memoria = Runtime.getRuntime().totalMemory();
        memoria = Runtime.getRuntime().totalMemory();
        StringBuilder r = new StringBuilder();
        for(int a=0; a<=200000; a++) r.append("x"); //No tarda nada.
        System.out.println("Total Memoria: " + (memoria-Runtime.getRuntime().totalMemory()));
        
        //System.out.println(10/0); devuelve 1 como codigo de error.
        
        //Clase System
        
        //metodo .exit(); cierra el programa
        //System.exit(0); //0 es la devolucion de error. 0 no hubo errores. 1 hubo errores. -1 hubo un warning.
        //System.out.println("Esta linea no se ejecuta.");
        
        //Atributo out: representa un stream de salida sincronizado a consola.
        //Atributo err: representa un stream de salida no sincronizado a consola.
        //Atributo in: representa un stream de entrada sincronizado a consola.
        
        /*
        for(int a=0; a<=1000; a++){
            System.out.println("Hola " + a);
        }
        System.err.println("Ocurrio un error."); //Se puede imprimir antes que termine el for */
        
        //.getProperties() mapa de propiedades del sistema
        System.out.println(System.getProperties());
        
        String[] propiedades = System.getProperties().toString().split(",");
        for(int a = 0; a<propiedades.length; a++){
            System.out.println(propiedades[a]);
        }
        
        //.property()
        System.out.println("----------------------------------------------");
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("os.arch"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("java.version"));
        
        //.getenv() otro diccionario de propiedades
        System.out.println(System.getenv());
        String[] propiedades2 = System.getenv().toString().split(",");
        for(int a = 0; a<propiedades2.length; a++) System.out.println(propiedades2[a]);
        
        System.out.println("----------------------------------------------");
        
        //.getenv(""); get propiedad especifica de getenv
        System.out.println(System.getenv("NUMBER_OF_PROCESSORS"));
        System.out.println(System.getenv("PROCESSOR_IDENTIFIER"));
        System.out.println(System.getenv("OneDrive"));
        
        
        
        
    } //end main
    
}//end class Clase06
