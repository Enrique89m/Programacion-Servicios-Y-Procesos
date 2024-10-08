package Ejercicios1.Ejercicio10;
import java.io.*;
import java.util.Scanner;

public class Principal {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        String dir = System.getProperty("user.dir");
        File directorio = new File(dir + "/out/production/IdeaProjects");
        int intentos = 0;
        boolean emailValido = false;

        while (intentos < 3 && !emailValido) {
            System.out.println("Introduce una dirección de email");
            String email = sc.next();

            Process proceso;

            try {
                proceso = new ProcessBuilder("java", "Ejercicios1.Ejercicio10.ValidaMail").directory(directorio).start();

                OutputStream os = proceso.getOutputStream();
                os.write(email.getBytes());
                os.flush();
                os.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {

                InputStream es = proceso.getErrorStream();
                BufferedReader bre = new BufferedReader(new InputStreamReader(es));
                String lineaError;
                while ((lineaError = bre.readLine()) != null){
                    System.out.print(lineaError + "\n");
                }
                intentos++;
                es.close();

                InputStream is = proceso.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String linea;
                while ((linea = br.readLine()) != null){
                    if (linea.equals("Felicidades!! Email valido")){
                        emailValido = true;
                        System.out.print(linea + "\n");
                    }
                }
                is.close();

            } catch (NullPointerException | IOException e) {
                e.getMessage();
            }
        }
        if (intentos == 3){
            throw new RuntimeException("Has alcanzado el maximo de 3 intentos");
        }
    }
}
