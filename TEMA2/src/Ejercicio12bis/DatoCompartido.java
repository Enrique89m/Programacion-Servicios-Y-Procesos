package Ejercicio12bis;

import java.util.ArrayList;

public class DatoCompartido {
    boolean disponible = false;
    ArrayList datos = new ArrayList<Integer>(10);

    public synchronized int obtener(){
        if (datos.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        int datoObtenido = (int)datos.get(0);
        datos.remove(0);
        notify();
        return datoObtenido;
    }

    public synchronized void poner(int nuevoDato) {
        /*if (datos.size() == 5 ){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }*/
        datos.add(nuevoDato);
        notify();
    }
}
