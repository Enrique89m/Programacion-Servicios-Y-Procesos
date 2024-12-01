package Ejercicio11;

public class Empleado extends Thread {

    String nombre;
    Saludo saludo;
    boolean esJefe;

    public Empleado (String nombre, Saludo saludo, boolean esJefe){

        setNombre(nombre);
        setSaludo(saludo);
        setEsJefe(esJefe);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Saludo getSaludo() {
        return saludo;
    }

    public void setSaludo(Saludo saludo) {
        this.saludo = saludo;
    }

    public boolean isEsJefe() {
        return esJefe;
    }

    public void setEsJefe(boolean esJefe) {
        this.esJefe = esJefe;
    }

    public void run() {

        synchronized (saludo){

            if (!isEsJefe()) {
                System.out.println(getNombre() + " ha entrado");

                if (!saludo.haEntrado) {
                    try {
                        saludo.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    saludo.SaludoEmpleado();
                    System.out.println(getNombre() + ": " + saludo.getSaludo());
                }else{
                    saludo.SaludoEmpleadoTarde();
                    System.out.println(getNombre() + ": " + saludo.getSaludo());
                }
            }

            if (isEsJefe()) {
                saludo.haEntrado = true;
                System.out.println("**** El jefe ha entrado ****");
                saludo.SaludoJefe();
                System.out.println(getNombre() + ": " + saludo.getSaludo());
                saludo.notifyAll();
            }
        }
    }
}
