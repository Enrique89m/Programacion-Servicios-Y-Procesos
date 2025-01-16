package ComunicacionEntreSockets.Ejercicio3;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

            LocalDate fecha = LocalDate.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String fechaFormateada = fecha.format(formato);
            BufferedWriter bw = null;
            bw = new BufferedWriter(new FileWriter(fechaFormateada + ".txt", true));

            while (true) {
                //RECIBE EL PRODUCTO

                InputStream entrada = sCliente1.getInputStream();
                DataInputStream recuperacionProducto = new DataInputStream(entrada);

                if (recuperacionProducto.available() > 0){
                    String producto = recuperacionProducto.readUTF();

                    if (!producto.equals("salir")) {
                        System.out.println("Se ha recibido el producto " + producto);
                        bw.write(producto + "\n");
                        bw.flush();
                    } else {
                        break;
                    }
                }



            }

        // Cierro el socket
            bw.close();
            skServidor.close();
        } catch( Exception e ) {
            System.out.println( e.getMessage() );
        }
        System.out.println("Servidor cerrado.");
    }
}