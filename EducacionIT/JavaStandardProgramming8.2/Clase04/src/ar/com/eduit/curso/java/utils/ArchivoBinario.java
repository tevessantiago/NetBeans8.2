package ar.com.eduit.curso.java.utils;

import ar.com.eduit.curso.java.interfaces.I_Archivo;

public class ArchivoBinario implements I_Archivo {

    @Override
    public void setText(String texto) {
        System.out.println("Escribiendo Archivo Binario.");
    }

    @Override
    public String getText() {
        return "Archivo Binario.";
    }    
}
