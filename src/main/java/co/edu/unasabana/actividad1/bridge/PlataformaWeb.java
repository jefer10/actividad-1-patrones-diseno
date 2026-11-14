package co.edu.unasabana.actividad1.bridge;

public final class PlataformaWeb implements Plataforma {
    @Override
    public String mostrar(String tipo, String contenido) {
        return "[WEB] " + tipo + ": " + contenido;
    }
}
