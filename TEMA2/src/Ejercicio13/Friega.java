package Ejercicio13;

public class Friega extends Thread{
    private int numeroDePlatos;
    private PilaPlatos pila;

    public Friega(int numeroDePlatos, PilaPlatos pila) {
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

    public void run() {

        for (int i = 0; i < numeroDePlatos; i++) {

            try {
                pila.lavar(new Plato(i));
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }


}
