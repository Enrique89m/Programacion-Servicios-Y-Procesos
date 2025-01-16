package InetAdressURL.Ejercicio4;

public class Main {
    public static void main(String[] args) {

        String[] corredores = {"Hicham El Guerrouj", "Noah Ngeny", "Mohamed Farah", "Bernard Lagat",
                "Rashid Ramzi", "Ryan Gregson", "Fermín Cacho", "Teddy Flack"};

        for (int i = 0; i < corredores.length; i++) {
            Corredor corredor = new Corredor();
            corredor.setName(corredores[i]);
            corredor.start();
        }
    }
}
