package co.edu.unasabana.actividad1.bridge;

public final class PlataformaMovil implements Plataforma {
    @Override
    public String mostrar(String tipo, String contenido) {
        return "[MÓVIL] " + tipo + ": " + contenido;
    }
}
