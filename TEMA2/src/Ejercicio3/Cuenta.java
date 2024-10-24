package Ejercicio3;

public class Cuenta {

    private int saldo;

    public Cuenta(int saldo){
        this.saldo = saldo;
    }

    public int getSaldo(){
        return this.saldo;
    }

    private void restar(int cantidad){
        saldo -= cantidad;
    }

    private void sumar(int cantidad){
        saldo += cantidad;
    }

    public synchronized void retirarDinero (int cantidad, String nombre){
        if (getSaldo() >= cantidad){
            System.out.println(nombre + ":" + " SE VA A RETIRAR SALDO (ACTUAL ES: " + getSaldo() + ")");
            restar(cantidad);
        }else{
            System.out.println("No se puede retirar dinero, NO HAY SALDO (ACTUAL ES: " + saldo);
        }
    }

    public synchronized void ingresarDinero (int cantidad, String nombre){
        System.out.println(nombre + ":" + " SE VA A INGRESAR SALDO (ACTUAL ES: " + getSaldo() + ")");
        sumar(cantidad);
    }

}
