package co.edu.unasabana.actividad1.mediator;

/** Contrato que centraliza las interacciones entre usuarios. */
public interface MediadorChat {
    void registrar(Usuario usuario);
    void retirar(Usuario usuario);
    void enviarMensaje(Usuario remitente, String mensaje);
}
