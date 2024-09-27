package EjerciciosRepaso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ejercicio2_3 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<String> palabras = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            System.out.println("Introduce la palabra nº " + (i+1));
            palabras.add(sc.next());
        }

        System.out.println("Lista original: " + palabras);
        Collections.sort(palabras);
        System.out.println("Lista ordenada alfabéticamente: " + palabras);

    }
}
