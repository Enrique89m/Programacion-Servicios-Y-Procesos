package Ejercicio1;

import java.util.Scanner;

public class HiloEjemplo {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Introduce el nº de hilos que quieres lanzar: ");
        int numeroHilos = sc.nextInt();

        Hilo[] hilos = new Hilo[numeroHilos];

        for (int i = 0; i < numeroHilos; i++) {
            System.out.println("CREANDO HILO:Hilo " + (i+1));
            hilos[i] = new Hilo("Hilo " + (i+1));
            hilos[i].start();
        }

        // ESPERA A QUE TODOS LOS HILOS SE ACABEN CON .JOIN()
        for (int i = 0; i < numeroHilos; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(numeroHilos + " HILOS INICIADOS... y finalizados");

    }
}
