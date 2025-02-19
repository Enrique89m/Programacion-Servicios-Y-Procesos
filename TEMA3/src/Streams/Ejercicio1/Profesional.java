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

        if (genero == 'm' || genero == 'f'){
            this.genero = genero;
        }else{
            throw new IllegalArgumentException("El genero es incorrecto");
        }
    }

    public int getTipoProfesional() {
        return tipoProfesional;
    }

    public void setTipoProfesional(int tipoProfesional) {

        if (tipoProfesional >= 1 && tipoProfesional <= 3) {
            this.tipoProfesional = tipoProfesional;
        } else {
            throw new IllegalArgumentException("Tipo de profesional inválido. Usa 1 (Jugador), 2 (Directivo) o 3 (Fisio).");
        }
    }

    public String getTipoProfesionalTexto() {
        switch (tipoProfesional) {
            case 1:
                return "Jugador";
            case 2:
                return "Directivo";
            case 3:
                return "Fisio";
            default:
                return "Desconocido";
        }
    }

    @Override
    public String toString() {
        return "Profesional{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", genero=" + (genero == 'm' ? "Masculino" : "Femenino") +
                ", tipoProfesional=" + getTipoProfesionalTexto() +
                '}';
    }
}
