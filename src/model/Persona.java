package model;

/**
 * Representa a una persona vinculada con Llanquihue Tour.
 * Contiene los atributos comunes de empleados
 * y colaboradores externos.
 */
public class Persona {

    // Atributos
    private String nombre;
    private int tiempoCargo;

    /**
     * Construye una persona con sus datos generales.
     *
     * @param nombre nombre de la persona
     * @param tiempoCargo años que lleva desempeñando su cargo
     */
    public Persona(String nombre, int tiempoCargo) {
        this.nombre = nombre;
        this.tiempoCargo = tiempoCargo;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempoCargo() {
        return tiempoCargo;
    }

    public void setTiempoCargo(int tiempoCargo) {
        this.tiempoCargo = tiempoCargo;
    }
}
