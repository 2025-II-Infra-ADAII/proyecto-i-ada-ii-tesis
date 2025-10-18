package edu.univalle.riegooptimo.algoritmos;

import edu.univalle.riegooptimo.modelo.Finca;
import edu.univalle.riegooptimo.modelo.Tablon;

import java.util.*;

/**
 * Algoritmo Voraz WSPT (Weighted Shortest Processing Time) para el Problema de Riego Óptimo.
 * 
 * Estrategia: Ordenar tablones por ratio p/tr (descendente)
 * - Mayor ratio = mayor prioridad / menor tiempo = regar primero
 * 
 * Complejidad:
 *   - Tiempo: O(n log n)
 *   - Espacio: O(n)
 * 
 * NOTA: Esta solución NO garantiza optimalidad pero da buenos resultados en la práctica.
 * 
 */
public class Voraz {
    
    /**
     * Clase interna para almacenar tablón con su ratio
     */
    private static class TablonConRatio {
        int indice;
        double ratio;  // p_i / tr_i
        int ts;        // Para desempate (más urgente primero)
        int tr;
        int p;
        
        TablonConRatio(int indice, int ts, int tr, int p) {
            this.indice = indice;
            this.ts = ts;
            this.tr = tr;
            this.p = p;
            this.ratio = (double) p / tr;  // Ratio WSPT: prioridad / tiempo
        }
    }
    
    /**
     * Clase para retornar el resultado
     */
    public static class Resultado {
        public final int[] permutacion; // Orden de riego
        public final int costo;         // Costo total (no necesariamente óptimo)
        
        public Resultado(int[] permutacion, int costo) {
            this.permutacion = permutacion;
            this.costo = costo;
        }
        
        @Override
        public String toString() {
            return String.format("Permutación: %s, Costo: %d", 
                               Arrays.toString(permutacion), costo);
        }
    }
    
    /**
     * Resuelve el problema usando el algoritmo Voraz WSPT
     * 
     * @param finca La finca con los tablones a regar
     * @return Resultado con la solución voraz y su costo
     */
    public Resultado resolver(Finca finca) {
        if (finca == null || finca.estaVacia()) {
            return new Resultado(new int[0], 0);
        }
        
        List<Tablon> tablones = finca.getTablones();
        int n = tablones.size();
        
        // Caso especial: solo 1 tablón
        if (n == 1) {
            Tablon t = tablones.get(0);
            int costo = t.getPrio() * Math.max(0, t.getrReg() - t.getTs_i());
            return new Resultado(new int[]{0}, costo);
        }
        
        // Calcular ratio p/tr para cada tablón
        List<TablonConRatio> tablonesConRatio = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Tablon t = tablones.get(i);
            tablonesConRatio.add(new TablonConRatio(i, t.getTs_i(), t.getrReg(), t.getPrio()));
        }
        
        // Ordenar por ratio DESCENDENTE (mayor ratio primero)
        // En caso de empate, ordenar por ts ASCENDENTE (más urgente primero)
        tablonesConRatio.sort((a, b) -> {
            int comparacionRatio = Double.compare(b.ratio, a.ratio); // Descendente
            if (comparacionRatio != 0) {
                return comparacionRatio;
            }
            return Integer.compare(a.ts, b.ts); // Ascendente (desempate)
        });
        
        // Extraer permutación ordenada
        int[] permutacion = new int[n];
        for (int i = 0; i < n; i++) {
            permutacion[i] = tablonesConRatio.get(i).indice;
        }
        
        // Calcular costo de la solución voraz
        int costo = calcularCosto(tablones, permutacion);
        
        return new Resultado(permutacion, costo);
    }
    
    /**
     * Calcula el costo total CRF_Π de una permutación
     * 
     * @param tablones Lista de tablones
     * @param permutacion Orden de riego
     * @return Costo total (suma de penalizaciones)
     */
    private int calcularCosto(List<Tablon> tablones, int[] permutacion) {
        int costoTotal = 0;
        int tiempoActual = 0;
        
        for (int idx : permutacion) {
            Tablon t = tablones.get(idx);
            
            // Tiempo de fin del riego
            int tFin = tiempoActual + t.getrReg();
            
            // Penalización si termina después del tiempo de supervivencia
            int penalizacion = t.getPrio() * Math.max(0, tFin - t.getTs_i());
            
            costoTotal += penalizacion;
            tiempoActual = tFin;
        }
        
        return costoTotal;
    }
    
   
}