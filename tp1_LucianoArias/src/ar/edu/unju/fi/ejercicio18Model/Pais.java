package ar.edu.unju.fi.ejercicio18Model;

public class Pais {
    private String codigo;
    private String nombre;

    public Pais(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void MostrarDatos() {
        System.out.println("**Datos del pais**");
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Codigo: " + this.getCodigo());
    }
}