package model;

/**
 * Representa a un empleado de Llanquihue Tour.
 */
public class Empleado extends Persona implements Registrable {

    // Atributos
    private String cargo;

    /**
     * Construye un empleado con sus datos laborales.
     *
     * @param nombre nombre del empleado
     * @param tiempoCargo años que lleva desempeñando su cargo
     * @param cargo cargo que desempeña en la empresa
     */
    public Empleado(
            String nombre,
            int tiempoCargo,
            String cargo) {

        super(nombre, tiempoCargo);
        this.cargo = cargo;
    }

    // Getter y Setter
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * Muestra un resumen del empleado.
     */
    @Override
    public void mostrarResumen() {
        System.out.println("Empleado");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Cargo: " + cargo);
        System.out.println(
                "Años en el cargo: "
                        + getTiempoCargo()
                        + " años"
        );
    }
}
