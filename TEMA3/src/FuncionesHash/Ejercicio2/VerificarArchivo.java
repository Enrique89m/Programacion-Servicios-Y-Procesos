package FuncionesHash.Ejercicio2;

import FuncionesHash.Ejercicio1.ArchivoConHash;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class VerificarArchivo {
    public static void main(String[] args) {
        try {

            FileInputStream fileIn = new FileInputStream("Datos.dat");
            ObjectInputStream dataIS = new ObjectInputStream(fileIn);

            // Recuperar el objeto almacenado
            ArchivoConHash archivo = (ArchivoConHash) dataIS.readObject();

            // Obtener el contenido y el hash original
            String datos = archivo.getContenido();
            byte[] resumenOriginal = archivo.getResumen();

            System.out.println("Datos recuperados:");
            System.out.println(datos);

            // Calcular nuevamente el hash del contenido recibido
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] resumenActual = md.digest(datos.getBytes());

            // Comparar los hashes
            if (Arrays.equals(resumenActual, resumenOriginal)) {
                System.out.println("DATOS VÁLIDOS: El archivo no ha sido modificado.");
            } else {
                System.out.println("DATOS NO VÁLIDOS: El archivo ha sido alterado.");
            }

            dataIS.close();
            fileIn.close();

        } catch (IOException | ClassNotFoundException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
