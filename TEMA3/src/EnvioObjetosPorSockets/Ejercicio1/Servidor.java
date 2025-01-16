package EnvioObjetosPorSockets.Ejercicio1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    static final int Puerto = 2000;

    public static void main(String[] args) {
        try {
            ServerSocket skServidor = new ServerSocket(Puerto);
            System.out.println("Esperando conexión del cliente...");

            Socket sCliente1 = skServidor.accept();
            System.out.println("¡Cliente conectado!");

            //Recibir objeto del cliente
            ObjectInputStream flujoEntrada = new ObjectInputStream(sCliente1.getInputStream());
            Object objetoRecibido = flujoEntrada.readObject();
            System.out.println("Objeto recibido del cliente: " + objetoRecibido.toString());

            //Enviar mensaje al cliente
            OutputStream flujoSalida = sCliente1.getOutputStream();
            DataOutputStream mensaje = new DataOutputStream(flujoSalida);
            mensaje.writeUTF("Mensaje recibido correctamente en el servidor");

            skServidor.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Conexión cerrada");


    }




}
