package co.edu.unasabana.actividad1;

import co.edu.unasabana.actividad1.builder.DemoBuilder;
import co.edu.unasabana.actividad1.bridge.DemoBridge;
import co.edu.unasabana.actividad1.mediator.DemoMediator;

/** Ejecuta los tres escenarios de la guía. */
public final class Main {
    private Main() { }

    public static void main(String[] args) {
        System.out.println("=== 1. BUILDER ===");
        DemoBuilder.main(args);
        System.out.println("\n=== 2. BRIDGE ===");
        DemoBridge.main(args);
        System.out.println("\n=== 3. MEDIATOR ===");
        DemoMediator.main(args);
    }
}
