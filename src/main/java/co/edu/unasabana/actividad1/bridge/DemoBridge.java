package co.edu.unasabana.actividad1.bridge;

public final class DemoBridge {
    private DemoBridge() { }

    public static void main(String[] args) {
        Plataforma web = new PlataformaWeb();
        Plataforma movil = new PlataformaMovil();
        Plataforma escritorio = new PlataformaEscritorio();

        Notificacion alerta = new NotificacionAlerta(web, "Se detectó un acceso inusual");
        System.out.println(alerta.mostrar());
        alerta.cambiarPlataforma(movil);
        System.out.println(alerta.mostrar());

        System.out.println(new NotificacionMensaje(escritorio, "Bienvenido").mostrar());
        System.out.println(new NotificacionAdvertencia(web, "Contraseña próxima a vencer").mostrar());
        System.out.println(new NotificacionConfirmacion(movil, "Operación completada").mostrar());
    }
}
