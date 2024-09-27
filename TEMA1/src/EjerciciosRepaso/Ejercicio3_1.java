package EjerciciosRepaso;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio3_1 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Por favor, vaya introduciendo números enteros");
        int contador = 0;

        while (true) {
            try {
                System.out.print("Nº " + (contador + 1) + ": ");
                sc.nextInt();
                contador++;

            } catch (InputMismatchException e) {
                System.out.println("El dato introducido no es correcto, debe ser un número entero.\n" +
                        "Por favor, inténtelo de nuevo.");
                sc.next();
            }
        }
    }
}
