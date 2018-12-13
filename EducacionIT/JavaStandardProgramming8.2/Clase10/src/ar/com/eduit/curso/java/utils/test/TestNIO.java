package ar.com.eduit.curso.java.utils.test;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestNIO {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("res/texto.txt");
        //Charset charset = Charset.forName("UTF-8");
        Charset charset = StandardCharsets.UTF_8; //Igual que la linea anterior pero el intellisense de la ide me ayuda a encontrar encodings correctos.
        Files.readAllLines(path, charset).forEach(System.out::println);
    }
}
