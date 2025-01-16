package ComunicacionEntreSockets.Ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    static final String Host = "localhost";
    static final int Puerto=2000;
    static Scanner sc = new Scanner(System.in);
    public static void main( String[] arg ) {
        try{
// Me conecto al servidor en un detrminado puerto
            Socket sCliente = new Socket( Host, Puerto );
// TAREAS QUE REALIZA EL CLIENTE
            InetAddress i = sCliente.getInetAddress();
            System.out.println("Host Remoto: "+i.getHostName());
            System.out.println("IP Host Remoto: "+i.getHostAddress());

            System.out.println("Introduce tu nombre: ");
            String producto = sc.nextLine();

            //MANDA EL NOMBRE
            OutputStream salida = null;
            salida = sCliente.getOutputStream();
            DataOutputStream envioNombre = new DataOutputStream(salida);
            envioNombre.writeUTF(producto);

            //RECIBE MENSAJE
            InputStream entrada = null;
            entrada = sCliente.getInputStream();
            DataInputStream recuperacionMensaje = new DataInputStream(entrada);
            System.out.println(recuperacionMensaje.readUTF());


// Cierro el socket
            sCliente.close();
        } catch( Exception e ) {
            System.out.println( e.getMessage() );
        }
    }
}