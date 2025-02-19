package SocketsUDP.Ejercicio1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {

    public static void main(String[] args) throws IOException {
        byte[] buffer = new byte[1024];
        System.out.println("Servidor esperando datagrama...");
        //construyo datagrama a recibir
        DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);
        //Creacion del socket
        DatagramSocket socketUDP = new DatagramSocket(12345);
        //Recibo el datagrama
        socketUDP.receive(recibo);
        //Convierto lo recibido y mostrar el mensaje
        String mensaje = new String(recibo.getData()).trim();
        System.out.println("Servidor recibe: " + mensaje);

        int contador = 0;

        for (int i = 0; i < mensaje.length(); i++) {
            if (mensaje.charAt(i) == 'a'){
                contador++;
            }
        }

        //Obtengo el puerto y la direccion de origen
        //Sino se quiere responder, no es necesario
        int puertoCliente = recibo.getPort();
        InetAddress direccion = recibo.getAddress();

        System.out.println("Enviando número de apariciones de la letra 'a': " + contador);

        buffer = String.valueOf(contador).getBytes();

        DatagramPacket envio = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);

        socketUDP.send(envio);

        System.out.println("Cerrando conexión...");
        socketUDP.close();
    }
}
