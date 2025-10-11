package edu.univalle.riegooptimo.algoritmos;
import edu.univalle.riegooptimo.modelo.Finca;
import edu.univalle.riegooptimo.modelo.Tablon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FuerzaBruta {

    public Object resolver() {
        Finca finca;
        try {
            String ruta = getClass().getClassLoader().getResource("Finca1.txt").getPath();
            finca = Finca.cargarDesdeArchivo(ruta);
        } catch (Exception e) {
            throw new RuntimeException("Error leyendo el archivo: " + e.getMessage());
        }

        List<List<Integer>> fincas = new ArrayList<>();
        for (Tablon t : finca.getTablones()) {
            fincas.add(Arrays.asList(t.getTs_i(), t.getrReg(), t.getPrio()));
        }

//        System.out.println("Fincas originales:");
//        System.out.println(fincas);

        // Generar todas las permutaciones posibles
        List<List<List<Integer>>> permutaciones = generarPermutaciones(fincas);

        int mejorCosto = Integer.MAX_VALUE;
        List<List<Integer>> mejorPerm = null;

        // Recorremos cada posible orden de riego
        for (List<List<Integer>> perm : permutaciones) {
            int costo = finca.calcularCostoRiego(perm);

//            System.out.println("\nOrden: " + perm);
//            System.out.println("Costo total: " + costo);

            if (costo < mejorCosto) {
                mejorCosto = costo;
                mejorPerm = new ArrayList<>(perm);
            }
        }

        System.out.println("\nMejor orden encontrado:");
        System.out.println(mejorPerm);
        System.out.println("Costo mínimo: " + mejorCosto);

        return mejorPerm;
    }

    // Genera todas las permutaciones de la lista original
    public List<List<List<Integer>>> generarPermutaciones(List<List<Integer>> fincas) {
        List<List<List<Integer>>> resultado = new ArrayList<>();
        permutar(fincas, 0, resultado);
        return resultado;
    }

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

    public static void main(String[] args) {
        new FuerzaBruta().resolver();
    }
}
