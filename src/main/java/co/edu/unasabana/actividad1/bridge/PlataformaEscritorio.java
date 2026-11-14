package co.edu.unasabana.actividad1.bridge;

public final class PlataformaEscritorio implements Plataforma {
    @Override
    public String mostrar(String tipo, String contenido) {
        return "[ESCRITORIO] " + tipo + ": " + contenido;
    }
}
