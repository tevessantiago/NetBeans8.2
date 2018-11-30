package clase07;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class Clase07 {
    public static void main(String[] args) {
        // Clase 07 Colecciones
        
        Auto[] autos=new Auto[4];
        autos[0]=new Auto("Fiat","Palio","Negro");
        autos[1]=new Auto("Ford","Fiesta","Rojo");
        autos[2]=new Auto("Renault","Kangoo","Azul");
        autos[3]=new Auto("Citroen","C4","Blanco");
                
        //Recorrido con indices
        //for(int a=0;a<autos.length;a++) System.out.println(autos[a]);
        
        //Recorrido forEach
        for(Auto auto:autos) System.out.println(auto);
        
        //Interface List
        List lista=new ArrayList();
        lista.add(new Auto("Ford","Fiesta","Rojo"));
        lista.add(new Auto("VW","Gol","Gris"));
        lista.add("Hola");
        lista.add(23);
        lista.remove(2);
        
        System.out.println("*************************************************");
        //Recorrido con indices
        //for(int a=0;a<lista.size();a++) System.out.println(lista.get(a));
        
        //Recorrido con forEach
        //for(Object obj:lista) System.out.println(obj);
        
        //Recorrido con Iterable Java 8 o superior
        //lista.forEach(item->System.out.println(item));
        //lista.forEach(item->{
        //    System.out.println(item);
        //});
        lista.forEach(System.out::println);
        
        
        //Uso de Generics a partir de JDK
        //List<Auto>lista2=new ArrayList();
        List<Auto>lista2=new LinkedList();
        lista2.add(new Auto("Peugeot","208","Negro"));
        lista2.add(new Auto("Ford","Ka","Verde"));
        
        Auto auto1=(Auto)lista.get(0);
        Auto auto2=lista2.get(0);
        
        //copiar todos los autos del vector autos a lista2
        for(Auto auto:autos) lista2.add(auto);
        
        //copiar los autos de lista a lista2
        lista.forEach(item->{
            if(item instanceof Auto) lista2.add((Auto)item);
        });
        
        System.out.println("*************************************************");
        lista2.forEach(System.out::println);
        System.out.println("Longitud de lista2="+lista2.size());
        
        //Interface SET (Da una lista sin indices y sin valores duplicados)
        Set<String>setSemana;
        
        //Implementación HashSet: Es la más veloz, no garantiza el orden de los elementos
        setSemana=new HashSet();
        setSemana.add("Lunes");
        setSemana.add("Martes");
        setSemana.add("Miércoles");
        setSemana.add("Jueves");
        setSemana.add("Lunes");
        setSemana.add("Viernes");
        setSemana.add("Martes");
        System.out.println("*************************************************");
        setSemana.forEach(System.out::println);
        
        //Implementación LinkedHashSet: Almacena todos los elementos en una lista enlazada
        //por orden de ingreso.
        setSemana=new LinkedHashSet();
        setSemana.add("Lunes");
        setSemana.add("Martes");
        setSemana.add("Miércoles");
        setSemana.add("Jueves");
        setSemana.add("Lunes");
        setSemana.add("Viernes");
        setSemana.add("Martes");
        System.out.println("*************************************************");
        setSemana.forEach(System.out::println);
        
        //Implementación TreeSet: Alamacena los elementos en un arbol por orden natural
        setSemana=new TreeSet();
        setSemana.add("Lunes");
        setSemana.add("Martes");
        setSemana.add("Miércoles");
        setSemana.add("Jueves");
        setSemana.add("Lunes");
        setSemana.add("Viernes");
        setSemana.add("Martes");
        setSemana.add("Domingo");
        setSemana.add("Sábado");
        System.out.println("*************************************************");
        setSemana.forEach(System.out::println);
        
        //Set<Auto>setAutos=new LinkedHashSet();
        Set<Auto>setAutos=new TreeSet();
        setAutos.addAll(lista2);
        setAutos.add(new Auto("VW","Gol","Gris"));
        
        setAutos.forEach(item->System.out.println(item+"\t"+item.hashCode()));
        //setAutos.forEach(System.out::println);
        
        
        //Pilas y Colas
        
        //Clase Stack (Pila) LIFO Last In First Out
        Stack<Auto> pilaAutos=new Stack();
        pilaAutos.addAll(lista2);
        pilaAutos.push(new Auto("Toyota","Corolla","Blanco"));
        //.push() apilar un elemento en la pila
        System.out.println("*************************************************");
        pilaAutos.forEach(System.out::println);
        System.out.println("Longitud pilaAutos:"+pilaAutos.size());
        while(!pilaAutos.isEmpty()){
            System.out.println(pilaAutos.pop());
            //método .pop() desapila un elemento
        }
        System.out.println("Longitud pilaAutos:"+pilaAutos.size());
        
        //Clase ArrayDeque (Cola)  FIFO First In First Out
        ArrayDeque<Auto> colaAutos=new ArrayDeque();
        colaAutos.addAll(lista2);
        colaAutos.offer(new Auto("Honda","Civic","Rojo"));
        // método offer() encola un elemento
        
        System.out.println("*************************************************");
        colaAutos.forEach(System.out::println);
        System.out.println("Longitud de Cola:"+colaAutos.size());
        while(!colaAutos.isEmpty()){
            System.out.println(colaAutos.poll());
            // .poll() Desencola un elemento
        }        
        System.out.println("Longitud de Cola:"+colaAutos.size());
        
        //Mapas Interface Map
        //Representa un vector asociativo.
        Map<String,String> mapaSemana;
        
        //Implementación HashMap: Es la más veloz, no garantiza el orden de los elementos.
        mapaSemana=new HashMap();
        mapaSemana.put("lu", "lunes");
        mapaSemana.put("ma", "martes");
        mapaSemana.put("mi", "miércoles");
        mapaSemana.put("ju", "jueves");
        mapaSemana.put("vi", "viernes");
        System.out.println("*************************************************");
        mapaSemana.forEach((k,v)->System.out.println(k+", "+v));
        
        //Implementación LinkedHashMap: Almacena los elementos en una lista enlazada
        //  por orden de ingreso.
        mapaSemana=new LinkedHashMap();
        mapaSemana.put("lu", "lunes");
        mapaSemana.put("ma", "martes");
        mapaSemana.put("mi", "miércoles");
        mapaSemana.put("ju", "jueves");
        mapaSemana.put("vi", "viernes");
        System.out.println("*************************************************");
        mapaSemana.forEach((k,v)->System.out.println(k+", "+v));
        
        //Implementacion TreeMap: Almacena los elementos por orden natural en un arbol
        mapaSemana=new TreeMap();
        mapaSemana.put("lu", "lunes");
        mapaSemana.put("ma", "martes");
        mapaSemana.put("mi", "miércoles");
        mapaSemana.put("ju", "jueves");
        mapaSemana.put("vi", "viernes");
        System.out.println("*************************************************");
        mapaSemana.forEach((k,v)->System.out.println(k+", "+v));
        
        System.out.println("*************************************************");
        System.getProperties().forEach((k,v)->System.out.println(k+": "+v));
        System.out.println("*************************************************");
        System.out.println(System.getProperties().get("java.vm.version"));
        System.out.println("*************************************************");
        System.getenv().forEach((k,v)->System.out.println(k+": "+v));
        System.out.println("*************************************************");
        System.out.println(System.getenv().get("NUMBER_OF_PROCESSORS"));
        
        //Para SQL Alumni material clase 11
        //Ansi SQL wikipedia
        //instalar paquete xampp    apachefriends.org
        //instalar mysql workbench  mysql.com
        
        //mysqlya.com.ar
        
        
        
        
    }
    
}
