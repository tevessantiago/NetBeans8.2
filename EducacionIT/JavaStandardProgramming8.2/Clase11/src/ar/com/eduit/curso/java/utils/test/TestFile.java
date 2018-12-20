package ar.com.eduit.curso.java.utils.test;
import ar.com.eduit.curso.java.utils.files.text.FileText;
import java.util.ArrayList;
import java.util.List;
public class TestFile {
    public static void main(String[] args) {
        //String file="e:/texto.txt";
        String file="res/texto.txt";
        FileText fText=new FileText(file);
        fText.setText("Curso de Java.\n");
        fText.appendText("Primavera.\n");
        fText.appendText("Verano.\n");
        fText.appendText("Otoño.\n");
        fText.appendText("Invierno.\n");
        fText.addLine("Lunes.");
        fText.addLine("Martes.");
        fText.addLine("Martes.");
        fText.addLine("Lunes.");
        fText.addLine("Miércoles.");
        fText.addLine("Jueves.");
        fText.addLine("Viernes.");
        
        List<String>lista=new ArrayList();
        lista.add("Rojo.");
        lista.add("Verde.");
        lista.add("Azul.");
        lista.add("Negro.");
        lista.add("Blanco.");
        lista.add("Amarillo.");
        
        //fText.setLines(lista);
        fText.addLines(lista);
        
        
        //fText.clear();
        
        //fText.print();
        //System.out.println(fText.getText());
        
        fText.remove("Jueves.");
        
        fText.getLines().forEach(System.out::println);
        //fText.getLinkedHashSetLines().forEach(System.out::println);
        //fText.getTreeSetLines().forEach(System.out::println);
        
    }
}
