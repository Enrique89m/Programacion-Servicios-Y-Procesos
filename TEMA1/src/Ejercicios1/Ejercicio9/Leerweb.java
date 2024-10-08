package Ejercicios1.Ejercicio9;

import java.io.IOException;

public class Leerweb {
    public static void main(String[] args) {

        String[] webs = args[0].split("@");

        try {

            if (webs.length == 1){
                new ProcessBuilder("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe", webs[0]).start();
            }else if (webs.length == 2){
                new ProcessBuilder("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe", webs[0], webs[1]).start();
            }else if (webs.length == 3){
                new ProcessBuilder("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe", webs[0], webs[1], webs[2]).start();
            }else{
                throw new RuntimeException("Demasiadas webs!!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
