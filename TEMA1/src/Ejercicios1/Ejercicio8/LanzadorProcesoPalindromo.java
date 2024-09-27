package Ejercicios1.Ejercicio8;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class LanzadorProcesoPalindromo {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String dir = System.getProperty("user.dir");
        File directorio = new File(dir + "/out/production/IdeaProjects");

        Process proceso;

        System.out.println("Introduce una cadena de texto: ");
        String cadena = sc.nextLine();

        try {
            proceso = new ProcessBuilder("java", "Ejercicios1.Ejercicio8.EsPalindromo", cadena).directory(directorio).start();
            OutputStream os = proceso.getOutputStream();
            os.write(cadena.getBytes());
            os.flush();
            os.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try{
            InputStream is = proceso.getInputStream();
            int c;
            while ((c = is.read()) != -1)
                System.out.print((char) c);
            is.close();
        }catch(NullPointerException|IOException e) {
            e.getMessage();
        }
    }
}
