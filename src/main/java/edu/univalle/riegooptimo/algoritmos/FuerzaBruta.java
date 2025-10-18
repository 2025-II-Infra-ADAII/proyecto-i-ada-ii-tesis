package edu.univalle.riegooptimo.algoritmos;

import edu.univalle.riegooptimo.modelo.Finca;
import edu.univalle.riegooptimo.modelo.Tablon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FuerzaBruta {

    /**
     * Clase para retornar el resultado
     */
    public static class Resultado {
        public final int[] permutacion; // Orden óptimo de riego (índices)
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
     * Resuelve el problema usando Fuerza Bruta
     * 
     * @param finca La finca con los tablones a regar (recibida desde Main)
     * @return Resultado con la permutación óptima y su costo
     */
    public Resultado resolver(Finca finca) {
        if (finca == null || finca.estaVacia()) {
            return new Resultado(new int[0], 0);
        }

        // Convertir tablones a lista de listas (manteniendo tu estructura)
        List<List<Integer>> fincas = new ArrayList<>();
        for (Tablon t : finca.getTablones()) {
            fincas.add(Arrays.asList(t.getTs_i(), t.getrReg(), t.getPrio()));
        }

        // Generar todas las permutaciones posibles
        List<List<List<Integer>>> permutaciones = generarPermutaciones(fincas);

        int mejorCosto = Integer.MAX_VALUE;
        List<List<Integer>> mejorPerm = null;

        // Recorremos cada posible orden de riego
        for (List<List<Integer>> perm : permutaciones) {
            int costo = finca.calcularCostoRiego(perm);

            if (costo < mejorCosto) {
                mejorCosto = costo;
                mejorPerm = new ArrayList<>(perm);
            }
        }

        // Convertir mejorPerm a array de índices
        int[] permutacionIndices = extraerIndices(mejorPerm, finca.getTablones());

        return new Resultado(permutacionIndices, mejorCosto);
    }

    /**
     * Extrae los índices de la mejor permutación
     */
    private int[] extraerIndices(List<List<Integer>> mejorPerm, List<Tablon> tablones) {
        int[] indices = new int[mejorPerm.size()];
        
        for (int i = 0; i < mejorPerm.size(); i++) {
            List<Integer> tablon = mejorPerm.get(i);
            
            // Buscar el índice del tablón en la lista original
            for (int j = 0; j < tablones.size(); j++) {
                Tablon t = tablones.get(j);
                if (t.getTs_i() == tablon.get(0) && 
                    t.getrReg() == tablon.get(1) && 
                    t.getPrio() == tablon.get(2)) {
                    indices[i] = j;
                    break;
                }
            }
        }
        
        return indices;
    }

    /**
     * Genera todas las permutaciones de la lista original
     */
    public List<List<List<Integer>>> generarPermutaciones(List<List<Integer>> fincas) {
        List<List<List<Integer>>> resultado = new ArrayList<>();
        permutar(fincas, 0, resultado);
        return resultado;
    }

    /**
     * Método recursivo para generar permutaciones
     */
    private void permutar(List<List<Integer>> fincas, int inicio, List<List<List<Integer>>> resultado) {
        if (inicio == fincas.size() - 1) {
            resultado.add(new ArrayList<>(fincas));
        } else {
            for (int i = inicio; i < fincas.size(); i++) {
                Collections.swap(fincas, inicio, i);
                permutar(fincas, inicio + 1, resultado);
                Collections.swap(fincas, inicio, i);
            }
        }
    }
}