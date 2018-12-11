package clase08;

import java.io.IOException;

public class EnlaceServidor implements AutoCloseable{
    private String ip;

    public EnlaceServidor(String ip) throws IOException{
        this.ip = ip;
    }
    
    public void enviar(String mensaje) throws IOException{ //IO es entrada-salida
        System.out.println("Enviando mensaje.");
    }
    
    public void recibir() throws IOException{
        System.out.println("Recibiendo mensaje.");
    }
    
    public void close() throws IOException{
        System.out.println("Conexión cerrada.");
    }
}
