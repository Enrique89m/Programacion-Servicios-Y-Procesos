import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class SacarCodigoHTML {
    public static void main(String[] args) {
        URL url=null;
        try {
            url=new URL("http://192.168.74.100/pepe");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        BufferedReader in;
        try {
            InputStream is = url.openStream();
            in=new BufferedReader(new InputStreamReader(is));
            String inputLine;
            while((inputLine=in.readLine()) != null)
                System.out.println(inputLine);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}