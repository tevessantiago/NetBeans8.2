package clase02;

import javax.swing.JOptionPane;

public class Clase02 {
    public static void main(String[] args) {
        // Clase 02 Programación Orientada a objetos
        // Representamos cosas sustantivas con las clases
        // Declaración de clase interna
        class Auto{
            // atributos
            // describen a la clase
            // son variables contenidas dentro de la clase
            String marca;
            String modelo;
            String color;
            int velocidad;
            
            // métodos constructores
            // Tiene el mismo nombre que la clase
            // No tiene devolución de valor (No se declara la devolución de valor)
            // Se ejecuta automaticamente al inicializar un objeto
            // Cuando la clase no tiene constructor, el compilador agrega un constructor vacio en tiempo de compilación.
            // Los constructores pueden sobrecargarse.
            // Te obliga a poner estado (valor de los atributos)
            
            
            /**
             * Deprecado por Carlos Ríos el 09/11/2018 por ser inseguro.
             * usar en su reemplazo Auto(String marca,String modelo,String color)
             * @deprecated
             */
            @Deprecated 
            Auto(){} //constructor vacio
            
            Auto(String marca,String modelo,String color){
                this.marca=marca;
                this.modelo=modelo;
                this.color=color;
            }
            
            // métodos
            // son acciones que hace la clase
            void acelerar(){                //acelerar
                velocidad+=10;
                if (velocidad>100) velocidad=100;
            } // incrementa la velocidad a 10km/h
            
            //sobrecarga de métodos
            void acelerar(int kilometros){      //acelerarInt
                velocidad+=kilometros;
            } // mismo nombre pero diferente entrada de parámetros. El usuario decidir cuál va a invocar.
            void frenar(){ velocidad-=10; } // disminuye la velocidad a 10km/h 
            
            void imprimirVelocidad(){   //No devuelve valor //Void es vacio, no tiene valor
                System.out.println(velocidad);
            }
            
            int getVelocidad(){     //Devuelve un valor
                //senciancias
                // ..
                // ..
                return velocidad;
                // no se ejecuta esta sentencia. Porque return finaliza el control del método.
            }
            
            @Override //Con esta anotation aviso que estoy sobreescribiendo el method.
            public String toString(){
                return marca+" "+modelo+" "+color;
            }
            
        } // end class Auto
        
        // Vamos a crear un objeto de la clase auto, fuera de la clase
        System.out.println("-- auto1 --");
        Auto auto1=new Auto(); // Se construye un espacio de memoria para guardar la variable de este tipo
        
        //Ponemos estado a auto1 (completamos el valor de los atributos)
        auto1.marca="Ford";
        auto1.modelo="Ka";
        auto1.color="Negro";
        
        auto1.acelerar();   // 10km/h
        auto1.acelerar();   // 20km/h
        auto1.acelerar();   // 30km/h
        auto1.frenar();     // 20km/h
        auto1.acelerar(23); // 43km/h
        
        System.out.println(auto1.marca+" "+auto1.modelo+" "+auto1.color+" "+auto1.velocidad);
        // Los atributos String se inicializan automaticamente en null.
        // Los autributos numericos se inicializan automaticamente en cero (0).
        
        auto1.imprimirVelocidad(); 
        System.out.println(auto1.getVelocidad());
        //JOptionPane.showMessageDialog(null, "Velocidad: "+auto1.getVelocidad());
        
        int x;
        String texto;
        //System.out.println(x); //error la variable debe ser inicializada
        //System.out.println(texto); 
        //Es distinto el comportamiento de una variable que el de un atributo.
        
        System.out.println("-- auto2 --");
        Auto auto2;
        //System.out.println(auto2);
        //Error auto2 debe ser inicializado
        
        auto2=new Auto(); //New inicializa las variables de tipo objeto
        
        auto2.marca="Fiat";
        auto2.modelo="Idea";
        auto2.color="Rojo";
        
        
        for(int a=0;a<=36;a++) auto2.acelerar();
        
        System.out.println(auto2.marca+" "+auto2.modelo+" "+auto2.color+" "+auto2.velocidad);
        
        Auto auto3=new Auto("Renault","Kangoo","Color");
        auto3.acelerar(30);
        //método toString();
        System.out.println(auto3.toString());
        System.out.println(auto3); //Automáticamente se invoca el método toString.
        
        
        //Mock (objetos de prueba)
        System.out.println("-- empleado1 --");
        Empleado empleado1=new Empleado(1, "Joaquin Medina", 34, 1500000.25f);
        //empleado1.edad=35;
        empleado1.setEdad(35); //Me permite acceder a un estado privado
        System.out.println(empleado1);
        
        /*
            Modificadores de visibilidad
        
        Modificador         Alcance
        
        default(omitido)    Es visible desde la misma clase y de clases del mismo paquete.
        
        public              Es visible desde cualquier clase de cualquier paquete. (y desde la misma clase)
        
        private             Solo es visible desde la misma clase.
        
        protected           Es visible desde la misma clase y desde clases hijas. (Es visible desde clases del mismo paquete)
        
        */
        
    } // end main
    
} // end class Clase02
