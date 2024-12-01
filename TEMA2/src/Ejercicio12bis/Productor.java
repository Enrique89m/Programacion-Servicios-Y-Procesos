package Ejercicio12bis;

public class Productor extends Thread{

    DatoCompartido datoCompartido;

    public Productor(DatoCompartido datoCompartido) {
        this.datoCompartido = datoCompartido;
    }

    public void run(){
        for (int i = 1; i < 10; i++) {
            int random = (int)(Math.random()*100)+1;
            datoCompartido.poner(random);
            System.out.println("Poner (" + random + ")");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
