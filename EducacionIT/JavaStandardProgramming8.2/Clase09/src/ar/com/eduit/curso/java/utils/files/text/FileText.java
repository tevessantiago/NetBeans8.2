package ar.com.eduit.curso.java.utils.files.text;

import ar.com.eduit.curso.java.utils.files.interfaces.I_File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FileText implements I_File{
    
    //Streaming es una corriente al archivo. Se abre el archivo.
    
    private File file;

    public FileText(File file) { this.file = file; }    
    public FileText(String file){ this.file = new File(file); } // Para poder poner la ruta de un archivo que no existe

    @Override
    public void print() {
        int car;
        try(FileReader in = new FileReader(file)){
            while((car=in.read())!=-1) System.out.print((char)car); //Imprime caracter por paracter. El read lo recorre.
        }catch(FileNotFoundException e) {System.out.println("El archivo " + file + " no se encontro.");
        }catch(IOException e) {System.out.println("Problemas al leer " + file);}
        System.out.println();
    }

    @Override //Lo mismo que print pero no va a imprimir, va a devolver.
    public String getText() {
        int car;
        StringBuilder sb = new StringBuilder();
        try(FileReader in = new FileReader(file)){
            while((car=in.read())!=-1) sb.append((char)(car));
        }catch(FileNotFoundException e) {System.out.println("El archivo " + file + " no se encontro.");
        }catch(IOException e) {System.out.println("Problemas al leer " + file);}
        return sb.toString();
    }

    @Override
    public void setText(String text) {
        try(FileWriter out = new FileWriter(file)){ out.write(text);
        }catch(IOException e) {System.out.println("Problemas al leer " + file);}
    }

    @Override
    public void appendText(String text) {
        try(FileWriter out = new FileWriter(file,true)){ out.write(text);
        }catch(IOException e) {System.out.println("Problemas al leer " + file);}
    }

    @Override
    public void clear() { setText(""); }

    @Override
    public void addLine(String linea) {
        //appendText(linea+"\n");
        try(BufferedWriter out = new BufferedWriter(new FileWriter(file,true))){
            out.write(linea);
            out.newLine();
        }catch (IOException e){System.out.println("Problemas al leer " + file);}
    }

    @Override
    public void addLines(Collection<String> lineas) {
        try(BufferedWriter out = new BufferedWriter(new FileWriter(file,true))){
            for(String s:lineas) out.write(s+"\n");
        }catch (IOException e){System.out.println("Problemas al leer " + file);}
    }

    @Override
    public void setLines(Collection<String> lineas) {
        try(BufferedWriter out = new BufferedWriter(new FileWriter(file))){
            for(String s:lineas) out.write(s+"\n");
        }catch (IOException e){System.out.println("Problemas al leer " + file);}
    }

    @Override
    public List<String> getLines() {
        List<String> lista = new ArrayList();
        try(BufferedReader in = new BufferedReader(new FileReader(file))){
            //readLine lee una linea completa y cuando devuelve null encuentra el fin del archivo
            //lines devuelve un objeto de streams.
            in.lines().forEach(lista::add);
        }catch(FileNotFoundException e) {System.out.println("El archivo " + file + " no se encontro.");
        }catch(IOException e) {System.out.println("Problemas al leer " + file);}
        return lista;
    }

    @Override
    public Set<String> getLinkedHashSetLines() {
        Set<String> set = new LinkedHashSet();
        set.addAll(getLines());
        return set;
    }

    @Override
    public Set<String> getTreeSetLines() {
        Set<String> set = new TreeSet();
        set.addAll(getLines());
        return set;
    }

    @Override
    public void remove(String line) { //No es performante. lee todo, borra y vuelve a escribir.
        List<String> lista = getLines();
        lista.remove(line);
        setLines(lista);
    }
    
}
