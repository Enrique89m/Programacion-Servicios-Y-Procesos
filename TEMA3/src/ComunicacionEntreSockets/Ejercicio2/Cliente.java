package ComunicacionEntreSockets.Ejercicio2;

import java.io.DataOutputStream;
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

            System.out.println("Introduce un producto: ");
            String producto = sc.nextLine();

            //MANDA EL PRODUCTO
            OutputStream salida = null;
            salida = sCliente.getOutputStream();
            DataOutputStream envioProducto = new DataOutputStream(salida);
            envioProducto.writeUTF(producto);
            System.out.println("Se ha volcado el producto " + producto + " a la lista de la compra");


// Cierro el socket
            sCliente.close();
        } catch( Exception e ) {
            System.out.println( e.getMessage() );
        }
    }
}