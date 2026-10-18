package com.gqs.aula.tdd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalculadoraNotaTest {
    @Test
    void deveSomarAsTresNotas() {
        CalculadoraNota calc = new CalculadoraNota();
        double resultado = calc.calcularNotaFinal(20, 20, 30);

        assertEquals(70, resultado);
    }
}
