package co.edu.unasabana.actividad1.mediator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/** Colega: no mantiene referencias a los demás participantes. */
public final class Usuario {
    private final String nombre;
    private final MediadorChat mediador;
    private final List<String> recibidos = new ArrayList<String>();

    public Usuario(String nombre, MediadorChat mediador) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        this.nombre = nombre.trim();
        this.mediador = Objects.requireNonNull(mediador, "El mediador es obligatorio");
    }

    public String getNombre() { return nombre; }

    public void enviar(String mensaje) {
        mediador.enviarMensaje(this, mensaje);
    }

    public void recibir(String remitente, String mensaje) {
        recibidos.add(remitente + ": " + mensaje);
    }

    public List<String> getRecibidos() {
        return Collections.unmodifiableList(recibidos);
    }
}
