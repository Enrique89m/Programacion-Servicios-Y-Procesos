package SocketsUDP.Ejercicio2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;

public class Servidor {

    static int puerto = 1234;
    static String[] butacas = new String[4];
    static ArrayList<String> listaEspera = new ArrayList<>();

    
    public static void main(String[] args) {
        
        try {

            DatagramSocket socketUDP = new DatagramSocket(puerto);
            System.out.println("Servidor esperando datagrama...");

            while (true){
                byte[] buffer = new byte[1024];

                DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);

                socketUDP.receive(recibo);
                String mensajeRecibido = new String(recibo.getData()).trim();

                String[] split = mensajeRecibido.split("@");
                String opcion = split[0];


                switch (opcion){
                    case "1":
                        listarButacas();
                        break;
                    case "2":
                        reservarButaca(split[1]);
                        break;
                    case "3":
                        anularButaca(split[1]);
                        break;
                    case "123":
                        System.out.println("Servidor apagado por solicitud del cliente.");
                        socketUDP.close();
                        return;
                    default:
                        System.out.println("Opcion incorrecta");

                }

            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void listarButacas() {
        System.out.println("Servidor arrancado...");

        for (int i = 0; i < butacas.length; i++) {
            if (butacas[i] != null && !butacas[i].equals("LIBRE")) {
                System.out.println((i + 1) + ": " + butacas[i]);
            } else {
                System.out.println((i + 1) + ": LIBRE");
            }
        }

        if (!listaEspera.isEmpty()) {
            System.out.println("\nLista de espera:");
            for (int i = 0; i < listaEspera.size(); i++) {
                System.out.println((i + 1) + ": " + listaEspera.get(i));
            }
        }
    }


    private static void reservarButaca(String nombre) {
        for (int i = 0; i < butacas.length; i++) {
            if (butacas[i] == null || butacas[i].equals("LIBRE")) {
                butacas[i] = nombre;
                System.out.println("Reserva exitosa: " + nombre + " ocupa la butaca " + (i + 1));
                return;
            }
        }

        listaEspera.add(nombre);
        System.out.println(nombre + " agregado a la lista de espera.");
    }


    private static void anularButaca(String nombre) {
        for (int i = 0; i < butacas.length; i++) {
            if (nombre.equals(butacas[i])) {
                if (!listaEspera.isEmpty()) {
                    String siguienteCliente = listaEspera.remove(0);
                    butacas[i] = siguienteCliente;
                    System.out.println("Butaca " + (i + 1) + " asignada a " + siguienteCliente + " (desde lista de espera).");
                } else {
                    butacas[i] = "LIBRE";
                    System.out.println("Butaca " + (i + 1) + " liberada.");
                }
                return;
            }
        }

        System.out.println(nombre + " no tiene una reserva activa.");
    }




}
