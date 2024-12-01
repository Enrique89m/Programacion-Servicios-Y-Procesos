package Ejercicio13;
import java.util.ArrayList;

public class PilaPlatos {
    ArrayList<Plato> pila = new ArrayList<>();

    public synchronized void lavar(Plato plato) throws InterruptedException {

        while (pila.size() == 5){
            wait();
        }
        pila.add(plato);
        System.out.println("Plato lavado " + plato + ", total en pila: " + pila.size());
        notifyAll();
    }

    public synchronized Plato secar() throws InterruptedException {

        while (pila.isEmpty()){
            wait();
        }
        Plato plato = pila.remove(pila.size()-1);
        System.out.println("Plato secado " + plato + ", total en pila: " + pila.size());
        notifyAll();
        return plato;
    }
}
