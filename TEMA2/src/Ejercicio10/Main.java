package Ejercicio10;

public class Main {
    public static void main(String[] args) {

        Contador contador = new Contador(100);

        Incrementar hilo1 = new Incrementar(contador);
        hilo1.setName("hilo1");
        Decrementar hilo2 = new Decrementar(contador);
        hilo2.setName("hilo2");

        hilo1.start();
        hilo2.start();
    }
}
