package edu.univalle.riegooptimo.modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Finca {
    private List<Tablon> tablones;

    public Finca() {
        this.tablones = new ArrayList<>();
    }

    public void agregarTablon(Tablon tablon) {
        tablones.add(tablon);
    }



    public List<Tablon> getTablones() {
        return tablones;
    }

    public Tablon getTablon(int index) {
        return tablones.get(index);
    }

    /**
     * Obtiene el número de tablones en la finca
     */
    public int getNumeroTablones() {
        return tablones.size();
    }
    
    /**
     * Calcula el costo de riego para una programación dada
     * CRF_Π = Σ(i=0 to n-1) CRF_Π[i]
     * donde CRF_Π[i] = pᵢ * max(0, (t_Πᵢ + trᵢ) - tsᵢ)
     */
    public int calcularCostoRiego(List<List<Integer>> perm) {
        int diaActual = 0;
        int costoTotal = 0;

        for (List<Integer> tablon : perm) {
            int supervivencia = tablon.get(0);
            int tiempoRiego = tablon.get(1);
            int prioridad = tablon.get(2);

            int diaInicio = diaActual;
            int diaFin = diaInicio + tiempoRiego;
            diaActual = diaFin; // se actualiza para el siguiente tablón

            int retraso = Math.max(0, diaFin - supervivencia);
            int penalizacion = prioridad * retraso;
            costoTotal += penalizacion;

//            System.out.println("  Tablón " + tablon +
//                    " | Empieza: " + diaInicio +
//                    " | Termina: " + diaFin +
//                    " | Retraso: " + retraso +
//                    " | Penalización: " + penalizacion);
        }

        return costoTotal;
    }
    
    /**
     * Calcula los tiempos de inicio para cada tablón en una programación
     */
    public int[] calcularTiemposInicio(int[] programacion) {
        int[] tiemposInicio = new int[programacion.length];
        int tiempo = 0;
        
        for (int j = 0; j < programacion.length; j++) {
            tiemposInicio[j] = tiempo;
            int indiceTablon = programacion[j];
            tiempo += tablones.get(indiceTablon).getrReg();
        }
        
        return tiemposInicio;
    }
    
    /**
     * Verifica si la finca está vacía
     */
    public boolean estaVacia() {
        return tablones.isEmpty();
    }

    public static Finca cargarDesdeArchivo(String rutaArchivo) throws IOException {
        Finca finca = new Finca();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea = br.readLine();
            if (linea == null)
                throw new IOException("El archivo está vacío.");

            int n = Integer.parseInt(linea.trim());

            for (int i = 0; i < n; i++) {
                linea = br.readLine();
                if (linea == null)
                    throw new IOException("Faltan líneas para completar los " + n + " tablones.");

                String[] partes = linea.split(",");
                if (partes.length != 3)
                    throw new IOException("Formato inválido en la línea " + (i + 2) + ": " + linea);

                int ts = Integer.parseInt(partes[0].trim());
                int tr = Integer.parseInt(partes[1].trim());
                int p = Integer.parseInt(partes[2].trim());

                finca.agregarTablon(new Tablon(ts, tr, p));
            }
        }

        return finca;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Finca con ").append(tablones.size()).append(" tablones:\n");
        for (int i = 0; i < tablones.size(); i++) {
            sb.append("T").append(i).append(": ").append(tablones.get(i)).append("\n");
        }
        return sb.toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Finca finca = (Finca) obj;
        return tablones.equals(finca.tablones);
    }
}

