package FuncionesHash.Ejercicio1;

import java.io.Serializable;

public class ArchivoConHash implements Serializable {
    private static final long serialVersionUID = 1L;
    private String contenido;
    private byte[] resumen;

    public ArchivoConHash(String contenido, byte[] resumen) {
        this.contenido = contenido;
        this.resumen = resumen;
    }

    public String getContenido() {
        return contenido;
    }

    public byte[] getResumen() {
        return resumen;
    }
}
