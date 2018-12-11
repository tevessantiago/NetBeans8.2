package ar.com.eduit.curso.java.utils.test;

import ar.com.eduit.curso.java.utils.files.text.FileText;
import java.util.ArrayList;
import java.util.List;

public class TestFile {
    public static void main(String[] args) {
        //String file = "e:/texto.txt"; //Este fue un archivo creado en cualquier lugar en windows.
        String file="res/texto.txt"; //Hace referencia a un archivo dentro del proyecto
        
        FileText fText = new FileText(file); //Lee el file
        
        fText.setText("Curso de Java.\n"); //Borra lo que había y escribe uno nuevo.
        
        fText.appendText("Primavera.\n");
        fText.appendText("Verano.\n");
        fText.appendText("Otoño.\n");
        fText.appendText("Invierno.\n");  
        
        fText.addLine("Lunes.");
        fText.addLine("Martes.");
        fText.addLine("Martes.");
        fText.addLine("Lunes.");
        fText.addLine("Miercoles.");
        fText.addLine("Jueves.");
        fText.addLine("Viernes.");
        
        List<String> lista = new ArrayList();
        lista.add("Rojo.");
        lista.add("Verde.");
        lista.add("Azul.");
        lista.add("Negro.");
        lista.add("Blanco.");
        lista.add("Amarillo.");
        
        //fText.setLines(lista); //Borra y agrega la lista.        
        fText.addLines(lista); //a lo que ya tiene, agrega.
        
        //fText.clear(); //Limpia el archivo
        
        
        
        //fText.print();
        //System.out.println(fText.getText());
        
        fText.remove("Jueves.");
        
        fText.getLines().forEach(System.out::println); //incluye duplicados
        //fText.getLinkedHashSetLines().forEach(System.out::println); //no tiene duplicados
        //fText.getTreeSetLines().forEach(System.out::println); //sin duplicados ordenado alfabeticamente
    }
}
