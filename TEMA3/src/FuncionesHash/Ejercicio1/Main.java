package FuncionesHash.Ejercicio1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) {

        String datos = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme";
        byte[] dataBytes = datos.getBytes();

        try {
            // Crear el objeto MessageDigest para SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Calcular el hash del mensaje
            byte[] resumen = md.digest(dataBytes);

            // Crear objeto con el mensaje y su hash
            ArchivoConHash archivo = new ArchivoConHash(datos, resumen);

            // Guardar el objeto serializado en "Datos.dat"
            FileOutputStream fileout = new FileOutputStream("Datos.dat");
            ObjectOutputStream dataOS = new ObjectOutputStream(fileout);
            dataOS.writeObject(archivo);

            dataOS.close();
            fileout.close();

            System.out.println("Archivo 'Datos.dat' creado con éxito.");

        } catch (NoSuchAlgorithmException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
