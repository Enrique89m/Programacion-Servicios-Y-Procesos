package Ejercicio11;

public class Saludo {

    private String saludo;
    boolean haEntrado = false;

    public Saludo (){
        setSaludo(saludo);
    }

    public String getSaludo() {
        return saludo;
    }

    public void setSaludo(String saludo) {
        this.saludo = saludo;
    }

    public void SaludoEmpleado(){
        setSaludo("Buenos días jefe");
    }

    public void SaludoEmpleadoTarde(){
        setSaludo("Siento el retraso");
    }

    public void SaludoJefe(){
        setSaludo("Buenos días currantes!!");
    }

}
