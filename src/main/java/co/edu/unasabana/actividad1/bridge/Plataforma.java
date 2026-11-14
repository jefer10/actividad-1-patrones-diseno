package co.edu.unasabana.actividad1.bridge;

/** Implementador del patrón Bridge: cada plataforma presenta a su manera. */
public interface Plataforma {
    String mostrar(String tipo, String contenido);
}
