/*
Ejercicio #1
Construir un vector de enteros llamado vecNumeros e inicializarlo con los números 11, -22, 33, -44, 55, -66, 77, -88, 99.
Construir un vector de enteros llamados vecPositivos, de longitud 10, que contenga los números positivos de vecNumeros.
Construir un vector de enteros llamado vecNegativos, de longitud 10, que contenga los numeros negativos de vecNumeros.
Acumular la suma de los valores positivos en una variable totalPositivos.
Acumular la suma de los valores negativos en una variable totalNegativos.
Imprimir en pantalla:
-el contenido de vecNumeros
-el contenido de vecPositivos
-el contenido de vecNegativos
-los valores de totalPositivos y totalNegativos  
Imprimir la suma totalPositivos y totalNegativos, sin utilizar una variable extra para sumarizarlos.
Imprimir los valores 1000 2000 3000 pasados como argumentos del programa principal.
 */

public class Clase2 {
    
    public static void main(String[] args) {
        
        int[] vecNumeros = {11,-22,33,-44,55,-66,77,-88,99};
        int[] vecPositivos = new int[10];
        int[] vecNegativos = new int[10];
        int totalPositivos = 0, totalNegativos = 0;
        int indicePositivos = 0, indiceNegativos = 0;
        
        for(int i=0; i<vecNumeros.length; i++){
            int numero = vecNumeros[i];
            if(numero < 0){
                vecNegativos[indiceNegativos] = numero;
                totalNegativos += numero;
                indiceNegativos++;
            }
            else{
                vecPositivos[indicePositivos] = numero;
                totalPositivos += numero;
                indicePositivos++;
            }
        }
        
        System.out.print("vecNumeros: ");
        for(int i=0; i<vecNumeros.length; i++){
            System.out.print(vecNumeros[i]);
            if(i != (vecNumeros.length - 1)){System.out.print(", ");}
        }
        System.out.println("");
        
        System.out.print("vecPositivos: ");
        for(int i=0; i<indicePositivos; i++){
            System.out.print(vecPositivos[i]);
            if(i != (indicePositivos - 1)){System.out.print(", ");}
        }
        System.out.println("");
        
        System.out.print("vecNegativos: ");
        for(int i=0; i<indiceNegativos; i++){
            System.out.print(vecNegativos[i]);
            if(i != (indiceNegativos - 1)){System.out.print(", ");}
        }
        System.out.println("");
        
        
        System.out.println("totalPositivos = " + totalPositivos);
        System.out.println("totalNegativos = " + totalNegativos);
        System.out.println("totalPositovos + totalNegativos = " + (totalPositivos+totalNegativos));
        
        System.out.print("Argumentos: ");
        for(int j = 0; j < args.length; j++){
            System.out.print(args[j] + " ");
        }
        System.out.println();
    }
}
