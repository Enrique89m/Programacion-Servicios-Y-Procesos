package Ejercicio3;

public class Principal{
    public static void main(String[] args) {

        Cuenta cuenta = new Cuenta(1000);

        SacarDinero hilo1 = new SacarDinero(cuenta);
        hilo1.setName("Ana");

        IngresarDinero hilo2 = new IngresarDinero(cuenta);
        hilo2.setName("Juan");

        SacarDinero hilo3 = new SacarDinero(cuenta);
        hilo3.setName("Pepe");

        IngresarDinero hilo4 = new IngresarDinero(cuenta);
        hilo4.setName("Enrique");

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
    }
}
