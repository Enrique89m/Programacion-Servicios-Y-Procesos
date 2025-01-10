package Ejercicio5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    static final int Puerto = 2000;
    public static void main( String[] arg ) {
        try {
// Inicio la escucha del servidor en un determinado puerto
            ServerSocket skServidor = new ServerSocket(Puerto);
            System.out.println("Escuchando en el puerto "+Puerto);


            System.out.println("Escuchando al Cliente 1 ");
// Aquí atiendo la petición del cliente1 ...

            Socket sCliente1 = skServidor.accept();

            //RECIBE EL NOMBRE EL USUARIO
            InputStream entrada = null;
            entrada = sCliente1.getInputStream();
            DataInputStream recuperacionUsuario = new DataInputStream(entrada);
            String usuario = recuperacionUsuario.readUTF();

            //MANDA EL NOMBRE DEL USUARIO
            OutputStream salida = null;
            salida = sCliente1.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(salida);

            flujoSalida.writeUTF("Hola " + usuario);
// Cierro el socket
            skServidor.close();
        } catch( Exception e ) {
            System.out.println( e.getMessage() );
        }
        System.out.println("Servidor cerrado. ");
    }
}