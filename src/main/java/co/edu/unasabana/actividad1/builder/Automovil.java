package co.edu.unasabana.actividad1.builder;

import java.util.Objects;

/** Producto inmutable. El constructor mantiene las invariantes incluso sin Builder. */
public final class Automovil {
    private final String motor;
    private final String color;
    private final String llantas;
    private final String sonido;
    private final String interiores;
    private final boolean techoSolar;
    private final boolean gps;

    public Automovil(String motor, String color, String llantas, String sonido,
                     String interiores, boolean techoSolar, boolean gps) {
        this.motor = obligatorio(motor, "motor");
        this.color = obligatorio(color, "color");
        this.llantas = llantas;
        this.sonido = sonido;
        this.interiores = interiores;
        this.techoSolar = techoSolar;
        this.gps = gps;
    }

    private static String obligatorio(String valor, String nombre) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("El " + nombre + " es obligatorio");
        }
        return valor.trim();
    }

    public String getMotor() { return motor; }
    public String getColor() { return color; }
    public String getLlantas() { return llantas; }
    public String getSonido() { return sonido; }
    public String getInteriores() { return interiores; }
    public boolean isTechoSolar() { return techoSolar; }
    public boolean isGps() { return gps; }

    @Override
    public String toString() {
        return "Automovil{" +
                "motor='" + motor + '\'' +
                ", color='" + color + '\'' +
                ", llantas='" + Objects.toString(llantas, "estándar") + '\'' +
                ", sonido='" + Objects.toString(sonido, "estándar") + '\'' +
                ", interiores='" + Objects.toString(interiores, "estándar") + '\'' +
                ", techoSolar=" + techoSolar +
                ", gps=" + gps + '}';
    }
}
