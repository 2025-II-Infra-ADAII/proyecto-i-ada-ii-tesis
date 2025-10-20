package edu.univalle.riegooptimo.algoritmos;

import edu.univalle.riegooptimo.modelo.Finca;
import edu.univalle.riegooptimo.modelo.Tablon;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FuerzaBrutaTest {


    private final FuerzaBruta fuerzaBruta = new FuerzaBruta();

    @Test
    void testRendimiento_3Elementos() {
        java.util.List<Tablon> tablones = java.util.List.of(
                new Tablon(13, 4, 4),
                new Tablon(11, 3, 3),
                new Tablon(8, 2, 2)
        );

        Finca finca = new Finca();
        tablones.forEach(finca::agregarTablon);

        long tiempoTotal = 0;
        FuerzaBruta.Resultado resultado = null;

        for (int i = 0; i < 5; i++) {
            long inicio = System.nanoTime();
            resultado = fuerzaBruta.resolver(finca);
            long fin = System.nanoTime();
            tiempoTotal += (fin - inicio);
        }

        long promedioNs = tiempoTotal / 5;
        double promedioMs = promedioNs / 1_000_000.0;

        System.out.printf("FuerzaBruta - Tiempo promedio (3 elementos): %.3f ms%n", promedioMs);

        int[] esperadoPermutacion = {0, 2, 1};
        int esperadoCosto = 0;

        assertArrayEquals(esperadoPermutacion, resultado.permutacion);
        assertEquals(esperadoCosto, resultado.costo);
    }

    @Test
    void testRendimiento_3v2Elementos() {
        java.util.List<Tablon> tablones = java.util.List.of(
                new Tablon(5, 1, 1),
                new Tablon(9, 3, 2),
                new Tablon(11, 4, 3)
        );

        Finca finca = new Finca();
        tablones.forEach(finca::agregarTablon);

        long tiempoTotal = 0;
        FuerzaBruta.Resultado resultado = null;

        for (int i = 0; i < 5; i++) {
            long inicio = System.nanoTime();
            resultado = fuerzaBruta.resolver(finca);
            long fin = System.nanoTime();
            tiempoTotal += (fin - inicio);
        }

        long promedioNs = tiempoTotal / 5;
        double promedioMs = promedioNs / 1_000_000.0;

        System.out.printf("FuerzaBruta - Tiempo promedio (3 elementos v2): %.3f ms%n", promedioMs);

        int[] esperadoPermutacion = {0,1,2};
        int esperadoCosto = 0;

        assertArrayEquals(esperadoPermutacion, resultado.permutacion);
        assertEquals(esperadoCosto, resultado.costo);
    }

    @Test
    void testRendimiento_5Elementos() {
        java.util.List<Tablon> tablones = java.util.List.of(
                new Tablon(10, 3, 4),
                new Tablon(5, 3, 3),
                new Tablon(2, 2, 1),
                new Tablon(8, 1, 1),
                new Tablon(6, 4, 2)
        );

        Finca finca = new Finca();
        tablones.forEach(finca::agregarTablon);

        long tiempoTotal = 0;
        FuerzaBruta.Resultado resultado = null;

        for (int i = 0; i < 5; i++) {
            long inicio = System.nanoTime();
            resultado = fuerzaBruta.resolver(finca);
            long fin = System.nanoTime();
            tiempoTotal += (fin - inicio);
        }

        long promedioNs = tiempoTotal / 5;
        double promedioMs = promedioNs / 1_000_000.0;

        System.out.printf("FuerzaBruta - Tiempo promedio (5 elementos): %.3f ms%n", promedioMs);

        int[] esperadoPermutacion = {2, 1, 3, 0, 4};
        int esperadoCosto = 14;

        assertArrayEquals(esperadoPermutacion, resultado.permutacion);
        assertEquals(esperadoCosto, resultado.costo);
    }

    @Test
    void testRendimiento_5v2Elementos() {
        java.util.List<Tablon> tablones = java.util.List.of(
                new Tablon(13, 3, 4),
                new Tablon(8, 2, 2),
                new Tablon(6, 1, 1),
                new Tablon(10, 4, 4),
                new Tablon(12, 3, 3)
        );

        Finca finca = new Finca();
        tablones.forEach(finca::agregarTablon);

        long tiempoTotal = 0;
        FuerzaBruta.Resultado resultado = null;

        for (int i = 0; i < 5; i++) {
            long inicio = System.nanoTime();
            resultado = fuerzaBruta.resolver(finca);
            long fin = System.nanoTime();
            tiempoTotal += (fin - inicio);
        }

        long promedioNs = tiempoTotal / 5;
        double promedioMs = promedioNs / 1_000_000.0;

        System.out.printf("FuerzaBruta - Tiempo promedio (5 elementos v2): %.3f ms%n", promedioMs);

        int[] esperadoPermutacion = {1,2,3,4,0};
        int esperadoCosto = 0;

        assertArrayEquals(esperadoPermutacion, resultado.permutacion);
        assertEquals(esperadoCosto, resultado.costo);
    }



}
