package edu.univalle.riegooptimo;

import edu.univalle.riegooptimo.algoritmos.Dinamica;
import edu.univalle.riegooptimo.algoritmos.FuerzaBruta;
import edu.univalle.riegooptimo.modelo.Finca;
import edu.univalle.riegooptimo.modelo.Tablon;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Cargar finca desde archivo
            String ruta = Main.class.getClassLoader()
                                   .getResource("Finca3.txt")
                                   .getPath();
            Finca finca = Finca.cargarDesdeArchivo(ruta);
            
            
            System.out.println("║   PROBLEMA DE RIEGO OPTIMO - SOLUCIONES   ║");
            System.out.println();
            System.out.println(finca);
            
            // ==========================================
            // 1. FUERZA BRUTA
            // ==========================================
            System.out.println("\n" + "═".repeat(50));
            System.out.println("1. FUERZA BRUTA");
            System.out.println("═".repeat(50));
            
            FuerzaBruta fb = new FuerzaBruta();
            long inicioFB = System.nanoTime();
            Object resultadoFB = fb.resolver(finca);
            long finFB = System.nanoTime();

            System.out.printf("Tiempo de ejecucion: %.3f ms%n",
                            (finFB - inicioFB) / 1_000_000.0);
            
            // ==========================================
            // 2. PROGRAMACIÓN DINÁMICA
            // ==========================================
            System.out.println("\n" + "═".repeat(50));
            System.out.println("2. PROGRAMACION DINAMICA");
            System.out.println("═".repeat(50));
            
            Dinamica dp = new Dinamica();
            long inicioDP = System.nanoTime();
            Dinamica.Resultado resultadoDP = dp.resolver(finca);
            long finDP = System.nanoTime();
            
            System.out.println("\nResultado:");
            System.out.println(resultadoDP);
            System.out.printf("Tiempo de ejecucion: %.3f ms%n", 
                            (finDP - inicioDP) / 1_000_000.0);
            
            // Verificar costo calculando manualmente
            List<Tablon> tablones = finca.getTablones();
            int tiempoAcumulado = 0;
            int costoVerificacion = 0;
            
            System.out.println("\nDetalles del riego:");
            for (int i = 0; i < resultadoDP.permutacion.length; i++) {
                int idx = resultadoDP.permutacion[i];
                Tablon t = tablones.get(idx);
                
                int tFin = tiempoAcumulado + t.getrReg();
                int penalizacion = t.getPrio() * Math.max(0, tFin - t.getTs_i());
                costoVerificacion += penalizacion;
                
                System.out.printf("  Paso %d: Regar tablón %d %s | " +
                                "Inicio=%d, Fin=%d, Penalizacion=%d%n",
                                i + 1, idx, t, tiempoAcumulado, tFin, penalizacion);
                
                tiempoAcumulado = tFin;
            }
            
            System.out.println("\nVerificacion:");
            System.out.println("  Costo calculado = " + costoVerificacion);
            System.out.println("  Costo DP        = " + resultadoDP.costo);
            
            if (costoVerificacion == resultadoDP.costo) {
                System.out.println("  Estado: Todo melo");
            } else {
                System.out.println("  Estado: Valimos monda");
            }
            
            // ==========================================
            // 3. COMPARACIÓN DE RESULTADOS
            // ==========================================
            System.out.println("\n" + "═".repeat(50));
            System.out.println("3. COMPARACIÓN DE TIEMPOS");
            System.out.println("═".repeat(50));
            
            double tiempoFB = (finFB - inicioFB) / 1_000_000.0;
            double tiempoDP = (finDP - inicioDP) / 1_000_000.0;
            
            System.out.printf("  Fuerza Bruta: %.3f ms%n", tiempoFB);
            System.out.printf("  Prog. Dinamica: %.3f ms%n", tiempoDP);
            System.out.printf("  Speedup: %.2fx%n", tiempoFB / tiempoDP);
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}