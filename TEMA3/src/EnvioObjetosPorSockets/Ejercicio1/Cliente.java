package EnvioObjetosPorSockets.Ejercicio1;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

public class Cliente {
    static final String Host = "localhost";
    static final int Puerto=2000;

    public static void main(String[] args) {

        ArrayList<String> clientes = new ArrayList<>();
        clientes.add("Juan Pérez");
        clientes.add("María López");
        clientes.add("Carlos García");
        clientes.add("Ana Martínez");


        try {
            Socket sCliente = new Socket( Host, Puerto );

            InetAddress i = sCliente.getInetAddress();
            System.out.println("Iniciando conexión con el servidor...");

            // Enviamos el objeto al servidor
            ObjectOutputStream flujoSalida = new ObjectOutputStream(sCliente.getOutputStream());
            flujoSalida.writeObject(clientes);
            System.out.println("Objeto enviado al servidor: Lista de clientes");

            // Recibimos mensaje del servidor
            InputStream flujoEntrada = sCliente.getInputStream();
            DataInputStream mensaje = new DataInputStream(flujoEntrada);
            System.out.println("Objeto recibido del servidor: " + mensaje.readUTF());
            


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Conexión cerrada");


    }
}
