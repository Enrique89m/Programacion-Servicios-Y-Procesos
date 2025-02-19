package Streams.Ejercicio1;

public class Profesional {

    private String nombre;
    private int edad;
    private char genero;
    private int tipoProfesional;

    public Profesional(String nombre, int edad, char genero, int tipoProfesional) {
        setNombre(nombre);
        setEdad(edad);
        setGenero(genero);
        setTipoProfesional(tipoProfesional);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {

        if (genero == 'M' || genero == 'F'){
            this.genero = genero;
        }else{
            throw new IllegalArgumentException("El genero es incorrecto");
        }
    }

    public int getTipoProfesional() {
        return tipoProfesional;
    }

    public void setTipoProfesional(int tipoProfesional) {

        if (tipoProfesional == 1){
            this.tipoProfesional = Integer.parseInt("Jugador");
        }


    }
}
