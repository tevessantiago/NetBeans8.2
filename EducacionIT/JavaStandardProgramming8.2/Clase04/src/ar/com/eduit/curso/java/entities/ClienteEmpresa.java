package ar.com.eduit.curso.java.entities;

import java.util.ArrayList;
import java.util.List; //Los vectores son dinámicos. Incluye métodos para ordenar vectores.

public class ClienteEmpresa {
    private int nro;
    private String razonSocial;
    private String direccion;
    private List<Cuenta> cuentas; // La clase(interfaz) List representa vectores. Esta línea es una lista de objetos cuenta.

    public ClienteEmpresa(int nro, String razonSocial, String direccion) {
        this.nro = nro;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.cuentas = new ArrayList();
    }

    @Override
    public String toString() {
        return "ClienteEmpresa{" + "nro=" + nro + ", razonSocial=" + razonSocial + ", direccion=" + direccion + '}';
    }

    public int getNro() {
        return nro;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }
    
       
    
}
