package SocketsUDP.Ejercicio3;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    static Scanner sc = new Scanner(System.in);
    static String host = "localhost";
    static int puerto = 6000;

    public static void main(String[] args) {

        System.out.println("Escribe una palabra: ");
        String palabra = sc.next();

        try {
            DatagramSocket socket = new DatagramSocket();
            byte[] buffer = new byte[1024];

            buffer = palabra.getBytes();

            DatagramPacket paqueteEnvio = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(host), puerto);
            socket.send(paqueteEnvio);

            socket.setSoTimeout(5000);

            byte[] bufferLlegada = new byte[1024];
            DatagramPacket paqueteRecibido = new DatagramPacket(bufferLlegada, bufferLlegada.length);
            socket.receive(paqueteRecibido);

            String palabraTraducida = new String(paqueteRecibido.getData()).trim();
            System.out.println(palabraTraducida);



        } catch (IOException e) {
            System.out.println("No se encontró traducción");
            throw new RuntimeException(e);
        }


    }
}
