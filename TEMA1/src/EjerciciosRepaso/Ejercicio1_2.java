package EjerciciosRepaso;

public class Ejercicio1_2 {
    public static void main(String[] args) {

        int[][] num = {
                {0, 30, 2, 0, 0, 5},
                {75, 0, 0, 0, 0, 0},
                {0, 0, -2, 9, 0, 11}
        };

        System.out.printf("%9s%-11s%-11s%-11s%-11s%-11s%-11s \n", "   ", "Column 0", "Column 1", "Column 2", "Column 3", "Column 4", "Column 5");
        for (int i = 0; i < num.length; i++) {
            System.out.print("Fila " + i);
            for (int j = 0; j < num.length+3; j++) {
                System.out.printf("%10s", num[i][j]);
            }
            System.out.println();
        }

    }
}
