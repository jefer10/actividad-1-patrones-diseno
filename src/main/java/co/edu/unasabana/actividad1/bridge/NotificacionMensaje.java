package co.edu.unasabana.actividad1.bridge;

public final class NotificacionMensaje extends Notificacion {
    public NotificacionMensaje(Plataforma plataforma, String contenido) {
        super(plataforma, contenido);
    }

    @Override
    protected String tipo() { return "MENSAJE"; }
}
