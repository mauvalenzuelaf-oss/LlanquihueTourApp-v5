package model;

/**
 * Representa un vehículo utilizado en las operaciones
 * de Llanquihue Tour.
 */
public class Vehiculo implements Registrable {

    // Atributos
    private String tipoVehiculo;
    private int periodoAdquisicion;
    private int capacidadPasajeros;

    /**
     * Construye un vehículo con sus datos generales.
     *
     * @param tipoVehiculo tipo de vehículo
     * @param periodoAdquisicion período en que fue adquirido
     * @param capacidadPasajeros capacidad máxima de pasajeros
     */
    public Vehiculo(
            String tipoVehiculo,
            int periodoAdquisicion,
            int capacidadPasajeros) {

        this.tipoVehiculo = tipoVehiculo;
        this.periodoAdquisicion = periodoAdquisicion;
        this.capacidadPasajeros = capacidadPasajeros;
    }

    // Getters y Setters
    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public int getPeriodoAdquisicion() {
        return periodoAdquisicion;
    }

    public void setPeriodoAdquisicion(int periodoAdquisicion) {
        this.periodoAdquisicion = periodoAdquisicion;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

    /**
     * Muestra un resumen del vehículo.
     */
    @Override
    public void mostrarResumen() {
        System.out.println("Vehículo");
        System.out.println("Tipo de vehículo: " + tipoVehiculo);
        System.out.println(
                "Año de adquisición: " + periodoAdquisicion
        );
        System.out.println(
                "Capacidad: "
                        + capacidadPasajeros
                        + " pasajeros"
        );
    }
}
