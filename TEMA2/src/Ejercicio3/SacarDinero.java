package Ejercicio3;

public class SacarDinero extends Thread {

    private Cuenta cuenta;

    public SacarDinero(Cuenta cuenta){
        this.cuenta = cuenta;
    }

    public void run(){
        for (int i = 0; i < cuenta.getSaldo(); i++) {
            cuenta.retirarDinero(20, getName());
        }
    }
}
