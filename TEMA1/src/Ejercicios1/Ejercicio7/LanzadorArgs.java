package Ejercicios1.Ejercicio7;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class LanzadorArgs {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean numerosCorrectos = false;

        String dir = System.getProperty("user.dir");
        File directorio = new File(dir + "/out/production/IdeaProjects");
        System.out.println(dir);
        System.out.println(directorio);
        Process proceso = null;

        do {
            System.out.println("Introduce un número: ");
            String numero1 = String.valueOf(sc.nextInt());
            System.out.println("Introduce otro número: ");
            String numero2 = String.valueOf(sc.nextInt());

            try {
                if ((Integer.parseInt(numero2)) > (Integer.parseInt(numero1))){
                    proceso = new ProcessBuilder("java", "Ejercicios1.Ejercicio7.SumadorArgs",numero1, numero2).directory(directorio).start();
                    numerosCorrectos = true;
                }else{
                    System.out.println("El segundo número debe ser siempre mayor que el primero");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }while (!numerosCorrectos);

        try{
            InputStream is = proceso.getInputStream();
            int c;
            while ((c = is.read()) != -1)
                System.out.print((char) c);
            is.close();
        }catch(Exception e) {
            e.getMessage();
        }
    }
}
