package model;

/**
 * Representa una excursión cultural ofrecida por Llanquihue Tour.
 */
public class ExcursionCultural extends ServicioTuristico {

    //Atributos
    private String lugarHistorico;

    /**
     * Construye una excursión cultural.
     *
     * @param nombre nombre de la excursión cultural
     * @param duracionHoras duración de la excursión expresada en horas
     * @param lugarHistorico lugar histórico visitado
     */
    public ExcursionCultural(
            String nombre,
            int duracionHoras,
            String lugarHistorico) {

        super(nombre, duracionHoras);
        this.lugarHistorico = lugarHistorico;
    }

    // getter y setter
    public String getLugarHistorico() {
        return lugarHistorico;
    }

    public void setLugarHistorico(String lugarHistorico) {
        this.lugarHistorico = lugarHistorico;
    }

    /**
     * Muestra la información general y específica
     * de la excursión cultural.
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("Excursión cultural");
        System.out.println("Nombre: " + getNombre());
        System.out.println(
                "Duración: " + getDuracionHoras() + " horas"
        );
        System.out.println(
                "Lugar histórico: " + lugarHistorico
        );
    }
}
