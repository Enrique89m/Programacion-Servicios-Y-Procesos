package Ejercicio12bis;

public class Consumidor extends Thread{
    DatoCompartido datoCompartido;

    public Consumidor(DatoCompartido datoCompartido) {
        this.datoCompartido = datoCompartido;
    }

    public void run(){
        for (int i = 1; i < 10; i++) {
            int dato = datoCompartido.obtener();
            System.out.println("Obtener (" + dato + ")");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
