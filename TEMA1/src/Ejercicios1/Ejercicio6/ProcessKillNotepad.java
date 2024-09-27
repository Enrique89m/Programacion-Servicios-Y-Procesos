package Ejercicios1.Ejercicio6;

import java.io.IOException;

public class ProcessKillNotepad {
    public static void main(String[] args) {

        try {
            Process proceso = new ProcessBuilder("notepad").start();

            Thread.sleep(10000);
            proceso.destroy();


        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
