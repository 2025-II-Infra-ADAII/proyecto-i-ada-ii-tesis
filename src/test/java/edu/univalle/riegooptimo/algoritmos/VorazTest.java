package edu.univalle.riegooptimo.algoritmos;

import edu.univalle.riegooptimo.modelo.Finca;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class VorazTest {

    @Test
    void resolver_debeRetornarNull_porAhora() {
        Voraz algoritmo = new Voraz();
        Object res = algoritmo.resolver(new Finca());
        assertNull(res);
    }
}
