package co.edu.unasabana.actividad1.bridge;

public final class NotificacionAlerta extends Notificacion {
    public NotificacionAlerta(Plataforma plataforma, String contenido) {
        super(plataforma, contenido);
    }

    @Override
    protected String tipo() { return "ALERTA"; }
}
