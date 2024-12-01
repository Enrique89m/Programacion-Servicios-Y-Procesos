package Ejercicio12;

public class Productor extends Thread{

    DatoCompartido datoCompartido;

    public Productor(DatoCompartido datoCompartido) {
        this.datoCompartido = datoCompartido;
    }

    public void run(){
        for (int i = 1; i < 10; i++) {
            datoCompartido.poner(i);
            System.out.println("Poner (" + i + ")");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
