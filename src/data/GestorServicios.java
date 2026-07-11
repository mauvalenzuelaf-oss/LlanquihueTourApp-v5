package data;

import java.util.ArrayList;
import java.util.List;

import model.ExcursionCultural;
import model.PaseoLacustre;
import model.RutaGastronomica;
import model.ServicioTuristico;

/**
 * Clase encargada de crear una colección polimórfica de servicios turísticos.
 */

public class GestorServicios {

    /**
     * Genera una colección de servicios turísticos.
     * La colección utiliza ServicioTuristico como tipo de referencia,
     * pero almacena objetos pertenecientes a distintas subclases.
     *
     * @return lista polimórfica de servicios turísticos
     */
    public List<ServicioTuristico> generarServicios() {

        List<ServicioTuristico> servicios = new ArrayList<>();

        servicios.add(
                new RutaGastronomica(
                        "En búsqueda del kuchen más grande del mundo",
                        4,
                        5
                )
        );

        servicios.add(
                new RutaGastronomica(
                        "Sabores del Lago Llanquihue",
                        3,
                        4
                )
        );

        servicios.add(
                new PaseoLacustre(
                        "Paseo Lacustre en Pijamas",
                        2,
                        "Catamarán"
                )
        );

        servicios.add(
                new PaseoLacustre(
                        "Navegación por el Lago Todos los Santos",
                        5,
                        "Lancha"
                )
        );

        servicios.add(
                new ExcursionCultural(
                        "Ruta de los Colonos Alemanes",
                        2,
                        "Museo Colonial Alemán de Frutillar"
                )
        );

        servicios.add(
                new ExcursionCultural(
                        "Ruta patrimonial diurna",
                        3,
                        "Iglesia del Sagrado Corazón"
                )
        );

        return servicios;
    }
}