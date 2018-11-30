package ar.com.eduit.curso.java.utils;

import ar.com.eduit.curso.java.interfaces.I_Archivo;

public class ArchivoTexto implements I_Archivo {

    @Override
    public void setText(String texto) {
        System.out.println("Escribiendo archivo de texto.");
    }

    @Override
    public String getText() {
        return "Archivo de Texto.";
    }
    
}
