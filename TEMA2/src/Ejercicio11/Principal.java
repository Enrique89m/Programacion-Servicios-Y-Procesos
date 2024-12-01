package Ejercicio11;

public class Principal {
    public static void main(String[] args) {

        Saludo saludo = new Saludo();

        Empleado empleado = new Empleado("Pruden", saludo, false);
        Empleado empleado1 = new Empleado("Alejandro", saludo, false);
        Empleado empleado2 = new Empleado("Nacho", saludo, false);
        Empleado empleado3 = new Empleado("Alex", saludo, false);
        Empleado empleado4 = new Empleado("Emi", saludo, false);

        Empleado jefe1 = new Empleado("Enrique", saludo, true);

        empleado.start();
        empleado1.start();
        empleado2.start();
        empleado3.start();
        empleado4.start();
        jefe1.start();

    }
}
