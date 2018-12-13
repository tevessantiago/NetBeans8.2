package ar.com.eduit.curso.java.utils.test;

import ar.com.eduit.curso.java.connector.Connector;
import java.sql.Connection;

public class TestConnector {
    public static void main(String[] args) throws Exception {
        Connection conn = Connector.getConnection();
        
        //conn.close();
    }
}
