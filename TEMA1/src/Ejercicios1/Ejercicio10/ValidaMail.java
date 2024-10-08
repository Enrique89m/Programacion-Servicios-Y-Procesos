package Ejercicios1.Ejercicio10;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ValidaMail {
    public static void main(String[] args) {

        String email = "";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            email = br.readLine();
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (!email.contains("@")){
            throw new RuntimeException("ERROR: El email no contiene una @");
        }

        if (email.endsWith("@")){
            throw new RuntimeException("ERROR: No existe segundo identificador");
        }

        String[] emailArroba = email.split("@");
        if (emailArroba[0].length() < 3){
            throw new RuntimeException("ERROR: El primer identificador ha de tener una longitud mínima de 3 caracteres");
        }

        if (!(email.endsWith(".com") || email.endsWith(".es") || email.endsWith(".org"))){
            throw new RuntimeException("ERROR: El dominio no es ni com/es/org!");
        }
        System.out.println("Felicidades!! Email valido");
    }
}
