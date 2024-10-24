package Ejercicio6;

import java.io.*;

public class LecturaMenu extends Thread{

    public void run(){

        try {
            String linea;
            BufferedReader br = new BufferedReader(new FileReader("menu.txt"));

            BufferedWriter bw1 = new BufferedWriter(new FileWriter("primeros.txt"));
            BufferedWriter bw2 = new BufferedWriter(new FileWriter("segundos.txt"));
            BufferedWriter bw3 = new BufferedWriter(new FileWriter("postres.txt"));

            while ((linea = br.readLine()) != null){

                if (linea.startsWith("1") && getName().equals("hilo1")){

                    if (!linea.contains("PRIMEROS")){
                        String[] lineaFormateada = linea.split("-");
                        System.out.println("El " + getName() + " escribe..." + lineaFormateada[1]);

                        bw1.write(lineaFormateada[1] + "\n");
                    }
                }


                if (linea.startsWith("2") && getName().equals("hilo2")){

                    if (!linea.contains("SEGUNDOS")){
                        String[] lineaFormateada = linea.split("-");
                        System.out.println("El " + getName() + " escribe..." + lineaFormateada[1]);

                        bw2.write(lineaFormateada[1] + "\n");
                    }
                }


                if (linea.startsWith("3") && getName().equals("hilo3")){

                    if (!linea.contains("POSTRES")){
                        String[] lineaFormateada = linea.split("-");
                        System.out.println("El " + getName() + " escribe..." + lineaFormateada[1]);

                        bw3.write(lineaFormateada[1] + "\n");
                    }
                }
            }
            bw1.close();
            bw2.close();
            bw3.close();
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
