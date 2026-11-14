package co.edu.unasabana.actividad1.builder;

/** Contrato de los pasos de construcción, independiente del producto final. */
public interface Builder {
    Builder motor(String motor);
    Builder color(String color);
    Builder llantas(String llantas);
    Builder sonido(String sonido);
    Builder interiores(String interiores);
    Builder techoSolar(boolean techoSolar);
    Builder gps(boolean gps);
}
