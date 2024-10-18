package Ejercicios9;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {


        System.out.println("Introduce el número de virus que quieres inyectar: ");
        int nVirus = sc.nextInt();

        for (int i = 0; i < nVirus; i++) {
            final int index = i;
            new Thread(()-> {
                Thread.currentThread().setName("Virus");
                System.out.print((Thread.currentThread().getName()) + " " + (index+1) + ":");
                int total = 0;
                do{
                    try {
                        Thread.sleep(500);
                        int aleatorio = (int)(Math.random()*2);
                        if (aleatorio == 1){
                            total += 5;
                            System.out.print("X");
                        }else if (aleatorio == 0 && total < 90){
                            total += 10;
                            System.out.print("XX");
                        }else{
                            total += 5;
                            System.out.print("X");
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }while (total < 100);
            System.out.println(" 100%");
            }).run();
        }
        System.out.println("\nHAS SIDO INFECTADO!");
    }
}
