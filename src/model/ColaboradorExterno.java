package model;

/**
 * Representa a un colaborador externo vinculado
 * con las operaciones de Llanquihue Tour.
 */
public class ColaboradorExterno extends Persona implements Registrable {

    // Atributos
    private String nombreEmpresa;
    private String tipoServicio;

    /**
     * Construye un colaborador externo con sus datos generales.
     *
     * @param nombre nombre de la persona de contacto
     * @param tiempoCargo tiempo que lleva desempeñando su cargo
     * @param nombreEmpresa nombre de la empresa externa
     * @param tipoServicio tipo de servicio que presta
     */
    public ColaboradorExterno(
            String nombre,
            int tiempoCargo,
            String nombreEmpresa,
            String tipoServicio) {

        super(nombre, tiempoCargo);
        this.nombreEmpresa = nombreEmpresa;
        this.tipoServicio = tipoServicio;
    }

    // Getters y Setters
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    /**
     * Muestra un resumen del colaborador externo.
     */
    @Override
    public void mostrarResumen() {
        System.out.println("Colaborador externo");
        System.out.println("Nombre: " + getNombre());
        System.out.println(
                "Nombre de la empresa: " + nombreEmpresa
        );
        System.out.println(
                "Tipo de servicio: " + tipoServicio
        );
        System.out.println(
                "Años en el cargo: "
                        + getTiempoCargo()
                        + " años"
        );
    }
}
