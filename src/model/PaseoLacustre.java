package model;

/**
 * Representa un paseo lacustre ofrecido por Llanquihue Tour.
 */
public class PaseoLacustre extends ServicioTuristico {

    // Atributo
    private String tipoEmbarcacion;

    /**
     * Construye un paseo lacustre.
     *
     * @param nombre nombre del paseo lacustre
     * @param duracionHoras duración del paseo expresada en horas
     * @param tipoEmbarcacion tipo de embarcación utilizada
     */
    public PaseoLacustre(
            String nombre,
            int duracionHoras,
            String tipoEmbarcacion) {

        super(nombre, duracionHoras);
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    // Getter y Setter
    public String getTipoEmbarcacion() {
        return tipoEmbarcacion;
    }

    public void setTipoEmbarcacion(String tipoEmbarcacion) {
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    /**
     * Muestra la información general y específica
     * del paseo lacustre.
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("Paseo lacustre");
        System.out.println("Nombre: " + getNombre());
        System.out.println(
                "Duración: " + getDuracionHoras() + " horas"
        );
        System.out.println(
                "Tipo de embarcación: " + tipoEmbarcacion
        );
    }
}
