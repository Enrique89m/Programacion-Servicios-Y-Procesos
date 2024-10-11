package Ejercicio5;

public class Coche extends Thread{

    private String marca;
    private int numero;

    public Coche(String marca, int numero){
        setMarca(marca);
        setNumero(numero);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return getMarca() + "(" + getNumero() + ")";
    }

    public void run(){
        int distanciaRecorrida = 0;

        while (distanciaRecorrida < 500){
            int distanciaAleatoria = (int)(Math.random()*101);
            for (int i = 0; i < distanciaAleatoria; i++) {
                distanciaRecorrida++;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(getName() + " lleva recorrido " + distanciaRecorrida + "km");
        }
        System.out.println("------------------------------------\n" + getName() + " ha finalizado al recorrer " + distanciaRecorrida + "km");
    }
}
