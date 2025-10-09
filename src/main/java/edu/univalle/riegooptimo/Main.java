package edu.univalle.riegooptimo;

import edu.univalle.riegooptimo.algoritmos.FuerzaBruta;
import edu.univalle.riegooptimo.modelo.Finca;

public class Main {
    public static void main(String[] args) {
        System.out.println("Proyecto Riego Óptimo iniciado");
        // Ejecución mínima de ejemplo
        new FuerzaBruta().resolver(new Finca());
    }
}
