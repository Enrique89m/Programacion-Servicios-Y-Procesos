package Ejercicio8;

public class Main {
    public static void main(String[] args) {

        new Thread(()-> {
            System.out.println("Numeros pares");
            for (int i = 0; i < 20; i++) {
                if (i%2 == 0){
                    System.out.print(i + " ");
                }
            }
        }).run();

        System.out.println();

        new Thread(()-> {
            System.out.println("Numeros impares");
            for (int i = 0; i < 20; i++) {
                if (i%2 != 0){
                    System.out.print(i + " ");
                }
            }
        }).run();
    }
}
