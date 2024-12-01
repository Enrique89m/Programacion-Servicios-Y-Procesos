package Ejercicio13;

public class Principal {
    public static void main(String[] args) {
        PilaPlatos pilaplatos = new PilaPlatos();
        int totalPlatosALavar = 20;

        Friega friega = new Friega(totalPlatosALavar, pilaplatos);
        Seca seca = new Seca(totalPlatosALavar, pilaplatos);

        friega.start();
        seca.start();

    }
}
