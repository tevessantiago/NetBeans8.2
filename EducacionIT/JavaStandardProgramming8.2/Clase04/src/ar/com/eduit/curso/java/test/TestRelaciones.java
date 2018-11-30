package ar.com.eduit.curso.java.test;

import ar.com.eduit.curso.java.entities.ClienteEmpresa;
import ar.com.eduit.curso.java.entities.ClientePersona;
import ar.com.eduit.curso.java.entities.Cuenta;
import java.util.List;

public class TestRelaciones {
    public static void main(String[] args) { // psvm + tab crea el método main
        System.out.println("-- cuenta1 --");
        Cuenta cuenta1 = new Cuenta(1, "arg$");
        cuenta1.depositar(50000);
        cuenta1.depositar(20000);
        cuenta1.debitar(25000);
        System.out.println(cuenta1); //se invoca el método toString de la clase Cuenta
        
        System.out.println("-- clienteP1 --");
        ClientePersona clienteP1 = new ClientePersona(1, "Juan", "Perez", 2);
        clienteP1.getCuenta().depositar(25000);
        
        Cuenta cuentaCli = clienteP1.getCuenta();
        cuentaCli.debitar(5000);
        
        System.out.println(clienteP1);
        
        System.out.println("-- cienteE1 --");
        ClienteEmpresa clienteE1 = new ClienteEmpresa(1, "Todo Limpio srl", "Larrea 222");
        
        clienteE1.getCuentas().add(new Cuenta(10,"arg$"));
        
        List<Cuenta> cuentas = clienteE1.getCuentas(); //Para no tener que poner siempre clienteE1.getCuentas()
        cuentas.add(new Cuenta(11,"reales"));
        cuentas.add(new Cuenta(12,"U$S"));
        
        cuentas.get(0).depositar(60000); //pesos
        cuentas.get(1).depositar(40000); //reales
        cuentas.get(2).depositar(12000); //dolares
        cuentas.get(0).debitar(16000); //pesos
        
        System.out.println(clienteE1); //El estado de clienteE1 (Atributos menos la lista)
        for(int a=0;a<cuentas.size();a++) System.out.println(cuentas.get(a));
    }
}
