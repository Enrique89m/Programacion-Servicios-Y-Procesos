package Ejercicios1.Ejercicio7;
import java.io.*;
import java.util.Scanner;

public class Lanzador {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean numerosCorrectos = false;

        String dir = System.getProperty("user.dir");
        File directorio = new File(dir + "/out/production/IdeaProjects");
        System.out.println(dir);
        System.out.println(directorio);
        Process proceso;

        do {
            System.out.println("Introduce un número: ");
            String numero1 = String.valueOf(sc.nextInt());
            System.out.println("Introduce otro número: ");
            String numero2 = String.valueOf(sc.nextInt());

            try {
                proceso = new ProcessBuilder("java", "Ejercicios1.Ejercicio7.Sumador").directory(directorio).start();

                if ((Integer.parseInt(numero2)) > (Integer.parseInt(numero1))){
                    // Con OutputStream manda Strings al proceso abierto
                    OutputStream os = proceso.getOutputStream();
                    String numeros = numero1 + "@" + numero2;
                    os.write((numeros).getBytes());
                    os.flush();
                    os.close();
                    numerosCorrectos = true;

                }else{
                    System.out.println("El segundo número debe ser siempre mayor que el primero");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }while (!numerosCorrectos);

        //Con InputStream recibes el print que manda el proceso abierto
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
