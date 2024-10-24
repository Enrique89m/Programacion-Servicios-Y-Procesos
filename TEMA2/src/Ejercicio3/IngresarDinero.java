package Ejercicio3;

public class IngresarDinero extends Thread {

    private final Cuenta cuenta;

    public IngresarDinero(Cuenta cuenta){
        this.cuenta = cuenta;
    }

    public void run(){
            synchronized (cuenta){
                for (int i = 0; i < 50; i++) {
                    cuenta.ingresarDinero(10, getName());
            }
        }
    }
}
