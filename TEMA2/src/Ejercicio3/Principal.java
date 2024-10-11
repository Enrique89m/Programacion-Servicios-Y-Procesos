package Ejercicio3;

public class Principal{
    public static void main(String[] args) {

        Cuenta cuenta = new Cuenta(1000);

        SacarDinero hilo1 = new SacarDinero(cuenta);
        hilo1.setName("Ana");
        hilo1.start();

        SacarDinero hilo2 = new SacarDinero(cuenta);
        hilo2.setName("Juan");
        hilo2.start();

        SacarDinero hilo3 = new SacarDinero(cuenta);
        hilo3.setName("Pepe");
        hilo3.start();

        SacarDinero hilo4 = new SacarDinero(cuenta);
        hilo4.setName("Enrique");
        hilo4.start();


    }
}
