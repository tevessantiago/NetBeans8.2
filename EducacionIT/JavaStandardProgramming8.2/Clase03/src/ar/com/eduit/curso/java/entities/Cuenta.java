package ar.com.eduit.curso.java.entities;
public class Cuenta {
    private int nro;
    private String moneda;
    private float saldo;

    public Cuenta(int nro, String moneda) {
        this.nro = nro;
        this.moneda = moneda;
        this.saldo = 0;
    }

    Cuenta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Cuenta{" + "nro=" + nro + ", moneda=" + moneda + ", saldo=" + saldo + '}';
    }
    
    public void depositar(float monto){
        saldo += monto;
    }
    
    public void debitar(float monto){
        if(monto<=saldo){
            saldo -= monto;
        }
    }
    
}
