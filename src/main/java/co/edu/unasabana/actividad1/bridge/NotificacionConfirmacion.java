package co.edu.unasabana.actividad1.bridge;

public final class NotificacionConfirmacion extends Notificacion {
    public NotificacionConfirmacion(Plataforma plataforma, String contenido) {
        super(plataforma, contenido);
    }

    @Override
    protected String tipo() { return "CONFIRMACIÓN"; }
}
