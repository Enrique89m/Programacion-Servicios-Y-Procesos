package Ejercicio12;

public class DatoCompartido {
    int dato;
    boolean disponible = false;
    boolean inicializado = false;


    public synchronized void poner(int nuevoDato) {
        dato = nuevoDato;
        disponible = true;
        inicializado = true;
        notify();
    }

    public synchronized int obtener(){
        while (!disponible || !inicializado) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        disponible = false;
        return dato;
    }
}
