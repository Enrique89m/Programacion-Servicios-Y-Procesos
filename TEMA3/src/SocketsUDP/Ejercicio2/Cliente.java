package SocketsUDP.Ejercicio2;

import java.util.Scanner;

public class Cliente {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int menu = 0;

        while (menu != 4) {
            System.out.println(
                    "==TICKETSERVER==\n" +
                    "Introduzca opción\n" +
                    "1-Listar butacas\n" +
                    "2-Reservar butacas\n" +
                    "3-Anular butacas\n" +
                    "4-Salir");

            menu = sc.nextInt();

            switch (menu){
                case 1:
                    listarButacas();
                    break;
                case 2:
                    reservarButacas();
                    break;
                case 3:
                    anularButacas();
                    break;
                case 4:
                    System.out.println("Cerrando cliente...");
                    break;
                case 123:
                    System.out.println("MODO ROOT");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        }

    }

    private static void listarButacas(){
        //TODO
    }

    private static void reservarButacas(){
        System.out.println("Introduzca su nombre para la reserva: ");
        String nombre = sc.next();
    }

    private static void anularButacas(){
        System.out.println("Introduzca su nombre para la cancelación: ");
        String nombre = sc.next();
    }

}
