package Ejercicio1;

public class Hilo extends Thread {

    public Hilo (String nombre){
        super(nombre);
    }

    public void run(){

        for (int i = 0; i < 3; i++) {
            System.out.println(getName() + " = " + i);
        }
    }
}
