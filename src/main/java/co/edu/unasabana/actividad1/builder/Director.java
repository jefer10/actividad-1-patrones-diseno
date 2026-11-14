package co.edu.unasabana.actividad1.builder;

/** Director opcional: define recetas sin conocer la clase del producto. */
public final class Director {
    public void configurarBasico(Builder builder) {
        builder.motor("Gasolina").color("Blanco").gps(false).techoSolar(false);
    }

    public void configurarPremium(Builder builder) {
        builder.motor("Eléctrico").color("Negro")
                .llantas("Aleación").sonido("Premium")
                .interiores("Cuero").gps(true).techoSolar(true);
    }
}
