package Ejercicio10;

public class Decrementar extends Thread {

    private final Contador decremento;

    Decrementar(Contador decremento){
        this.decremento = decremento;
    }

    public void run(){

        synchronized (decremento){
            for (int i = 0; i < 100; i++) {
                decremento.decrementar();
                System.out.println(currentThread().getName() + " decrementa 1 (el valor de contador es: " + decremento.getValor());
            }
            System.out.println("El valor del contador es: " + decremento.getValor());
        }


    }

}
