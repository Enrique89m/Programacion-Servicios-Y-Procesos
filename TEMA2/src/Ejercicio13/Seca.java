package Ejercicio13;

public class Seca extends Thread{
    private int numeroDePlatos;
    private PilaPlatos pila;

    public Seca(int numeroDePlatos, PilaPlatos pila) {
        setNumeroDePlatos(numeroDePlatos);
        setPila(pila);
    }

    public int getNumeroDePlatos() {
        return numeroDePlatos;
    }

    public void setNumeroDePlatos(int numeroDePlatos) {
        this.numeroDePlatos = numeroDePlatos;
    }

    public PilaPlatos getPila() {
        return pila;
    }

    public void setPila(PilaPlatos pila) {
        this.pila = pila;
    }

    public void run(){

        for (int i = 0; i < numeroDePlatos; i++) {
            try {
                pila.secar();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
