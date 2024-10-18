package Ejercicio7;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Usuario> usuarios = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Usuario usuario = new Usuario((i+1),"Cliente " + (i+1), (int) (Math.random() * 11));
            usuario.setName("hilo " + (i+1));
            usuarios.add(usuario);
            usuario.start();
        }

        for (Usuario usuario : usuarios){
            try {
                usuario.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        usuarios.get(0).mostrarTotal();
    }
}
