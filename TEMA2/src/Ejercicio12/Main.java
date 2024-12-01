package Ejercicio12;

public class Main {
    public static void main(String[] args) {

        DatoCompartido datoCompartido = new DatoCompartido();

        Productor productor = new Productor(datoCompartido);
        productor.start();

        Consumidor consumidor = new Consumidor(datoCompartido);
        consumidor.start();

    }
}
