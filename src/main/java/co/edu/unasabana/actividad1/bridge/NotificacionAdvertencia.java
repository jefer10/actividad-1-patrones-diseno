package co.edu.unasabana.actividad1.bridge;

public final class NotificacionAdvertencia extends Notificacion {
    public NotificacionAdvertencia(Plataforma plataforma, String contenido) {
        super(plataforma, contenido);
    }

    @Override
    protected String tipo() { return "ADVERTENCIA"; }
}
