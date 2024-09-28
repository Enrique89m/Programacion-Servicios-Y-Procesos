package Ejercicios1.Ejercicio9;

import java.io.IOException;

public class Leerweb {
    public static void main(String[] args) {

        String[] webs = args[0].split("@");

        Process proceso;
        try {

            if (webs.length == 1){
                proceso = new ProcessBuilder("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe", webs[0]).start();
            }else if (webs.length == 2){
                proceso = new ProcessBuilder("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe", webs[0], webs[1]).start();
            }else if (webs.length == 3){
                proceso = new ProcessBuilder("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe", webs[0], webs[1], webs[2]).start();
            }else{
                System.out.println("Demasiadas webs!!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
