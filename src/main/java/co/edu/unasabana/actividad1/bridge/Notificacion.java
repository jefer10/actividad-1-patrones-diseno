package co.edu.unasabana.actividad1.bridge;

import java.util.Objects;

/** Abstracción de Bridge: tipo y plataforma varían independientemente. */
public abstract class Notificacion {
    private Plataforma plataforma;
    private final String contenido;

    protected Notificacion(Plataforma plataforma, String contenido) {
        this.plataforma = Objects.requireNonNull(plataforma, "La plataforma es obligatoria");
        if (contenido == null || contenido.trim().isEmpty()) {
            throw new IllegalArgumentException("El contenido es obligatorio");
        }
        this.contenido = contenido;
    }

    protected abstract String tipo();

    public final String mostrar() {
        return plataforma.mostrar(tipo(), contenido);
    }

    public final void cambiarPlataforma(Plataforma nuevaPlataforma) {
        this.plataforma = Objects.requireNonNull(nuevaPlataforma, "La plataforma es obligatoria");
    }
}
