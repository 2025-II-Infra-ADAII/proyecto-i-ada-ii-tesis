package edu.univalle.riegooptimo.algoritmos;

import edu.univalle.riegooptimo.modelo.Finca;
import edu.univalle.riegooptimo.modelo.Tablon;

import java.util.*;

/**
 * Solución de Programación Dinámica para el Problema de Riego Óptimo.
 * 
 * Usa máscaras de bits para representar subconjuntos de tablones.
 * DP[S] = costo mínimo de regar exactamente los tablones del conjunto S
 * 
 * Complejidad:
 *   - Tiempo: O(n * 2^n)
 *   - Espacio: O(2^n)
 */
public class Dinamica {
    
    /**
     * Clase interna para almacenar el estado de cada subproblema
     */
    private static class Estado {
        int costo;           // Costo mínimo acumulado
        int tiempoAcumulado; // Tiempo total de riego hasta ahora
        
        Estado(int costo, int tiempoAcumulado) {
            this.costo = costo;
            this.tiempoAcumulado = tiempoAcumulado;
        }
    }
    
    /**
     * Clase para retornar el resultado
     */
    public static class Resultado {
        public final int[] permutacion; // Orden óptimo de riego
        public final int costo;         // Costo mínimo total
        
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
     * Resuelve el problema de riego óptimo usando Programación Dinámica
     * 
     * @param finca La finca con los tablones a regar
     * @return Resultado con la permutación óptima y su costo
     */
    public Resultado resolver(Finca finca) {
        if (finca == null || finca.estaVacia()) {
            return new Resultado(new int[0], 0);
        }
        
        List<Tablon> tablones = finca.getTablones();
        int n = tablones.size();
        
        // Validar que n no sea demasiado grande (máximo 20 para evitar overflow)
        if (n > 20) {
            throw new IllegalArgumentException(
                "Demasiados tablones para DP (" + n + "). Máximo recomendado: 20"
            );
        }
        
        // DP[mask] = estado con costo y tiempo acumulado
        Map<Integer, Estado> dp = new HashMap<>();
        
        // parent[mask] = índice del último tablón agregado para llegar a mask
        Map<Integer, Integer> parent = new HashMap<>();
        
        // Caso base: conjunto vacío
        dp.put(0, new Estado(0, 0));
        
        // Llenar tabla DP (bottom-up)
        int maskFinal = (1 << n) - 1; // Todos los tablones
        
        for (int mask = 0; mask <= maskFinal; mask++) {
            if (!dp.containsKey(mask)) {
                continue;
            }
            
            Estado estadoActual = dp.get(mask);
            int costoActual = estadoActual.costo;
            int tiempoActual = estadoActual.tiempoAcumulado;
            
            // Intentar agregar cada tablón j que no esté incluido
            for (int j = 0; j < n; j++) {
                // Verificar si j ya está en el conjunto
                if ((mask & (1 << j)) != 0) {
                    continue; // j ya está incluido
                }
                
                // Agregar j al conjunto
                int newMask = mask | (1 << j);
                
                // Obtener datos del tablón j
                Tablon tablon = tablones.get(j);
                int ts_j = tablon.getTs_i();
                int tr_j = tablon.getrReg();
                int p_j = tablon.getPrio();
                
                // Calcular costo de agregar j
                int tFinJ = tiempoActual + tr_j;
                int penalizacion = p_j * Math.max(0, tFinJ - ts_j);
                
                int nuevoCosto = costoActual + penalizacion;
                int nuevoTiempo = tiempoActual + tr_j;
                
                // Actualizar si es mejor o es la primera vez que vemos newMask
                if (!dp.containsKey(newMask) || nuevoCosto < dp.get(newMask).costo) {
                    dp.put(newMask, new Estado(nuevoCosto, nuevoTiempo));
                    parent.put(newMask, j);
                }
            }
        }
        
        // Obtener solución óptima
        Estado estadoFinal = dp.get(maskFinal);
        int costoOptimo = estadoFinal.costo;
        
        // Reconstruir permutación (de atrás hacia adelante)
        List<Integer> permutacionList = new ArrayList<>();
        int mask = maskFinal;
        
        while (mask > 0) {
            int j = parent.get(mask);
            permutacionList.add(j);
            mask ^= (1 << j); // Remover j del conjunto
        }
        
        // Invertir para obtener el orden correcto
        Collections.reverse(permutacionList);
        
        // Convertir a array
        int[] permutacion = new int[n];
        for (int i = 0; i < n; i++) {
            permutacion[i] = permutacionList.get(i);
        }
        
        return new Resultado(permutacion, costoOptimo);
    }
    
   
}