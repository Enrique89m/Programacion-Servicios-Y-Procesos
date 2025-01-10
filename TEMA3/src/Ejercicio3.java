import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio3 {
    public static void main(String[] args) throws IOException {

        URL url=new URL("https://www.elmundo.es/");

        BufferedReader in;
        try {
            InputStream is = url.openStream();
            in=new BufferedReader(new InputStreamReader(is));
            String inputLine;
            // boolean esh2 = false;
            while((inputLine=in.readLine()) != null){

                Pattern pattern = Pattern.compile("<h2.*?>(.*?)</h2>");
                Matcher matcher = pattern.matcher(inputLine);
/*
                if (inputLine.startsWith("<h2")) {
                    esh2 = true;
                }
                if(esh2){
                    System.out.println(inputLine);
                }
                if (inputLine.endsWith("</h2>")) {
                    esh2 = false;
                }
                */
                // Imprimir el contenido encontrado
                while (matcher.find()) {
                    System.out.println(matcher.group(1));
                }
            }

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
