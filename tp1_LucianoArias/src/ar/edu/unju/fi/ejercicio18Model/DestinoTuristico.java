package ar.edu.unju.fi.ejercicio18Model;

public class DestinoTuristico {
    private String codigo;
    private String nombre;
    private Double precio;
    private Pais pais;
    private int cantDias;

    public DestinoTuristico() {
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public int getCantDias() {
        return cantDias;
    }

    public void setCantDias(int cantDias) {
        this.cantDias = cantDias;
    }

    public void MostrarDatos() {
        System.out.println("**Mostrar Datos del destino turistico**");
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Codigo: " + this.getCodigo());
        System.out.println("Cantidad de dias: " + this.getCantDias());
        System.out.println("Pais: " + (this.getPais()).getNombre());
    }
}