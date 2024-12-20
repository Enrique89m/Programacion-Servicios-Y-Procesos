package Ejercicio3;

public class SacarDinero extends Thread {

    private final Cuenta cuenta;

    public SacarDinero(Cuenta cuenta){
        this.cuenta = cuenta;
    }

    public void run(){
            synchronized (cuenta){
                for (int i = 0; i < 50; i++) {
                    cuenta.retirarDinero(20, getName());
            }
        }
    }
}
