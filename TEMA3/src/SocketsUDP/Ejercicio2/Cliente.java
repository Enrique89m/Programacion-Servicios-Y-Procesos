package SocketsUDP.Ejercicio2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.net.InetAddress.getLocalHost;

public class Cliente {
    static Scanner sc = new Scanner(System.in);

    static int puerto = 1234;
    static String host = "localhost";

    public static void main(String[] args) throws SocketException {

        DatagramSocket socketUDP = new DatagramSocket();

        int menu = 0;

        while (true) {
            System.out.println(
                    "==TICKETSERVER==\n" +
                            "Introduzca opción\n" +
                            "1-Listar butacas\n" +
                            "2-Reservar butacas\n" +
                            "3-Anular butacas\n" +
                            "4-Salir");

            menu = sc.nextInt();
            sc.nextLine();

            if (menu == 4) {
                System.out.println("Saliendo...");
                break;
            } else if (menu == 123) {
                enviarRespuesta("123@", socketUDP);
                System.out.println("Servidor apagado.");
                break;
            } else if (menu == 1 || menu == 2 || menu == 3) {
                String nombre = "";
                if (menu == 2 || menu == 3) {
                    System.out.print("Introduzca su nombre: ");
                    nombre = sc.nextLine();
                }
                String mensaje = menu + "@" + nombre;
                enviarRespuesta(mensaje, socketUDP);
            }
        }
        socketUDP.close();
    }


    private static void enviarRespuesta (String mensaje, DatagramSocket socket){
        byte[] buffer = new byte[1024];
        buffer = mensaje.getBytes();
        try {
            DatagramPacket paqueteEnvio = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(host), puerto);
            socket.send(paqueteEnvio);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}