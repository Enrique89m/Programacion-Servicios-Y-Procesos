package Ejercicios1.Ejercicio9;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Visitaweb {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Introduce 3 webs en una misma linea, separandolas con una @");
        String webs = sc.nextLine();

        String dir = System.getProperty("user.dir");
        File directorio = new File(dir + "/out/production/IdeaProjects");

        Process proceso;

        try {
            proceso = new ProcessBuilder("java", "Ejercicios1.Ejercicio9.Leerweb", webs).directory(directorio).start();
            OutputStream os = proceso.getOutputStream();
            os.write(webs.getBytes());
            os.flush();
            os.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try{
            InputStream es = proceso.getErrorStream();
            int d;
            while ((d = es.read()) != -1)
                System.out.print((char) d);
            es.close();

            InputStream is = proceso.getInputStream();
            int c;
            while ((c = is.read()) != -1)
                System.out.print((char) c);
            is.close();
        }catch(NullPointerException|IOException e) {
            e.getMessage();
        }
    }
}
