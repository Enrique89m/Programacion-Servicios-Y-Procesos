package FuncionesHash.Ejercicio1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LeerArchivo {
    public static void main(String[] args) {
        try {

            FileInputStream fileIn = new FileInputStream("Datos.dat");
            ObjectInputStream dataIS = new ObjectInputStream(fileIn);

            ArchivoConHash archivo = (ArchivoConHash) dataIS.readObject();

            System.out.println(archivo.getContenido());

            dataIS.close();
            fileIn.close();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
