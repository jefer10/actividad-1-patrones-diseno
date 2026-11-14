package co.edu.unasabana.actividad1.builder;

public final class DemoBuilder {
    private DemoBuilder() { }

    public static void main(String[] args) {
        Automovil personalizado = new AutomovilBuilder()
                .motor("Híbrido").color("Rojo").gps(true).build();
        System.out.println("Personalizado: " + personalizado);

        Director director = new Director();
        AutomovilBuilder builderPremium = new AutomovilBuilder();
        director.configurarPremium(builderPremium);
        System.out.println("Premium: " + builderPremium.build());
    }
}
