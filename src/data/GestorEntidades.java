package data;

import java.util.ArrayList;

import model.ColaboradorExterno;
import model.Empleado;
import model.Registrable;
import model.Vehiculo;

/**
 * Gestiona los recursos operativos de Llanquihue Tour.
 *
 * Esta clase utiliza una lista de Registrable para almacenar
 * empleados, colaboradores externos y vehículos. Aunque pertenecen
 * a clases diferentes, todos implementan la interfaz Registrable.
 */
public class GestorEntidades {

    // Atributos
    private ArrayList<Registrable> listaEntidades;

    /**
     * Construye el gestor con una lista vacía.
     */
    public GestorEntidades() {
        listaEntidades = new ArrayList<>();
    }

    /**
     * Agrega una entidad a la lista.
     *
     * El parámetro es de tipo Registrable, por lo que acepta
     * cualquier objeto que implemente esta interfaz.
     *
     * @param entidad entidad que se desea registrar
     */
    public void agregarEntidad(Registrable entidad) {

        if (entidad != null) {
            listaEntidades.add(entidad);
        }
    }

    /**
     * Construye un texto con el resumen de todas las entidades.
     *
     * Recorre la lista con un ciclo for-each, llama al método
     * mostrarResumen() y utiliza instanceof para identificar
     * el tipo real de cada objeto.
     *
     * @return resumen de las entidades registradas
     */
    public String obtenerResumenEntidades() {

        if (listaEntidades.isEmpty()) {
            return "No hay recursos operativos registrados.";
        }

        String resumen = "";

        for (Registrable entidad : listaEntidades) {

            /*
             * Llamada polimórfica al método definido
             * por la interfaz Registrable.
             */
            entidad.mostrarResumen();

            if (entidad instanceof Empleado) {

                Empleado empleado = (Empleado) entidad;

                resumen += "EMPLEADO\n";

                resumen += "Nombre: "
                        + empleado.getNombre() + "\n";

                resumen += "Cargo: "
                        + empleado.getCargo() + "\n";

                resumen += "Años en el cargo: "
                        + empleado.getTiempoCargo()
                        + " años\n";

            } else if (entidad instanceof ColaboradorExterno) {

                ColaboradorExterno colaborador =
                        (ColaboradorExterno) entidad;

                resumen += "COLABORADOR EXTERNO\n";

                resumen += "Nombre: "
                        + colaborador.getNombre() + "\n";

                resumen += "Nombre de la empresa: "
                        + colaborador.getNombreEmpresa()
                        + "\n";

                resumen += "Tipo de servicio: "
                        + colaborador.getTipoServicio()
                        + "\n";

                resumen += "Años en el cargo: "
                        + colaborador.getTiempoCargo()
                        + " años\n";

            } else if (entidad instanceof Vehiculo) {

                Vehiculo vehiculo = (Vehiculo) entidad;

                resumen += "VEHÍCULO\n";

                resumen += "Tipo de vehículo: "
                        + vehiculo.getTipoVehiculo()
                        + "\n";

                resumen += "Período de adquisición: "
                        + vehiculo.getPeriodoAdquisicion()
                        + "\n";

                resumen += "Capacidad: "
                        + vehiculo.getCapacidadPasajeros()
                        + " pasajeros\n";
            }

            resumen += "-----------------------------\n";
        }

        return resumen;
    }
}
