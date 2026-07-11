![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)
# 🧠 Semana 8 - Evaluación Formativa N° 3 – Desarrollo Orientado a Objetos I

## 👤 Autor del proyecto
- **Nombre completo:** Mauricio Francisco Valenzuela Fuentes
- **Carrera:** Analista Programador Computacional
- **Sede:** Online

---

## 📘 Descripción general del sistema

Este proyecto corresponde a la **Actividad Sumativa N.º 3** de la asignatura *Desarrollo Orientado a Objetos I*.

Se trata de una nueva ampliación de **LlanquihueTourApp**, orientada a la aplicación de interfaces, herencia, polimorfismo, colecciones genéricas, uso de `instanceof` e interfaces gráficas en Java.

El sistema conserva la funcionalidad desarrollada durante las semanas anteriores para representar los servicios turísticos ofrecidos por **Llanquihue Tour**. Además, incorpora la gestión de nuevos recursos operativos necesarios para el funcionamiento de la agencia.

El programa permite trabajar con dos áreas principales:

```plaintext
1. Servicios turísticos.
2. Recursos operativos.
```

### 🧳 Servicios turísticos

El sistema conserva la jerarquía utilizada para representar los servicios ofrecidos por **Llanquihue Tour**.

La clase `ServicioTuristico` funciona como superclase de `RutaGastronomica`, `PaseoLacustre` y `ExcursionCultural`. Esta estructura permite reunir en una sola clase los datos y comportamientos compartidos por todos los servicios, mientras que cada subclase incorpora la información propia de su actividad.

Cada subclase sobrescribe el método `mostrarInformacion()` mediante la anotación `@Override`. De esta forma, el sistema puede invocar el mismo método desde una referencia de tipo `ServicioTuristico` y obtener un resultado diferente según la clase real del objeto.

La clase `GestorServicios` crea y devuelve una colección polimórfica de tipo `List<ServicioTuristico>`, en la que se almacenan objetos de las tres subclases.

### 👥 Recursos operativos

La aplicación incorpora la gestión de recursos operativos necesarios para el funcionamiento de **Llanquihue Tour**.

Para representar a las personas vinculadas con la agencia, se utiliza la superclase `Persona`, de la cual heredan `Empleado` y `ColaboradorExterno`. Esta jerarquía permite reutilizar los datos comunes a ambos tipos de persona.

También se incorpora la clase `Vehiculo`, que representa los medios de transporte utilizados por la agencia. Esta clase no hereda de `Persona`, porque corresponde a una entidad de naturaleza diferente.

A pesar de pertenecer a estructuras distintas, `Empleado`, `ColaboradorExterno` y `Vehiculo` implementan la interfaz `Registrable`. Gracias a ello, pueden almacenarse y gestionarse conjuntamente dentro de una colección polimórfica.

La clase `GestorEntidades` administra una colección de tipo `ArrayList<Registrable>`, en la que se almacenan objetos de las tres clases. Esta colección se recorre mediante un ciclo `for-each`, se invoca el método `mostrarResumen()` y se utiliza `instanceof` para identificar el tipo real de cada entidad.

---

## 🧱 Estructura general del proyecto

```plaintext
📁 LlanquihueTourApp-v5/
│
├── 📁 src/
│   │
│   ├── 📁 data/
│   │   ├── GestorServicios.java
│   │   └── GestorEntidades.java
│   │
│   ├── 📁 model/
│   │   ├── Registrable.java
│   │   ├── Persona.java
│   │   ├── Empleado.java
│   │   ├── ColaboradorExterno.java
│   │   ├── Vehiculo.java
│   │   ├── ServicioTuristico.java
│   │   ├── RutaGastronomica.java
│   │   ├── PaseoLacustre.java
│   │   └── ExcursionCultural.java
│   │
│   └── 📁 ui/
│       └── Main.java
│
├── 📄 .gitignore
│
├── 📄 LlanquihueTourApp.iml
│
└── 📄 README.md
```
---

## 🧩 Organización por paquetes

### 1. model

Contiene las clases e interfaces que representan las entidades del sistema.


**Registrable.java**
```plaintext
Interfaz que define el método: void mostrarResumen().
Es implementada por Empleado, ColaboradorExterno y Vehiculo.
```

**Persona.java**
```plaintext
Superclase que contiene los atributos comunes: nombre; tiempoCargo.
```

**Empleado.java**
```plaintext
Subclase de Persona.
Incorpora el atributo: cargo.
Además, implementa la interfaz Registrable.
```

**ColaboradorExterno.java**
```plaintext
Subclase de Persona.
Incorpora los atributos: nombreEmpresa; tipoServicio.
También implementa la interfaz Registrable.
```

**Vehiculo.java**
```plaintext
Clase independiente que representa un vehículo utilizado por la agencia.
Contiene los atributos: tipoVehiculo; periodoAdquisicion; capacidadPasajeros.
Implementa la interfaz Registrable.
```

**ServicioTuristico.java**
```plaintext
Superclase que contiene los atributos comunes de los servicios turísticos: nombre; duracionHoras.
También define el método mostrarInformacion().
```

**RutaGastronomica.java**
```plaintext
Subclase de ServicioTuristico.
Incorpora el atributo: numeroDeParadas
Sobrescribe el método mostrarInformacion().
```

**PaseoLacustre.java**
```plaintext
Subclase de ServicioTuristico.
Incorpora el atributo: tipoEmbarcacion.
Sobrescribe el método mostrarInformacion().
```

**ExcursionCultural.java**
```plaintext
Subclase de ServicioTuristico.
Incorpora el atributo: lugarHistorico.
Sobrescribe el método mostrarInformacion().
```

### 2. data

Contiene las clases responsables de almacenar y administrar los objetos.


**GestorServicios.java**
```plaintext
Crea y devuelve una colección polimórfica: List<ServicioTuristico>
La colección contiene objetos de las clases: RutaGastronomica; PaseoLacustre; ExcursionCultural.
```

**GestorEntidades.java**
```plaintext
Administra una colección: ArrayList<Registrable>
Permite agregar empleados, colaboradores externos y vehículos.
También recorre la colección mediante un ciclo for-each, llama polimórficamente a mostrarResumen() y utiliza instanceof para identificar el tipo real de cada objeto.
```

### 3. ui

Contiene la clase encargada de la interacción con el usuario.

**Main.java**
```plaintext
Implementa la interfaz gráfica mediante JOptionPane.
Permite:
  1. Acceder al catálogo de servicios turísticos.
  2. Registrar empleados.
  3. Registrar colaboradores externos.
  4. Registrar vehículos.
  5. Mostrar los recursos registrados.
  6. Validar los datos ingresados.
  7. Salir del sistema.
```
---

## ⚙️ Instrucciones para clonar y ejecutar el proyecto

1. Clona el repositorio desde GitHub:

```plaintext
git clone https://github.com/mauvalenzuelaf-oss/LlanquihueTourApp-v5.git
```

2. Abre IntelliJ IDEA.

3. Selecciona la opción `Open`.

4. Busca y selecciona la carpeta descargada:

```plaintext
LlanquihueTourApp-v5
```

5. Verifica que el código fuente se encuentre en la carpeta:

```plaintext
src
```

6. Confirma que dentro de `src` se encuentren los paquetes:

```plaintext
data
model
ui
```

7. Abre la clase principal:

```plaintext
src/ui/Main.java
```
8. Ejecuta el método `main`.

9. Utiliza las ventanas emergentes para navegar por el sistema.

10. La consola también mostrará los resultados de los métodos polimórficos:

```plaintext
mostrarInformacion()
mostrarResumen()
```
---
## 🖥️ Ejemplo abreviado de funcionamiento

Menú principal
```plaintext
Servicios turísticos
Recursos operativos
Salir
```

Menú de recursos operativos
```plaintext
Registrar empleado
Registrar colaborador externo
Registrar vehículo
Mostrar recursos
Volver
```

Ejemplo de recursos registrados
```plaintext
EMPLEADO
Nombre: Juan Pérez
Cargo: Encargado de operaciones
Años en el cargo: 5 años
-----------------------------

COLABORADOR EXTERNO
Nombre: María Soto
Nombre de la empresa: Turismo Lagos del Sur
Tipo de servicio: Operador local
Años en el cargo: 4 años
-----------------------------

VEHÍCULO
Tipo de vehículo: Catamarán
Capacidad: 40 pasajeros
Período de adquisición: 2022
-----------------------------
```
---

**Repositorio GitHub:** https://github.com/mauvalenzuelaf-oss/LlanquihueTourApp-v5

**Fecha de entrega:** 06/07/2026
