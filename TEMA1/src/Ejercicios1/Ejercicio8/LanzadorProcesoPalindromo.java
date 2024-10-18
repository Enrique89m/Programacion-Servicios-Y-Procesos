package Ejercicios1.Ejercicio8;

import java.io.*;
import java.util.Scanner;

public class LanzadorProcesoPalindromo {
    static Scanner sc = new Scanner(System.in);

    private static void escrituraFicheros(File archivo, String cadena) throws IOException {
        if (archivo.exists()){
            BufferedWriter bf = new BufferedWriter(new FileWriter(archivo, true));
            bf.write(", " + cadena);
            bf.close();
        }else{
            BufferedWriter bf = new BufferedWriter(new FileWriter(archivo));
            bf.write(cadena);
            bf.close();
        }
    }

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
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String linea;

            while ((linea = br.readLine()) != null) {
                if (linea.equals("La cadena pasada SI es palindromo")){
                    File archivoPalindromo = new File("palindromo.txt");
                    escrituraFicheros(archivoPalindromo, cadena);
                    System.out.print(linea);
                }

                if (linea.equals("La cadena pasada NO es palindromo")){
                    File archivoNoPalindromo = new File("Nopalindromo.txt");
                    escrituraFicheros(archivoNoPalindromo, cadena);
                    System.err.print(linea);
                }


                File archivoTodas = new File("todas.txt");
                escrituraFicheros(archivoTodas, cadena);
            }
            is.close();

        }catch(NullPointerException|IOException e) {
            e.getMessage();
        }
    }
}
