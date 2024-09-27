package EjerciciosRepaso;

import java.util.ArrayList;

public class Ejercicio2_1 {
    public static void main(String[] args) {

        ArrayList<String> nombres = new ArrayList<>();

        nombres.add("Enrique");
        nombres.add("Alejandro");
        nombres.add("Pruden");
        nombres.add("Nacho");
        nombres.add("Alex");
        nombres.add("Emi");

        for (String nombre : nombres){
            System.out.println(nombre);
        }

    }
}
