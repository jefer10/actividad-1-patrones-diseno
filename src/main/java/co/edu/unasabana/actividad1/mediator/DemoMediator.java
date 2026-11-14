package co.edu.unasabana.actividad1.mediator;

public final class DemoMediator {
    private DemoMediator() { }

    public static void main(String[] args) {
        SalaChat sala = new SalaChat();
        Usuario ana = new Usuario("Ana", sala);
        Usuario luis = new Usuario("Luis", sala);
        Usuario maria = new Usuario("María", sala);
        sala.registrar(ana);
        sala.registrar(luis);
        sala.registrar(maria);

        ana.enviar("Hola equipo");
        luis.enviar("¡Hola Ana!");
        sala.retirar(maria);
        ana.enviar("María ya salió del chat");

        System.out.println("Ana recibe: " + ana.getRecibidos());
        System.out.println("Luis recibe: " + luis.getRecibidos());
        System.out.println("María recibe: " + maria.getRecibidos());
    }
}
