package edu.univalle.riegooptimo.algoritmos;

import edu.univalle.riegooptimo.modelo.Finca;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class FuerzaBrutaTest {

    @Test
    void resolver_debeRetornarNull_porAhora() {
        FuerzaBruta fb = new FuerzaBruta();
        Object res = fb.resolver(new Finca());
        assertNull(res);
    }
}
