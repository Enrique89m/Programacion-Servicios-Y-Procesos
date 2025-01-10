import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ejercicio1 {
    public static void main(String[] args) {

        System.out.println("SALIDA PARA LOCALHOST\n");

        try {
            InetAddress iplocal = InetAddress.getByName("localhost");

            System.out.println(iplocal.getHostName());
            System.out.println(iplocal.getLocalHost());
            System.out.println(iplocal.getHostAddress());
            System.out.println(iplocal);
            System.out.println("-----------------------------------");

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\nSALIDA PARA URL\n");
        try {
            InetAddress[] ip = InetAddress.getAllByName("www.youtube.es");

            for (InetAddress direccion : ip){
                System.out.println("--------------------");
                System.out.println(direccion.getHostName());
                System.out.println(direccion.getLocalHost());
                System.out.println(direccion.getHostAddress());
                System.out.println(direccion);

            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}