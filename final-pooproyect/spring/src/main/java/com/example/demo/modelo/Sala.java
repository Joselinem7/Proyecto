package com.example.demo.modelo;

import java.util.ArrayList;
import java.util.List;

public class Sala {
    private double tamanoPantalla;
    private String filas;
    private final List<Asiento> asientos;

    public Sala() {
        this.tamanoPantalla = 15.5;
        this.filas = "A-E";
        this.asientos = new ArrayList<>();
        inicializarAsientos();
    }

    private void inicializarAsientos() {
        agregarFila("A", 4.0, 38.0, 3);
        agregarFila("B", 5.2, 42.0, 4);
        agregarFila("C", 6.4, 45.0, 5);
        agregarFila("D", 7.6, 47.0, 4);
        agregarFila("E", 8.8, 50.0, 3);

        // Ejemplos de asientos que ya están ocupados.
        cambiarDisponibilidad("B", 3, false);
        cambiarDisponibilidad("C", 4, false);
        cambiarDisponibilidad("D", 6, false);
    }

    private void agregarFila(
            String fila,
            double distancia,
            double angulo,
            int calificacion
    ) {
        for (int numero = 1; numero <= 8; numero++) {
            double ajusteCentro = Math.abs(4.5 - numero);
            int calificacionAjustada = ajusteCentro <= 1.5
                    ? calificacion
                    : Math.max(1, calificacion - 1);

            asientos.add(new Asiento(
                    fila,
                    numero,
                    true,
                    distancia,
                    angulo + ajusteCentro,
                    calificacionAjustada,
                    "url_360_" + fila + numero
            ));
        }
    }

    private void cambiarDisponibilidad(
            String fila,
            int numero,
            boolean disponible
    ) {
        Asiento asiento = buscarAsiento(fila, numero);
        if (asiento == null || asiento.isDisponible() == disponible) {
            return;
        }

        int posicion = asientos.indexOf(asiento);
        asientos.set(posicion, new Asiento(
                asiento.getFila(),
                asiento.getNumero(),
                disponible,
                asiento.getDistanciaPantalla(),
                asiento.getAnguloVision(),
                asiento.getCalificacion(),
                asiento.getVista360()
        ));
    }

    public List<Asiento> mostrarAsientos() {
        return new ArrayList<>(asientos);
    }

    public Asiento buscarAsiento(String fila, int numero) {
        for (Asiento asiento : asientos) {
            if (asiento.getFila().equalsIgnoreCase(fila)
                    && asiento.getNumero() == numero) {
                return asiento;
            }
        }
        return null;
    }

    public String obtenerCaracteristicas() {
        return "Sala principal con pantalla de " + tamanoPantalla
                + " metros y distribución " + filas;
    }

    public double getTamanoPantalla() {
        return tamanoPantalla;
    }

    public String getFilas() {
        return filas;
    }
}
