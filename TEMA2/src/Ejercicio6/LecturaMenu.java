package Ejercicio6;

import java.io.*;

public class LecturaMenu extends Thread{

    public void run(){

        try {
            String linea;
            BufferedReader br = new BufferedReader(new FileReader("menu.txt"));

            while ((linea = br.readLine()) != null){
                if (linea.startsWith("1") && getName().equals("hilo1")){
                    if (!linea.contains("PRIMEROS")){
                        String[] lineaFormateada = linea.split("-");
                        System.out.println("El " + getName() + " escribe..." + lineaFormateada[1]);

                        BufferedWriter bw = new BufferedWriter(new FileWriter("primeros.txt", true));
                        bw.write(lineaFormateada[1] + "\n");
                        bw.flush();
                        bw.close();
                    }
                }

                if (linea.startsWith("2") && getName().equals("hilo2")){
                    if (!linea.contains("SEGUNDOS")){
                        String[] lineaFormateada = linea.split("-");
                        System.out.println("El " + getName() + " escribe..." + lineaFormateada[1]);

                        BufferedWriter bw = new BufferedWriter(new FileWriter("segundos.txt", true));
                        bw.write(lineaFormateada[1] + "\n");
                        bw.flush();
                        bw.close();
                    }
                }

                if (linea.startsWith("3") && getName().equals("hilo3")){
                    if (!linea.contains("POSTRES")){
                        String[] lineaFormateada = linea.split("-");
                        System.out.println("El " + getName() + " escribe..." + lineaFormateada[1]);

                        BufferedWriter bw = new BufferedWriter(new FileWriter("postres.txt", true));
                        bw.write(lineaFormateada[1] + "\n");
                        bw.flush();
                        bw.close();
                    }
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
