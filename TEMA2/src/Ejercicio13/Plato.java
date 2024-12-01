package Ejercicio13;

public class Plato {
    int numeroDePlato;

    public Plato(int numeroDePlato) {
        setNumeroDePlato(numeroDePlato);
    }

    public int getNumeroDePlato() {
        return numeroDePlato;
    }

    public void setNumeroDePlato(int numeroDePlato) {
        this.numeroDePlato = numeroDePlato;
    }

    @Override
    public String toString() {
        return "#" + numeroDePlato;
    }
}
