package model;

/**
 * Representa un servicio turístico ofrecido por Llanquihue Tour.
 * Contiene los atributos comunes de todos los servicios turísticos.
 */
public class ServicioTuristico {

    // Atributos
    private String nombre;
    private int duracionHoras;

    /**
     * Construye un servicio turístico con sus datos generales.
     *
     * @param nombre nombre del servicio turístico
     * @param duracionHoras duración del servicio expresada en horas
     */
    public ServicioTuristico(String nombre, int duracionHoras) {
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    /**
     * Muestra la información general del servicio turístico.
     * Este método puede ser sobrescrito por las subclases.
     */
    public void mostrarInformacion() {
        System.out.println("Servicio turístico");
        System.out.println("Nombre: " + nombre);
        System.out.println("Duración: " + duracionHoras + " horas");
    }
}
