package Ejercicio7;

public class Usuario extends Thread{

    private static int entradasDisponibles = 100;
    private static int entradasVendidas = 0;

    private int numCliente;
    private String nombre;
    private int cantidad;

    public Usuario(int numCliente, String nombre, int cantidad){
        this.numCliente = numCliente;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public void reservaEntrada(String nombre, int cantidad){

        if (entradasDisponibles >= cantidad){
            entradasDisponibles -= cantidad;
            entradasVendidas += cantidad;
            System.out.println(cantidad + " reservadas para Cliente " + numCliente);
        } else {
            System.out.println("No hay suficientes entradas para Cliente " + numCliente);
        }
    }

    public void mostrarTotal(){
        System.out.println("Total de entradas vendidas: " + entradasVendidas);
    }

    public void run(){
        reservaEntrada(nombre, cantidad);
    }
}
