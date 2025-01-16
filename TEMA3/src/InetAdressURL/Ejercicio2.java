package InetAdressURL;

import java.net.MalformedURLException;
import java.net.URL;

public class Ejercicio2 {
    public static void main(String[] args) {

        try {
            URL url = new URL("http://docs.oracle.com:123/javase/23");
            System.out.println("URL completa: " + url);
            System.out.println("getProtocol: " + url.getProtocol());
            System.out.println("getHost: " + url.getHost());
            System.out.println("getPort: " + url.getPort());
            System.out.println("getFile: " + url.getFile());
            System.out.println("getUserInfo: " + url.getUserInfo());
            System.out.println("getPath: " + url.getPath());
            System.out.println("getAuthority: " + url.getAuthority());
            System.out.println("getQuery: " + url.getQuery());
            System.out.println("getDefaultPort: " + url.getDefaultPort());

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}
