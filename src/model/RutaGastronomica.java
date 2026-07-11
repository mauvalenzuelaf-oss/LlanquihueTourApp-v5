package model;

/**
 * Representa una ruta gastronómica ofrecida por Llanquihue Tour.
 */
public class RutaGastronomica extends ServicioTuristico {

    // Atributo
    private int numeroDeParadas;

    /**
     * Construye una ruta gastronómica.
     *
     * @param nombre nombre de la ruta gastronómica
     * @param duracionHoras duración de la ruta expresada en horas
     * @param numeroDeParadas cantidad de paradas gastronómicas
     */
    public RutaGastronomica(
            String nombre,
            int duracionHoras,
            int numeroDeParadas) {

        super(nombre, duracionHoras);
        this.numeroDeParadas = numeroDeParadas;
    }

    // Getter y Setter
    public int getNumeroDeParadas() {
        return numeroDeParadas;
    }

    public void setNumeroDeParadas(int numeroDeParadas) {
        this.numeroDeParadas = numeroDeParadas;
    }

    /**
     * Muestra la información general y específica
     * de la ruta gastronómica.
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("Ruta gastronómica");
        System.out.println("Nombre: " + getNombre());
        System.out.println(
                "Duración: " + getDuracionHoras() + " horas"
        );
        System.out.println(
                "Número de paradas: " + numeroDeParadas
        );
    }
}
