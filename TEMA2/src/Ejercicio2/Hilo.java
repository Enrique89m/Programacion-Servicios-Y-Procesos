package Ejercicio2;

public class Hilo extends Thread {
    static int contador;

    public Hilo(String nombre){
        super(nombre);
    }

    public void run(){
        for (int i = 0; i < 1000; i++) {
            contador++;
        }
    }
}
