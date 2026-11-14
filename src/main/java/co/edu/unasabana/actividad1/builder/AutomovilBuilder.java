package co.edu.unasabana.actividad1.builder;

/** Builder concreto con interfaz fluida y producto específico Automovil. */
public final class AutomovilBuilder implements Builder {
    private String motor;
    private String color;
    private String llantas;
    private String sonido;
    private String interiores;
    private boolean techoSolar;
    private boolean gps;

    @Override public AutomovilBuilder motor(String valor) { this.motor = valor; return this; }
    @Override public AutomovilBuilder color(String valor) { this.color = valor; return this; }
    @Override public AutomovilBuilder llantas(String valor) { this.llantas = valor; return this; }
    @Override public AutomovilBuilder sonido(String valor) { this.sonido = valor; return this; }
    @Override public AutomovilBuilder interiores(String valor) { this.interiores = valor; return this; }
    @Override public AutomovilBuilder techoSolar(boolean valor) { this.techoSolar = valor; return this; }
    @Override public AutomovilBuilder gps(boolean valor) { this.gps = valor; return this; }

    public Automovil build() {
        if (motor == null || motor.trim().isEmpty()) {
            throw new IllegalStateException("El motor es obligatorio");
        }
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalStateException("El color es obligatorio");
        }
        return new Automovil(motor, color, llantas, sonido, interiores, techoSolar, gps);
    }
}
