package Ejercicios1.Ejercicio7;
import java.io.*;

public class Sumador {
    public static int suma(int num1, int num2) {
        int resultadoSuma = 0;
        for (int i = num1; i <= num2; i++) {
            resultadoSuma += i;
        }
        return resultadoSuma;
    }
    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] numeros = bf.readLine().split("@");

            int numero1 = Integer.parseInt(numeros[0]);
            int numero2 = Integer.parseInt(numeros[1]);
            System.out.println("La suma de todos los numeros entre " + numero1 + " y "+ numero2 + " es "+ suma(numero1, numero2));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
