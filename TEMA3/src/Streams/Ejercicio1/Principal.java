package Streams.Ejercicio1;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Profesional> listaProfesionales = new ArrayList<>();

    public static void main(String[] args) {
        int menu = 0;
        do {
            System.out.println("SOFTWARE DE GESTIÓN DEL IBIS SPORT CLUB \n" +
                    "=================================================== \n" +
                    "1. Introducir datos de un profesional \n" +
                    "2. Consulta con filtro \n" +
                    "3. Listado de nombres \n" +
                    "4. Salir");

            menu = sc.nextInt();
            sc.nextLine();


            switch (menu) {
                case 1:
                    introducirProfesional();
                    break;
                case 2:
                    consultarConFiltro();
                    break;
                case 3:
                    listarNombres();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }

        }while(menu != 4);
    }

    private static void introducirProfesional() {
        System.out.println("Introducir datos de un profesional");

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Edad: ");
        int edad = sc.nextInt();
        sc.nextLine();

        char genero;
        do {
            System.out.print("Género (m/f): ");
            genero = sc.next().toLowerCase().charAt(0);
            sc.nextLine();
        } while (genero != 'm' && genero != 'f');

        int tipoProfesional;
        do {
            System.out.print("Tipo de profesional (1=Jugador, 2=Directivo, 3=Fisio): ");
            tipoProfesional = sc.nextInt();
            sc.nextLine();
        } while (tipoProfesional < 1 || tipoProfesional > 3);

        Profesional nuevo = new Profesional(nombre, edad, genero, tipoProfesional);
        listaProfesionales.add(nuevo);
        System.out.println("Profesional añadido con éxito.");
    }

    private static void consultarConFiltro() {
        if (listaProfesionales.isEmpty()) {
            System.out.println("No hay profesionales registrados.");
            return;
        }

        int menu1;
        do {
            System.out.println("SUBMENÚ DE CONSULTAS");
            System.out.println("-----------------------");
            System.out.println("1. Profesionales por género");
            System.out.println("2. Profesionales por tipo");
            System.out.println("3. Profesionales por edad");
            System.out.println("4. Volver");
            System.out.print("Seleccione una opción: ");
            menu1 = sc.nextInt();
            sc.nextLine();

            switch (menu1) {
                case 1:
                    consultarPorGenero();
                    break;
                case 2:
                    consultarPorTipo();
                    break;
                case 3:
                    consultarPorEdad();
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (menu1 != 4);
    }

    private static void consultarPorGenero() {
        System.out.println("Profesionales Masculinos:");
        listaProfesionales.stream()
                .filter(p -> p.getGenero() == 'm')
                .forEach(System.out::println);

        System.out.println("Profesionales Femeninos:");
        listaProfesionales.stream()
                .filter(p -> p.getGenero() == 'f')
                .forEach(System.out::println);
    }

    private static void consultarPorTipo() {
        System.out.println("Jugadores:");
        listaProfesionales.stream()
                .filter(p -> p.getTipoProfesional() == 1)
                .forEach(System.out::println);

        System.out.println("Directivos:");
        listaProfesionales.stream()
                .filter(p -> p.getTipoProfesional() == 2)
                .forEach(System.out::println);

        System.out.println("Fisioterapeutas:");
        listaProfesionales.stream()
                .filter(p -> p.getTipoProfesional() == 3)
                .forEach(System.out::println);
    }

    private static void consultarPorEdad() {
        System.out.print("Introduce la edad mínima: ");
        int edadMinima = sc.nextInt();
        sc.nextLine();

        System.out.print("Introduce la edad máxima: ");
        int edadMaxima = sc.nextInt();
        sc.nextLine();

        if (edadMinima > edadMaxima) {
            System.out.println("Error: La edad mínima no puede ser mayor que la máxima.");
            return;
        }

        System.out.println("Profesionales en el rango de edad:");
        listaProfesionales.stream()
                .filter(p -> p.getEdad() >= edadMinima && p.getEdad() <= edadMaxima)
                .sorted(Comparator.comparingInt(Profesional::getEdad))
                .forEach(System.out::println);
    }

    private static void listarNombres() {
        if (listaProfesionales.isEmpty()) {
            System.out.println("No hay profesionales registrados.");
            return;
        }

        System.out.println("Lista de nombres:");

        String nombresFormateados = listaProfesionales.stream()
                .map(Profesional::getNombre)
                .collect(Collectors.joining(", ", "", "."));

        System.out.println(nombresFormateados);
    }


}
