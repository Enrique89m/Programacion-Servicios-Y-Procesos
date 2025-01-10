package Ejercicio4;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Ejercicio4 {
    public static void main(String[] args) {

        ArrayList<SuperHeroe> listaSuperHeroesM = new ArrayList<>();
        ArrayList<SuperHeroe> listaSuperHeroesD = new ArrayList<>();

        try {
            String linea;
            BufferedReader br = new BufferedReader(new FileReader("superheroes.txt"));

            while ((linea = br.readLine()) != null){
                String[] lineaSpliteada = linea.split(";");
                if (lineaSpliteada[0].startsWith("M")){
                    listaSuperHeroesM.add(new SuperHeroe(lineaSpliteada[0], lineaSpliteada[1], lineaSpliteada[2], lineaSpliteada[3]));
                }else{
                    listaSuperHeroesD.add(new SuperHeroe(lineaSpliteada[0], lineaSpliteada[1], lineaSpliteada[2], lineaSpliteada[3]));
                }
            }

            /*System.out.println("SUPERHEROES MARVEL");
            for (SuperHeroe sem : listaSuperHeroesM){
                System.out.println(sem);
            }

            System.out.println("SUPERHEROES DC");
            for (SuperHeroe sed : listaSuperHeroesD){
                System.out.println(sed);
            }*/

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        URL url=null;
        try {
            url=new URL("http://mural.uv.es/franpevi/index.html");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        BufferedReader in;
        try {
            InputStream is = url.openStream();
            in=new BufferedReader(new InputStreamReader(is));
            String inputLine;
            while((inputLine=in.readLine()) != null){
                if (inputLine.contains("<img")){
                    String[] lineaSpliteada = inputLine.split("\"");
                    System.out.println(lineaSpliteada[1]);
                    System.out.println(lineaSpliteada[3]);
                }


            }

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void escribirHTML(String codigo, ArrayList<SuperHeroe> array, String imagen){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("marvel.html"));
            bw.write("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "    <title>Document</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <table>");

            for (int i = 0; i < array.size(); i++) {
                if (array.get(i).id.equals(codigo)){
                    bw.write("<td>\n" +
                            "            <tr>\n" +
                            "                <img src=\"" + imagen + ">\n" +
                            "            </tr>\n" +
                            "        </td> ");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
