package clase08;
/**
 * A veces hay clases que provocan excepciones y no podemos controlarlas o no tenemos acceso.
 * @author Santiago Teves
 */
public class GeneradorDeExceptions {
    public static void generar(){
        int[] vector = new int [10];
        vector[20] = 100;
    }
    public static void generar(boolean x){
        if(x) System.out.println(10/0);
    }
    public static void generar(String nro){
        int n = Integer.parseInt(nro);
    }
    public static void generar(String texto, int pos){
        //if(texto == null || pos>=texto.length()) return; //Usualmente así se evitan estas excepciones.
        System.out.println(texto.charAt(pos));
    }
}
