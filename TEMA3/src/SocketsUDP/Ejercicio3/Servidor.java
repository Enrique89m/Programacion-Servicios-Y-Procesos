package SocketsUDP.Ejercicio3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.HashMap;

public class Servidor {
    static int puerto = 6000;

    public static void main(String[] args) {
        byte[] buffer = new byte[1024];

        HashMap<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "hola");
        dictionary.put("world", "mundo");
        dictionary.put("dog", "perro");
        dictionary.put("cat", "gato");
        dictionary.put("food", "comida");


        try {
            DatagramSocket socket = new DatagramSocket(puerto);
            DatagramPacket paqueteRecibido = new DatagramPacket(buffer, buffer.length);
            socket.receive(paqueteRecibido);

            String palabraRecibida = new String(paqueteRecibido.getData()).trim();

            // Find the translation
            String translation = dictionary.getOrDefault(palabraRecibida, "");

            if (!translation.isEmpty()){
                byte[] bufferSalida = new byte[1024];
                bufferSalida = translation.getBytes();
                DatagramPacket paqueteSalida = new DatagramPacket(bufferSalida, bufferSalida.length, paqueteRecibido.getAddress(), paqueteRecibido.getPort());
                socket.send(paqueteSalida);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
