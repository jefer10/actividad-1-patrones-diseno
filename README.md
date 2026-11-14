# Actividad 1 — Patrones de diseño

**Diplomado en Arquitectura de Software — Universidad de La Sabana**

**Lenguaje:** Java 8 o superior (único lenguaje para los tres ejercicios).  
**Fuente:** `Guía de actividad1_VF (1).pdf` facilitada en la actividad.  
**Objetivo de la entrega:** identificar el tipo de patrón, justificar el patrón elegido, presentar diagramas de clases y desarrollar código funcional para cada escenario.

## Resumen de los ejercicios

| Escenario | Tipo | Patrón | Clases principales |
|---|---|---|---|
| Personalización de automóviles | Creacional | **Builder** | `Builder`, `AutomovilBuilder`, `Automovil`, `Director` |
| Notificaciones para web, móvil y escritorio | Estructural | **Bridge** | `Notificacion`, `Plataforma`, implementaciones de cada eje |
| Comunicación en un chat grupal | Comportamiento | **Mediator** | `MediadorChat`, `SalaChat`, `Usuario` |

## 1. Builder — personalización de automóviles

**Problema de la guía:** los atributos opcionales (motor, color, llantas, sonido, interiores, techo solar, GPS, etc.) generan constructores largos o múltiples sobrecargas. Para esta implementación, se considera *motor* y *color* como obligatorios (regla de diseño adoptada para demostrar validaciones); los demás son opcionales.

**Solución:** la interfaz `Builder` define pasos de configuración; `AutomovilBuilder` los implementa, valida y crea un `Automovil` inmutable; `Director` ofrece recetas predeterminadas, sin conocer la implementación del producto. Es posible omitir atributos opcionales. `Automovil` mantiene sus invariantes aunque alguien lo construya directamente.

**Ventajas:** creación legible, eliminación de constructores telescópicos en el código cliente, independencia entre pasos y representación, facilidad para agregar configuraciones.  
**Desventajas:** introduce clases adicionales; el Builder concreto contiene estado mutable y no se debe compartir entre solicitudes concurrentes; las reglas de validación deben mantenerse alineadas con las del producto.

**Ejemplo:** `DemoBuilder` crea un automóvil personalizado y otro a través del `Director`.

**Diagrama UML:** [`diagramas/01-builder.drawio`](diagramas/01-builder.drawio).

## 2. Bridge — notificaciones multiplataforma

**Problema de la guía:** combinar cada tipo de notificación con cada plataforma mediante herencia crea demasiadas subclases (`NotificacionMensajeWeb`, `NotificacionAlertaMovil`, etc.).

**Solución:** se separan dos dimensiones independientes: `Notificacion` (abstracción y tipos como mensaje, alerta, advertencia, confirmación) y `Plataforma` (implementador para web, móvil y escritorio). Una notificación delega su presentación a la plataforma configurada, que puede sustituirse en ejecución.

**Ventajas:** evita la multiplicación de clases por combinaciones; favorece extensión independiente de tipos y plataformas; reduce el acoplamiento.  
**Desventajas:** crea un nivel de indirección adicional; una implementación basada en interfaces puede resultar excesiva para un sistema muy pequeño. Las clases muestran el resultado como texto, sin integrar sistemas reales de notificaciones.

**Ejemplo:** `DemoBridge` muestra notificaciones y cambia una alerta de web a móvil durante la ejecución.

**Diagrama UML:** [`diagramas/02-bridge.drawio`](diagramas/02-bridge.drawio).

## 3. Mediator — chat grupal

**Problema de la guía:** si cada usuario guarda referencias a todos los demás, aumenta el acoplamiento y agregar o eliminar usuarios obliga a actualizar múltiples relaciones.

**Solución:** `MediadorChat` declara las operaciones de registro, retiro y envío; `SalaChat` centraliza participantes y distribución de mensajes; `Usuario` solamente conoce al mediador. La sala distribuye los mensajes a todos los participantes excepto al remitente.

**Ventajas:** disminuye las dependencias entre usuarios; centraliza las reglas de comunicación; simplifica la entrada y salida de participantes.  
**Desventajas:** el mediador puede crecer excesivamente si concentra muchas reglas; para un chat real serían necesarios aspectos adicionales como persistencia, autenticación, concurrencia y transporte por red.

**Ejemplo:** `DemoMediator` registra tres usuarios, difunde mensajes y comprueba que un usuario retirado ya no recibe nuevas comunicaciones.

**Diagrama UML:** [`diagramas/03-mediator.drawio`](diagramas/03-mediator.drawio).

## Estructura del proyecto

```text
Actividad_1/
├── pom.xml
├── README.md
├── diagramas/
│   ├── 01-builder.drawio
│   ├── 02-bridge.drawio
│   └── 03-mediator.drawio
└── src/
    └── main/java/co/edu/unasabana/actividad1/
        ├── Main.java
        ├── builder/ (Builder, AutomovilBuilder, Automovil, Director, DemoBuilder)
        ├── bridge/ (Plataforma, 3 plataformas, Notificacion, 4 tipos, DemoBridge)
        └── mediator/ (MediadorChat, SalaChat, Usuario, DemoMediator)
```

## Cómo ejecutar en Windows (PowerShell)

1. Clonar el repositorio o descargar y extraer el ZIP.
2. Con Java (JDK 8 o superior) y Maven instalados y disponibles en el PATH, abrir la terminal en la carpeta que contiene `pom.xml` y ejecutar:

```powershell
mvn -q compile
java -cp target/classes co.edu.unasabana.actividad1.Main
```

También puede ejecutarse desde IntelliJ IDEA, Eclipse o VS Code abriendo el proyecto Maven y ejecutando `Main.java`.

## Cómo visualizar los diagramas

Los archivos `.drawio` contienen los tres diagramas de clases editables. Para visualizarlos, abrir [diagrams.net](https://app.diagrams.net/), seleccionar **Abrir diagrama existente** y elegir un archivo de la carpeta `diagramas/`. También se pueden abrir con la aplicación de escritorio de draw.io o una extensión compatible en VS Code, y exportar como PNG, SVG o PDF.

## Correspondencia con la rúbrica

- **Identificación:** los tres patrones se indican con su categoría y justificación.
- **Diagramas de clases:** tres fuentes UML documentan atributos, operaciones, generalización, realización, asociación y dependencias.
- **Código funcional:** los tres escenarios tienen clases independientes y ejemplos ejecutables desde `Main.java`.

## Decisiones y límites

Esta solución adopta las siguientes decisiones adicionales (no definidas explícitamente en la guía): `motor` y `color` son obligatorios; los mensajes del chat se difunden a los demás miembros, no al remitente; las notificaciones se representan como texto de consola. No se agrega base de datos, framework ni interfaz gráfica, porque no son requisitos de los escenarios.
