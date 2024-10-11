package Ejercicio2;
import static Ejercicio2.Hilo.contador;

public class Simple1{
    public static void main(String[] args) {

        Hilo[] hilos = new Hilo[5];

        for (int i = 0; i < 5; i++) {
            hilos[i] = new Hilo("Hilo " + (i+1));
            hilos[i].start();
        }
        System.out.println("Contador: " + contador);
    }
}