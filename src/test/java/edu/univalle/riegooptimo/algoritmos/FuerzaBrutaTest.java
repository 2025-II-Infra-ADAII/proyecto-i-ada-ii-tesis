package edu.univalle.riegooptimo.algoritmos;

import edu.univalle.riegooptimo.modelo.Finca;
import edu.univalle.riegooptimo.modelo.Tablon;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FuerzaBrutaTest {


    private final FuerzaBruta fuerzaBruta = new FuerzaBruta();

    @Test
    void testRendimiento_1Elemento() {
        java.util.List<Tablon> tablones = java.util.List.of(
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

        System.out.printf("FuerzaBruta - Tiempo promedio (1 elemento): %.6f ms%n", promedioMs);

        int[] esperadoPermutacion = {0};
        int esperadoCosto = 0;

        assertArrayEquals(esperadoPermutacion, resultado.permutacion);
        assertEquals(esperadoCosto, resultado.costo);
    }

    @Test
    void testRendimiento_1v2Elemento() {
        java.util.List<Tablon> tablones = java.util.List.of(
                new Tablon(12, 3, 4)
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

        System.out.printf("FuerzaBruta - Tiempo promedio (1 elemento v2): %.6f ms%n", promedioMs);

        int[] esperadoPermutacion = {0};
        int esperadoCosto = 0;

        assertArrayEquals(esperadoPermutacion, resultado.permutacion);
        assertEquals(esperadoCosto, resultado.costo);
    }


    @Test
    void testRendimiento_3Elementos() {
        java.util.List<Tablon> tablones = java.util.List.of(
                new Tablon(13, 4, 4),
                new Tablon(11, 2, 3),
                new Tablon(8, 3, 2)
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

        assertArrayEquals(resultado.permutacion, esperadoPermutacion);
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

        assertArrayEquals(resultado.permutacion, esperadoPermutacion);
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

        assertArrayEquals(resultado.permutacion, esperadoPermutacion);
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

        assertArrayEquals(resultado.permutacion, esperadoPermutacion);
        assertEquals(esperadoCosto, resultado.costo);
    }

    @Test
    void testRendimiento_8Elementos() {
        java.util.List<Tablon> tablones = java.util.List.of(
                new Tablon(10, 3, 4),
                new Tablon(5, 2, 2),
                new Tablon(8, 1, 1),
                new Tablon(6, 3, 3),
                new Tablon(12, 4, 4),
                new Tablon(7, 2, 2),
                new Tablon(9, 3, 3),
                new Tablon(4, 1, 1)
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

        System.out.printf("FuerzaBruta - Tiempo promedio (8 elementos): %.3f ms%n", promedioMs);


        int[] esperadoPermutacion = {1, 7, 3, 2, 0, 5, 6, 4};
        int esperadoCosto = 56;


        assertArrayEquals(resultado.permutacion, esperadoPermutacion);
        assertEquals(esperadoCosto, resultado.costo);
    }

    @Test
    void testRendimiento_8v2Elementos() {
        java.util.List<Tablon> tablones = java.util.List.of(
                new Tablon(9, 2, 2),
                new Tablon(7, 1, 1),
                new Tablon(11, 3, 3),
                new Tablon(14, 4, 4),
                new Tablon(10, 3, 3),
                new Tablon(8, 2, 2),
                new Tablon(6, 1, 1),
                new Tablon(12, 4, 4)
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

        System.out.printf("FuerzaBruta - Tiempo promedio (8 elementos v2): %.3f ms%n", promedioMs);

        int[] esperadoPermutacion = {0, 1, 5, 6, 4, 2, 3, 7};
        int esperadoCosto = 43;


        assertArrayEquals(resultado.permutacion, esperadoPermutacion);
        assertEquals(esperadoCosto, resultado.costo);
    }

    @Test
    void testRendimiento_9Elementos() {
        java.util.List<Tablon> tablones = java.util.List.of(
                new Tablon(7, 2, 1),
                new Tablon(5, 3, 4),
                new Tablon(9, 3, 3),
                new Tablon(14, 4, 4),
                new Tablon(10, 3, 3),
                new Tablon(8, 2, 3),
                new Tablon(6, 1, 1),
                new Tablon(12, 5, 4),
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

        System.out.printf("FuerzaBruta - Tiempo promedio (9 elementos): %.3f ms%n", promedioMs);

        int[] esperadoPermutacion = {1, 5, 6, 2, 4, 3, 7, 8, 0};
        int esperadoCosto = 112;


        assertArrayEquals(esperadoPermutacion, resultado.permutacion);
        assertEquals(esperadoCosto, resultado.costo);
    }

    @Test
    void testRendimiento_9v2Elementos() {
        java.util.List<Tablon> tablones = java.util.List.of(
                new Tablon(8, 2, 2),
                new Tablon(6, 2, 1),
                new Tablon(11, 3, 3),
                new Tablon(13, 5, 4),
                new Tablon(9, 2, 2),
                new Tablon(10, 3, 3),
                new Tablon(7, 2, 2),
                new Tablon(12, 4, 4),
                new Tablon(5, 1, 1)
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

        System.out.printf("FuerzaBruta - Tiempo promedio (9 elementos v2): %.3f ms%n", promedioMs);

        int[] esperadoPermutacion = {0, 4, 8, 6, 5, 7, 2, 3, 1};
        int esperadoCosto = 80;

        assertArrayEquals(esperadoPermutacion, resultado.permutacion);
        assertEquals(esperadoCosto, resultado.costo);
    }



    @Test
    void testCasoJuguete_10Elementos() {
        java.util.List<Tablon> tablones = java.util.List.of(
                new Tablon(10, 3, 4),
                new Tablon(5, 3, 3),
                new Tablon(2, 2, 1),
                new Tablon(8, 1, 1),
                new Tablon(6, 4, 2),
                new Tablon(7, 2, 2),
                new Tablon(4, 1, 1),
                new Tablon(9, 3, 3),
                new Tablon(3, 2, 1),
                new Tablon(11, 4, 4)
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

        System.out.printf("FuerzaBruta - Tiempo promedio (10 elementos): %.3f ms%n", promedioMs);

        int[] esperadoPermutacion = {1, 6, 3, 5, 0, 7, 9, 2, 8, 4};
        int esperadoCosto = 109;

        assertArrayEquals(esperadoPermutacion, resultado.permutacion);
        assertEquals(esperadoCosto, resultado.costo);
    }


    @Test
    void testCasoJuguete_10v2Elementos() {
        java.util.List<Tablon> tablones = java.util.List.of(
                new Tablon(7, 2, 2),
                new Tablon(5, 1, 1),
                new Tablon(9, 3, 3),
                new Tablon(14, 4, 4),
                new Tablon(11, 3, 3),
                new Tablon(8, 2, 2),
                new Tablon(6, 1, 1),
                new Tablon(10, 3, 3),
                new Tablon(12, 4, 4),
                new Tablon(13, 2, 2)
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

        System.out.printf("FuerzaBruta - Tiempo promedio (10 elementos v2): %.3f ms%n", promedioMs);

        int[] esperadoPermutacion = {0, 1, 5, 6, 2, 4, 3, 7, 8, 9};
        int esperadoCosto = 106;

        assertArrayEquals(esperadoPermutacion, resultado.permutacion);
        assertEquals(esperadoCosto, resultado.costo);
    }





}
