package co.edu.unasabana.actividad1.mediator;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/** Mediador concreto: administra miembros y difunde mensajes a los demás. */
public final class SalaChat implements MediadorChat {
    private final Set<Usuario> participantes = new LinkedHashSet<Usuario>();

    @Override
    public void registrar(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario es obligatorio");
        }
        participantes.add(usuario);
    }

    @Override
    public void retirar(Usuario usuario) {
        participantes.remove(usuario);
    }

    @Override
    public void enviarMensaje(Usuario remitente, String mensaje) {
        if (!participantes.contains(remitente)) {
            throw new IllegalStateException("El remitente no pertenece a la sala");
        }
        if (mensaje == null || mensaje.trim().isEmpty()) {
            throw new IllegalArgumentException("El mensaje es obligatorio");
        }
        for (Usuario participante : participantes) {
            if (participante != remitente) {
                participante.recibir(remitente.getNombre(), mensaje);
            }
        }
    }

    public Set<Usuario> getParticipantes() {
        return Collections.unmodifiableSet(participantes);
    }
}
