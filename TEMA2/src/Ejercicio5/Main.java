package Ejercicio5;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Introduzca número de coches a competir: ");
        int numeroCoches = sc.nextInt();

        ArrayList<Coche> coches = new ArrayList<>();

        for (int i = 0; i < numeroCoches; i++) {
            System.out.println("Introduzca marca del coche " + (i+1) + " : ");
            Coche coche = new Coche(sc.next(), i+1);
            coches.add(coche);
        }
        System.out.println("Que empiece la carrera!\n");

        for (Coche coch : coches) {
            coch.setName(coch.toString());
            coch.start();
        }
    }
}
