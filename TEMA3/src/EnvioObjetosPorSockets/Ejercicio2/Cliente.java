package EnvioObjetosPorSockets.Ejercicio2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {

    static final String Host = "localhost";
    static final int Puerto=2000;

    public static void main(String[] args) {

        try {
            Socket sCliente = new Socket(Host, Puerto);

            //Recibir objeto del servidor
            ObjectInputStream flujoEntrada = new ObjectInputStream(sCliente.getInputStream());

            //Modifico el objeto recibido
            Persona personaRecibida = (Persona) flujoEntrada.readObject();
            personaRecibida.setNombre("Enrique");
            personaRecibida.setEdad(35);

            //Envio objeto al servidor modificado

            ObjectOutputStream flujoSalida = new ObjectOutputStream(sCliente.getOutputStream());
            flujoSalida.writeObject(personaRecibida);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
