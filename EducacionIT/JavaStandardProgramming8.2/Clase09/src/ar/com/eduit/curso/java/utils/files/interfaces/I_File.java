package ar.com.eduit.curso.java.utils.files.interfaces;

import java.util.*;

public interface I_File {
    
    void print();
    String getText();
    void setText(String text);
    void appendText(String text);
    void clear();
    void addLine(String line);
    void addLines(Collection<String> lineas); //Appendea lineas
    void setLines(Collection<String> lineas); //Escribe lineas
    List<String> getLines();
    Set<String> getLinkedHashSetLines();
    Set<String> getTreeSetLines(); // Devuelve lista de lineas ordenadas alfabeticamente y sin duplicados
    void remove(String line);
    
}
