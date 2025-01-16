package EnvioObjetosPorSockets.Ejercicio2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    static final int Puerto = 2000;

    public static void main(String[] args) {

        try {
            ServerSocket skServidor = new ServerSocket(Puerto);
            System.out.println("Escuchando en el puerto "+Puerto);

            Socket sCliente1 = skServidor.accept();
            System.out.println("¡Cliente conectado!");

            //Crea objeto y lo muestra
            Persona persona = new Persona("Juan", 25);
            System.out.println("\nPersona creada en servidor" + "\n" + persona + "\n");

            //Envia objeto al cliente
            ObjectOutputStream flujoSalida = new ObjectOutputStream(sCliente1.getOutputStream());
            flujoSalida.writeObject(persona);

            //Recibo objeto modificado del cliente
            ObjectInputStream flujoEntrada = new ObjectInputStream(sCliente1.getInputStream());
            Persona personaRecibida = (Persona) flujoEntrada.readObject();

            System.out.println("Objeto recibido del cliente: " + personaRecibida.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
