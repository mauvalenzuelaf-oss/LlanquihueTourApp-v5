package ui;

import java.time.Year;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import data.GestorEntidades;
import data.GestorServicios;

import model.ColaboradorExterno;
import model.Empleado;
import model.ServicioTuristico;
import model.Vehiculo;

/**
 * Ejecuta la interfaz gráfica básica
 * del sistema Llanquihue Tour.
 */
public class Main {

    /**
     * Método principal del programa.
     *
     * @param args argumentos de la línea de comandos
     */
    public static void main(String[] args) {

        GestorServicios gestorServicios =
                new GestorServicios();

        GestorEntidades gestorEntidades =
                new GestorEntidades();

        List<ServicioTuristico> servicios =
                gestorServicios.generarServicios();

        mostrarMenuPrincipal(
                servicios,
                gestorEntidades
        );
    }

    /**
     * Muestra el menú principal del sistema.
     *
     * @param servicios catálogo de servicios turísticos
     * @param gestorEntidades gestor de recursos operativos
     */
    private static void mostrarMenuPrincipal(
            List<ServicioTuristico> servicios,
            GestorEntidades gestorEntidades) {

        String[] opciones = {
                "Servicios turísticos",
                "Recursos operativos",
                "Salir"
        };

        boolean continuar = true;

        while (continuar) {

            int opcion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione el área que desea gestionar:",
                    "Llanquihue Tour",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            switch (opcion) {

                case 0:
                    mostrarServicios(servicios);
                    break;

                case 1:
                    mostrarMenuEntidades(gestorEntidades);
                    break;

                case 2:
                case JOptionPane.CLOSED_OPTION:
                    continuar = false;
                    break;

                default:
                    continuar = false;
            }
        }

        JOptionPane.showMessageDialog(
                null,
                "Programa finalizado.",
                "Llanquihue Tour",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    /**
     * Muestra los servicios turísticos mediante
     * el método polimórfico mostrarInformacion().
     *
     * @param servicios servicios turísticos disponibles
     */
    private static void mostrarServicios(
            List<ServicioTuristico> servicios) {

        if (servicios.isEmpty()) {

            JOptionPane.showMessageDialog(
                    null,
                    "No hay servicios turísticos registrados.",
                    "Servicios turísticos",
                    JOptionPane.INFORMATION_MESSAGE
            );

            return;
        }

        for (ServicioTuristico servicio : servicios) {

            servicio.mostrarInformacion();

            System.out.println(
                    "-----------------------------"
            );
        }

        JOptionPane.showMessageDialog(
                null,
                "El catálogo de servicios turísticos "
                        + "fue mostrado en la consola.",
                "Servicios turísticos",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    /**
     * Muestra el menú de recursos operativos.
     *
     * @param gestorEntidades gestor de recursos operativos
     */
    private static void mostrarMenuEntidades(
            GestorEntidades gestorEntidades) {

        String[] opciones = {
                "Registrar empleado",
                "Registrar colaborador externo",
                "Registrar vehículo",
                "Mostrar recursos",
                "Volver"
        };

        boolean continuar = true;

        while (continuar) {

            int opcion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opción:",
                    "Recursos operativos",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            switch (opcion) {

                case 0:
                    registrarEmpleado(gestorEntidades);
                    break;

                case 1:
                    registrarColaborador(gestorEntidades);
                    break;

                case 2:
                    registrarVehiculo(gestorEntidades);
                    break;

                case 3:
                    mostrarTexto(
                            gestorEntidades
                                    .obtenerResumenEntidades(),
                            "Recursos operativos"
                    );
                    break;

                case 4:
                case JOptionPane.CLOSED_OPTION:
                    continuar = false;
                    break;

                default:
                    continuar = false;
            }
        }
    }

    /**
     * Solicita los datos y registra un empleado.
     *
     * @param gestorEntidades gestor de recursos operativos
     */
    private static void registrarEmpleado(
            GestorEntidades gestorEntidades) {

        String nombre = solicitarTexto(
                "Ingrese el nombre del empleado:"
        );

        if (nombre == null) {
            return;
        }

        String cargo = solicitarTexto(
                "Ingrese el cargo del empleado:"
        );

        if (cargo == null) {
            return;
        }

        Integer tiempoCargo = solicitarEntero(
                "Ingrese los años en el cargo:",
                0
        );

        if (tiempoCargo == null) {
            return;
        }

        Empleado empleado = new Empleado(
                nombre,
                tiempoCargo,
                cargo
        );

        gestorEntidades.agregarEntidad(empleado);

        mostrarConfirmacion(
                "Empleado registrado correctamente."
        );
    }

    /**
     * Solicita los datos y registra
     * un colaborador externo.
     *
     * @param gestorEntidades gestor de recursos operativos
     */
    private static void registrarColaborador(
            GestorEntidades gestorEntidades) {

        String nombre = solicitarTexto(
                "Ingrese el nombre del colaborador:"
        );

        if (nombre == null) {
            return;
        }

        String nombreEmpresa = solicitarTexto(
                "Ingrese el nombre de la empresa:"
        );

        if (nombreEmpresa == null) {
            return;
        }

        String tipoServicio = solicitarTexto(
                "Ingrese el tipo de servicio:"
        );

        if (tipoServicio == null) {
            return;
        }

        Integer tiempoCargo = solicitarEntero(
                "Ingrese los años en el cargo:",
                0
        );

        if (tiempoCargo == null) {
            return;
        }

        ColaboradorExterno colaborador =
                new ColaboradorExterno(
                        nombre,
                        tiempoCargo,
                        nombreEmpresa,
                        tipoServicio
                );

        gestorEntidades.agregarEntidad(colaborador);

        mostrarConfirmacion(
                "Colaborador externo registrado correctamente."
        );
    }

    /**
     * Solicita los datos y registra un vehículo.
     *
     * @param gestorEntidades gestor de recursos operativos
     */
    private static void registrarVehiculo(
            GestorEntidades gestorEntidades) {

        String tipoVehiculo = solicitarTexto(
                "Ingrese el tipo de vehículo:"
        );

        if (tipoVehiculo == null) {
            return;
        }

        Integer capacidadPasajeros = solicitarEntero(
                "Ingrese la capacidad de pasajeros:",
                1
        );

        if (capacidadPasajeros == null) {
            return;
        }

        int periodoActual = Year.now().getValue();

        Integer periodoAdquisicion = solicitarEnteroEnRango(
                "Ingrese el año de adquisición:",
                1990,
                periodoActual
        );

        if (periodoAdquisicion == null) {
            return;
        }

        Vehiculo vehiculo = new Vehiculo(
                tipoVehiculo,
                periodoAdquisicion,
                capacidadPasajeros
        );

        gestorEntidades.agregarEntidad(vehiculo);

        mostrarConfirmacion(
                "Vehículo registrado correctamente."
        );
    }

    /**
     * Solicita un texto obligatorio.
     *
     * @param mensaje mensaje mostrado al usuario
     * @return texto ingresado o null si se cancela
     */
    private static String solicitarTexto(
            String mensaje) {

        while (true) {

            String texto = JOptionPane.showInputDialog(
                    null,
                    mensaje,
                    "Ingreso de datos",
                    JOptionPane.QUESTION_MESSAGE
            );

            if (texto == null) {
                return null;
            }

            texto = texto.trim();

            if (!texto.isEmpty()) {
                return texto;
            }

            JOptionPane.showMessageDialog(
                    null,
                    "El campo no puede quedar vacío.",
                    "Dato inválido",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }

    /**
     * Solicita un número entero igual o superior
     * al valor mínimo indicado.
     *
     * @param mensaje mensaje mostrado al usuario
     * @param minimo valor mínimo permitido
     * @return número ingresado o null si se cancela
     */
    private static Integer solicitarEntero(
            String mensaje,
            int minimo) {

        while (true) {

            String texto = JOptionPane.showInputDialog(
                    null,
                    mensaje,
                    "Ingreso de datos",
                    JOptionPane.QUESTION_MESSAGE
            );

            if (texto == null) {
                return null;
            }

            try {

                int numero = Integer.parseInt(
                        texto.trim()
                );

                if (numero >= minimo) {
                    return numero;
                }

                JOptionPane.showMessageDialog(
                        null,
                        "El número debe ser igual o superior a "
                                + minimo
                                + ".",
                        "Dato inválido",
                        JOptionPane.WARNING_MESSAGE
                );

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(
                        null,
                        "Debe ingresar un número entero válido.",
                        "Dato inválido",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        }
    }

    /**
     * Solicita un número entero dentro de un rango determinado.
     *
     * @param mensaje mensaje mostrado al usuario
     * @param minimo valor mínimo permitido
     * @param maximo valor máximo permitido
     * @return número ingresado o null si el usuario cancela
     */
    private static Integer solicitarEnteroEnRango(
            String mensaje,
            int minimo,
            int maximo) {

        while (true) {

            String texto = JOptionPane.showInputDialog(
                    null,
                    mensaje,
                    "Ingreso de datos",
                    JOptionPane.QUESTION_MESSAGE
            );

            if (texto == null) {
                return null;
            }

            try {

                int numero = Integer.parseInt(
                        texto.trim()
                );

                if (numero >= minimo && numero <= maximo) {
                    return numero;
                }

                JOptionPane.showMessageDialog(
                        null,
                        "El número debe estar entre "
                                + minimo
                                + " y "
                                + maximo
                                + ".",
                        "Dato inválido",
                        JOptionPane.WARNING_MESSAGE
                );

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(
                        null,
                        "Debe ingresar un número entero válido.",
                        "Dato inválido",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        }
    }

    /**
     * Muestra un texto en una ventana desplazable.
     *
     * @param contenido texto que será mostrado
     * @param titulo título de la ventana
     */
    private static void mostrarTexto(
            String contenido,
            String titulo) {

        JTextArea areaTexto = new JTextArea(
                contenido,
                22,
                50
        );

        areaTexto.setEditable(false);
        areaTexto.setCaretPosition(0);

        JScrollPane panel =
                new JScrollPane(areaTexto);

        JOptionPane.showMessageDialog(
                null,
                panel,
                titulo,
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    /**
     * Muestra un mensaje de confirmación.
     *
     * @param mensaje mensaje mostrado al usuario
     */
    private static void mostrarConfirmacion(
            String mensaje) {

        JOptionPane.showMessageDialog(
                null,
                mensaje,
                "Registro completado",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
