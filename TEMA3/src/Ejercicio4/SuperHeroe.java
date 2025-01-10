package Ejercicio4;

public class SuperHeroe {

    String id;
    String nombre;
    String idSecreta;
    String descripcion;

    public SuperHeroe(String id, String nombre, String idSecreta, String descripcion) {
        setId(id);
        setNombre(nombre);
        setIdSecreta(idSecreta);
        setDescripcion(descripcion);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdSecreta() {
        return idSecreta;
    }

    public void setIdSecreta(String idSecreta) {
        this.idSecreta = idSecreta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "superHeroe{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", idSecreta='" + idSecreta + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}