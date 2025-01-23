package SocketsUDP.Ejercicio1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;


import static java.net.InetAddress.getByName;

public class Cliente {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//puerto del servidor
        final int puerto = 12345;
//buffer donde se almacenara los mensajes
        byte[] buffer = new byte[1024];
        InetAddress destino = getByName("localhost");
        //getByName(args[0]); //InetAddress.getLocalHost();
        System.out.println("Introduce mensaje: ");
        String mensaje = sc.nextLine();
//Convierto el mensaje a bytes
        buffer = mensaje.getBytes();
//Creo un datagrama
        DatagramPacket envio = new DatagramPacket(buffer, buffer.length, destino, puerto);
//Creo el socket de UDP
        DatagramSocket socketUDP = new DatagramSocket(34567);
//Lo envio con send
        socketUDP.send(envio);

        System.out.println("Esperando datagrama...");
//construyo datagrama y buffer a recibir
        byte[] bufferRecibir = new byte[1024];

        DatagramPacket recibo = new DatagramPacket(bufferRecibir, bufferRecibir.length);

//Recibo el datagrama
        socketUDP.receive(recibo);
//Convierto lo recibido y mostrar el mensaje
        String mensajeRecibido = new String(recibo.getData()).trim();
        System.out.println("Recibo número de caracteres 'a' que son: " + mensajeRecibido);


//cierro el socket
        socketUDP.close();
    }
}
