package edu.univalle.riegooptimo.modelo;

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
    public double calcularCostoRiego(int[] programacion) {
        if (programacion.length != tablones.size()) {
            throw new IllegalArgumentException("La programación debe tener el mismo tamaño que el número de tablones");
        }
        
        double costoTotal = 0.0;
        int tiempoInicio = 0;
        
        for (int j = 0; j < programacion.length; j++) {
            int indiceTablon = programacion[j];
            Tablon tablon = tablones.get(indiceTablon);
            
            // Tiempo de finalización del riego para este tablón
            int tiempoFinalizacion = tiempoInicio + tablon.getrReg();
            
            // Costo por sufrimiento: pᵢ * max(0, (t_Πᵢ + trᵢ) - tsᵢ)
            int sufrimiento = Math.max(0, tiempoFinalizacion - tablon.getTs_i());
            double costoTablon = tablon.getPrio()* sufrimiento;
            
            costoTotal += costoTablon;
            
            // El siguiente tablón empieza cuando termina este
            tiempoInicio = tiempoFinalizacion;
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

