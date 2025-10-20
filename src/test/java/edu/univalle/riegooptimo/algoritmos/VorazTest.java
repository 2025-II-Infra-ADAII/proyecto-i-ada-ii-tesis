package edu.univalle.riegooptimo.algoritmos;

import edu.univalle.riegooptimo.modelo.Finca;
import edu.univalle.riegooptimo.modelo.Tablon;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VorazTest {

        private final Voraz voraz = new Voraz();

        @Test
        void testRendimiento_3Elementos() {
            List<Tablon> tablones = List.of(
                    new Tablon(13, 4, 4),
                    new Tablon(11, 3, 3),
                    new Tablon(8,2,2)
            );

            Finca finca = new Finca();
            tablones.forEach(finca::agregarTablon);

            long tiempoTotal = 0;
            Voraz.Resultado resultado = null;


            for (int i = 0; i < 5; i++) {
                long inicio = System.nanoTime();
                resultado = voraz.resolver(finca);
                long fin = System.nanoTime();
                tiempoTotal += (fin - inicio);
            }

            long promedioNs = tiempoTotal / 5;
            double promedioMs = promedioNs / 1_000_000.0;

            System.out.printf("Tiempo promedio (3 elementos): %.3f ms%n", promedioMs);

            int[] esperadoPermutacion = {2,1,0};
            int esperadoCosto = 0;

            assertArrayEquals(esperadoPermutacion, resultado.permutacion);
            assertEquals(esperadoCosto, resultado.costo);

        }

        @Test
        void testRendimiento_3v2Elementos() {
            List<Tablon> tablones = List.of(
                    new Tablon(5, 1, 1),
                    new Tablon(9, 3, 2),
                    new Tablon(11, 4, 3)
            );

            Finca finca = new Finca();
            tablones.forEach(finca::agregarTablon);

            long tiempoTotal = 0;
            Voraz.Resultado resultado = null;


            for (int i = 0; i < 5; i++) {
                long inicio = System.nanoTime();
                resultado = voraz.resolver(finca);
                long fin = System.nanoTime();
                tiempoTotal += (fin - inicio);
            }

            long promedioNs = tiempoTotal / 5;
            double promedioMs = promedioNs / 1_000_000.0;

            System.out.printf("Tiempo promedio (3 elementos v2): %.3f ms%n", promedioMs);

            int[] esperadoPermutacion = {0,2,1};
            int esperadoCosto = 0;

            assertArrayEquals(esperadoPermutacion, resultado.permutacion);
            assertEquals(esperadoCosto, resultado.costo);

        }

        @Test
        void testRendimiento_5Elementos() {
            List<Tablon> tablones = List.of(
                    new Tablon(10, 3, 4),
                    new Tablon(5, 3, 3),
                    new Tablon(2, 2, 1),
                    new Tablon(8, 1, 1),
                    new Tablon(6, 4, 2)
            );

            Finca finca = new Finca();
            tablones.forEach(finca::agregarTablon);

            long tiempoTotal = 0;
            Voraz.Resultado resultado = null;


            for (int i = 0; i < 5; i++) {
                long inicio = System.nanoTime();
                resultado = voraz.resolver(finca);
                long fin = System.nanoTime();
                tiempoTotal += (fin - inicio);
            }

            long promedioNs = tiempoTotal / 5;
            double promedioMs = promedioNs / 1_000_000.0;

            System.out.printf("Tiempo promedio (5 elementos): %.3f ms%n", promedioMs);

            int[] esperadoPermutacion = {0, 1, 3, 2, 4};
            int esperadoCosto = 24;

            assertArrayEquals(esperadoPermutacion, resultado.permutacion);
            assertEquals(esperadoCosto, resultado.costo);

        }

        @Test
        void testRendimiento_5v2Elementos() {
            List<Tablon> tablones = List.of(
                    new Tablon(13, 3, 4),
                    new Tablon(8, 2, 2),
                    new Tablon(6, 1, 1),
                    new Tablon(10, 4, 4),
                    new Tablon(12, 3, 3)
            );

            Finca finca = new Finca();
            tablones.forEach(finca::agregarTablon);

            long tiempoTotal = 0;
            Voraz.Resultado resultado = null;


            for (int i = 0; i < 5; i++) {
                long inicio = System.nanoTime();
                resultado = voraz.resolver(finca);
                long fin = System.nanoTime();
                tiempoTotal += (fin - inicio);
            }

            long promedioNs = tiempoTotal / 5;
            double promedioMs = promedioNs / 1_000_000.0;

            System.out.printf("Tiempo promedio (5 elementos v2): %.3f ms%n", promedioMs);

            int[] esperadoPermutacion = {0, 2, 1, 3, 4};
            int esperadoCosto = 3;

            assertArrayEquals(esperadoPermutacion, resultado.permutacion);
            assertEquals(esperadoCosto, resultado.costo);

        }

        @Test
        void testCasoJuguete_10Elementos() {
            List<Tablon> tablones = List.of(
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
            Voraz.Resultado resultado = null;


            for (int i = 0; i < 5; i++) {
                long inicio = System.nanoTime();
                resultado = voraz.resolver(finca);
                long fin = System.nanoTime();
                tiempoTotal += (fin - inicio);
            }

            long promedioNs = tiempoTotal / 5;
            double promedioMs = promedioNs / 1_000_000.0;

            System.out.printf("Tiempo promedio (10 elementos): %.3f ms%n", promedioMs);

            int[] esperadoPermutacion = {0, 6, 1, 5, 3, 7, 9, 2, 8, 4};
            int esperadoCosto = 121;

            assertArrayEquals(esperadoPermutacion, resultado.permutacion);
            assertEquals(esperadoCosto, resultado.costo);
        }

        @Test
        void testCasoJuguete_10v2Elementos() {
            List<Tablon> tablones = List.of(
                    new Tablon(7, 2, 2),
                    new Tablon(5, 1, 1),
                    new Tablon(9, 3, 3),
                    new Tablon(14, 4, 4),
                    new Tablon(11, 3, 3),
                    new Tablon(8, 2, 2),
                    new Tablon(6, 1, 1),
                    new Tablon(10, 3, 3),
                    new Tablon(12, 4, 4),
                    new Tablon(7, 2, 2)
            );

            Finca finca = new Finca();
            tablones.forEach(finca::agregarTablon);

            long tiempoTotal = 0;
            Voraz.Resultado resultado = null;


            for (int i = 0; i < 5; i++) {
                long inicio = System.nanoTime();
                resultado = voraz.resolver(finca);
                long fin = System.nanoTime();
                tiempoTotal += (fin - inicio);
            }

            long promedioNs = tiempoTotal / 5;
            double promedioMs = promedioNs / 1_000_000.0;

            System.out.printf("Tiempo promedio (10 elementos v2): %.3f ms%n", promedioMs);

            int[] esperadoPermutacion = {1, 6, 0, 9, 5, 2, 7, 4, 8, 3};
            int esperadoCosto = 116;

            assertArrayEquals(esperadoPermutacion, resultado.permutacion);
            assertEquals(esperadoCosto, resultado.costo);
        }

        @Test
        void testRendimiento_15Elementos() {
            List<Tablon> tablones = List.of(
                    new Tablon(7, 2, 2),
                    new Tablon(4, 1, 1),
                    new Tablon(9, 3, 3),
                    new Tablon(3, 2, 1),
                    new Tablon(11, 4, 4),
                    new Tablon(12, 2, 3),
                    new Tablon(5, 1, 1),
                    new Tablon(8, 3, 2),
                    new Tablon(10, 4, 4),
                    new Tablon(7, 3, 2),
                    new Tablon(9, 2, 3),
                    new Tablon(6, 2, 2),
                    new Tablon(4, 1, 1),
                    new Tablon(13, 3, 4),
                    new Tablon(11, 4, 3)
            );

            Finca finca = new Finca();
            tablones.forEach(finca::agregarTablon);

            long tiempoTotal = 0;
            Voraz.Resultado resultado = null;


            for (int i = 0; i < 5; i++) {
                long inicio = System.nanoTime();
                resultado = voraz.resolver(finca);
                long fin = System.nanoTime();
                tiempoTotal += (fin - inicio);
            }

            long promedioNs = tiempoTotal / 5;
            double promedioMs = promedioNs / 1_000_000.0;

            System.out.printf("Tiempo promedio (15 elementos): %.3f ms%n", promedioMs);

            int[] esperadoPermutacion = {10, 5, 13, 1, 12, 6, 11, 0, 2, 8, 4, 14, 9, 7, 3};
            int esperadoCosto = 356;

            assertArrayEquals(esperadoPermutacion, resultado.permutacion);
            assertEquals(esperadoCosto, resultado.costo);
        }

        @Test
        void testRendimiento_15v2Elementos() {
            List<Tablon> tablones = List.of(
                    new Tablon(7, 2, 2),
                    new Tablon(5, 1, 1),
                    new Tablon(9, 3, 3),
                    new Tablon(14, 4, 4),
                    new Tablon(11, 3, 3),
                    new Tablon(8, 2, 2),
                    new Tablon(6, 1, 1),
                    new Tablon(10, 3, 3),
                    new Tablon(12, 4, 4),
                    new Tablon(7, 2, 2),
                    new Tablon(5, 1, 1),
                    new Tablon(9, 3, 2),
                    new Tablon(13, 4, 4),
                    new Tablon(11, 3, 3),
                    new Tablon(8, 2, 2)
            );

            Finca finca = new Finca();
            tablones.forEach(finca::agregarTablon);

            long tiempoTotal = 0;
            Voraz.Resultado resultado = null;


            for (int i = 0; i < 5; i++) {
                long inicio = System.nanoTime();
                resultado = voraz.resolver(finca);
                long fin = System.nanoTime();
                tiempoTotal += (fin - inicio);
            }

            long promedioNs = tiempoTotal / 5;
            double promedioMs = promedioNs / 1_000_000.0;

            System.out.printf("Tiempo promedio (15 elementos v2): %.3f ms%n", promedioMs);

            int[] esperadoPermutacion = {1, 10, 6, 0, 9, 5, 14, 2, 7, 4, 13, 8, 12, 3, 11};
            int esperadoCosto = 381;

            assertArrayEquals(esperadoPermutacion, resultado.permutacion);
            assertEquals(esperadoCosto, resultado.costo);
        }

        @Test
        void testRendimiento_20Elementos() {
            List<Tablon> tablones = List.of(
                    new Tablon(15, 3, 4),
                    new Tablon(9, 2, 2),
                    new Tablon(10, 3, 3),
                    new Tablon(12, 4, 4),
                    new Tablon(8, 2, 2),
                    new Tablon(7, 1, 1),
                    new Tablon(5, 2, 2),
                    new Tablon(14, 4, 4),
                    new Tablon(6, 1, 1),
                    new Tablon(9, 3, 2),
                    new Tablon(4, 2, 1),
                    new Tablon(10, 3, 3),
                    new Tablon(8, 2, 2),
                    new Tablon(13, 4, 4),
                    new Tablon(11, 3, 3),
                    new Tablon(9, 2, 2),
                    new Tablon(7, 1, 1),
                    new Tablon(15, 4, 4),
                    new Tablon(6, 2, 2),
                    new Tablon(10, 3, 3)
            );

            Finca finca = new Finca();
            tablones.forEach(finca::agregarTablon);

            long tiempoTotal = 0;
            Voraz.Resultado resultado = null;


            for (int i = 0; i < 5; i++) {
                long inicio = System.nanoTime();
                resultado = voraz.resolver(finca);
                long fin = System.nanoTime();
                tiempoTotal += (fin - inicio);
            }

            long promedioNs = tiempoTotal / 5;
            double promedioMs = promedioNs / 1_000_000.0;

            System.out.printf("Tiempo promedio (20 elementos): %.3f ms%n", promedioMs);

            int[] esperadoPermutacion = {0, 6, 8, 18, 5, 16, 4, 12, 1, 15, 2, 11, 19, 14, 3, 13, 7, 17, 9, 10};
            int esperadoCosto = 795;

            assertArrayEquals(esperadoPermutacion, resultado.permutacion);
            assertEquals(esperadoCosto, resultado.costo);
        }

        @Test
        void testRendimiento_20v2Elementos() {
            List<Tablon> tablones = List.of(
                    new Tablon(8, 2, 1),
                    new Tablon(5, 1, 1),
                    new Tablon(12, 4, 4),
                    new Tablon(7, 2, 2),
                    new Tablon(9, 3, 3),
                    new Tablon(11, 3, 3),
                    new Tablon(6, 2, 2),
                    new Tablon(10, 4, 4),
                    new Tablon(8, 2, 2),
                    new Tablon(7, 1, 1),
                    new Tablon(5, 3, 2),
                    new Tablon(14, 4, 4),
                    new Tablon(9, 2, 2),
                    new Tablon(11, 3, 3),
                    new Tablon(13, 4, 4),
                    new Tablon(8, 2, 2),
                    new Tablon(6, 1, 1),
                    new Tablon(10, 3, 3),
                    new Tablon(12, 4, 4),
                    new Tablon(7, 2, 2)
            );

            Finca finca = new Finca();
            tablones.forEach(finca::agregarTablon);

            long tiempoTotal = 0;
            Voraz.Resultado resultado = null;


            for (int i = 0; i < 5; i++) {
                long inicio = System.nanoTime();
                resultado = voraz.resolver(finca);
                long fin = System.nanoTime();
                tiempoTotal += (fin - inicio);
            }

            long promedioNs = tiempoTotal / 5;
            double promedioMs = promedioNs / 1_000_000.0;

            System.out.printf("Tiempo promedio (20 elementos v2): %.3f ms%n", promedioMs);

            int[] esperadoPermutacion = {1, 6, 16, 3, 9, 19, 8, 15, 4, 12, 7, 17, 5, 13, 2, 18, 14, 11, 10, 0};
            int esperadoCosto = 849;

            assertArrayEquals(esperadoPermutacion, resultado.permutacion);
            assertEquals(esperadoCosto, resultado.costo);
        }

}
