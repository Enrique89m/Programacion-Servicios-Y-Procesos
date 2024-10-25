package Ejercicio10;

public class Incrementar extends Thread {

    private final Contador incremento;

    Incrementar(Contador incremento){
        this.incremento = incremento;
    }

    public void run(){

        synchronized (incremento){
            for (int i = 0; i < 100; i++) {
                incremento.incrementar();
                System.out.println(currentThread().getName() + " incrementa 1 (el valor de contador es: " + incremento.getValor());
            }
            System.out.println("El valor del contador es: " + incremento.getValor());
        }



    }
}
