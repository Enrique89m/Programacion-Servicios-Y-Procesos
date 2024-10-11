package Ejercicio4;

public class Corredor extends Thread{
    private static int pos = 0;

    public void run(){
        int metros = 0;

        for (int i = 0; i < 1500; i++) {
            metros++;
            try {
                sleep((long)(Math.random()*3));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        pos++;
        System.out.println("El corredor " + getName() + " ha terminado -> "+pos);
    }
}
