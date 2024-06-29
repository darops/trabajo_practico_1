package ar.edu.unju.fi.ejercicio17Model;
import java.time.LocalDate;

public class Jugador {
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String nacionalidad;
    private float estatura;
    private float peso;
    private String posicion;
  
    public Jugador() {}

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getNacionalidad() {
        return nacionalidad;
    }
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    public float getEstatura() {
        return estatura;
    }
    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }
    public float getPeso() {
        return peso;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }
    public String getPosicion() {
        return posicion;
    }
    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int calcularEdad() {
        LocalDate ahora = LocalDate.now();
        return ahora.minusYears(fechaNacimiento.getYear()).getYear();
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" +
               "Apellido: " + apellido + "\n" +
               "Fecha de Nacimiento: " + fechaNacimiento + "\n" +
               "Nacionalidad: " + nacionalidad + "\n" +
               "Estatura: " + estatura + "\n" +
               "Peso: " + peso + "\n" +
               "Posición: " + posicion + "\n";
    }
}