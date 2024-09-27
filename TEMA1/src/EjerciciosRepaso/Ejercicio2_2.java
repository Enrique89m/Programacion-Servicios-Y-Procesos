package EjerciciosRepaso;

import java.util.ArrayList;
import java.util.Collections;

public class Ejercicio2_2 {

    public static int sumaNumeros (ArrayList<Integer> numeros){
        int suma = 0;

        for (Integer numero : numeros){
            suma += numero;
        }
        return suma;
    }

    public static double mediaNumeros (ArrayList<Integer> numeros){
        int suma = 0;

        for (Integer numero : numeros){
            suma += numero;
        }
        return (double)suma / numeros.size();
    }

    public static int maximoNumeros (ArrayList<Integer> numeros){
        return Collections.max(numeros);
    }

    public static int minimoNumeros (ArrayList<Integer> numeros){
        return Collections.min(numeros);
    }

    public static void main(String[] args) {

        ArrayList<Integer> numeros = new ArrayList<>();

        //Genera numeros random entre 10 y 20
        int tamanyoLista = (int)(Math.random() * 11) + 10;

        for (int i = 0; i < tamanyoLista; i++) {
            numeros.add((int) (Math.random() * 100));
        }

        System.out.println("La suma de los números de la lista es: " + sumaNumeros(numeros));
        System.out.println("La media de los números de la lista es: " + (double)Math.round(mediaNumeros(numeros)*100)/100);
        System.out.println("El número máximo de la lista es: " + maximoNumeros(numeros));
        System.out.println("El número mínimo de la lista es: " + minimoNumeros(numeros));
    }
}
