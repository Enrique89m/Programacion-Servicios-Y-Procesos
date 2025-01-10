package Ejercicio6;

public class Main {
    public static void main(String[] args) {

        LecturaMenu lecturaPrimeros = new LecturaMenu();
        lecturaPrimeros.setName("hilo1");

        LecturaMenu lecturaSegundos = new LecturaMenu();
        lecturaSegundos.setName("hilo2");

        LecturaMenu lecturaPostres = new LecturaMenu();
        lecturaPostres.setName("hilo3");

        lecturaPrimeros.start();
        lecturaSegundos.start();
        lecturaPostres.start();
    }
}
