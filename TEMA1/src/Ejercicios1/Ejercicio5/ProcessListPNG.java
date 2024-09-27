package Ejercicios1.Ejercicio5;

import java.io.*;
import java.util.Scanner;

public class ProcessListPNG {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Introduce la ruta del directorio (por ejemplo, /micarpeta/fotos): ");
        String ruta = sc.nextLine();

        File directorio = new File(ruta);

        // Verificar si la ruta es un directorio válido
        if (directorio.isDirectory()) {

            String[] cmd = {"bash", "-c", "ls *.png"};
            Process proceso;
            try {
                proceso = new ProcessBuilder(cmd).directory(directorio).start();
                InputStream streamSalida = proceso.getInputStream();

                int linea;
                while((linea = streamSalida.read()) != -1){
                    System.out.print((char)linea);
                }
                streamSalida.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            sc.close();
        }
    }
}
