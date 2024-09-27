package EjerciciosRepaso;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio1_1 {
    static Scanner sc = new Scanner(System.in);

    public static int[] convertirCasilla(String casilla) {
        String letras = "ABCDEFGH";
        int columna = letras.indexOf(casilla.charAt(0));
        int fila = Character.getNumericValue(casilla.charAt(1)) - 1;
        return new int[] {fila, columna};
    }

    public static String convertirCoordenadas(int fila, int columna) {
        String letras = "ABCDEFGH";
        return letras.charAt(columna) + String.valueOf(fila + 1);
    }

    public static List<String> movimientosAlfil(String casilla) {
        int[] posicion = convertirCasilla(casilla);
        int fila = posicion[0];
        int columna = posicion[1];

        List<String> movimientosPosibles = new ArrayList<>();

        // DIAGONAL ARRIBA DERECHA
        for (int i = 1; i < 8; i++) {
            if (fila + i < 8 && columna + i < 8) {
                movimientosPosibles.add(convertirCoordenadas(fila + i, columna + i));
            } else {
                break;
            }
        }

        // DIAGONAL ARRIBA IZQUIERDA
        for (int i = 1; i < 8; i++) {
            if (fila + i < 8 && columna - i >= 0) {
                movimientosPosibles.add(convertirCoordenadas(fila + i, columna - i));
            } else {
                break;
            }
        }

        // DIAGONAL ABAJO DERECHA
        for (int i = 1; i < 8; i++) {
            if (fila - i >= 0 && columna + i < 8) {
                movimientosPosibles.add(convertirCoordenadas(fila - i, columna + i));
            } else {
                break;
            }
        }

        // DIAGONAL ABAJO IZQUIERDA
        for (int i = 1; i < 8; i++) {
            if (fila - i >= 0 && columna - i >= 0) {
                movimientosPosibles.add(convertirCoordenadas(fila - i, columna - i));
            } else {
                break;
            }
        }
        return movimientosPosibles;
    }


    public static void main(String[] args) {

        String[][] tablero = new String[8][8];
        String letras = "ABCDEFGH";
        String casilla;

        //INSERTO LAS LETRAS Y NUMEROS EN UN STRING
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = String.valueOf(letras.charAt(j)) + (i+1);
            }
            System.out.println();
        }

        //IMPRIMO EL TABLERO
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.printf("%5s", tablero[i][j]);
            }
            System.out.println();
        }

        System.out.println("Introduce la casilla en la que se encuentra el alfil: ");
        casilla = sc.next().toUpperCase();

        List<String> movimientos = movimientosAlfil(casilla);

        System.out.println("El alfil puede moverse a las siguientes casillas:");
        for (String movimiento : movimientos) {
            System.out.print(movimiento + " ");
        }

    }
}
