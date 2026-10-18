package com.gqs.aula.tdd;

public class CalculadoraNota {
    public static final double NOTA_MINIMA_APROVACAO = 70;
    public static final double FREQUENCIA_MINIMA = 75;

    public double calcularNotaFinal(double a1, double a2, double a3) {
        validarNota(a1, 30, "A1");
        validarNota(a2, 30, "A2");
        validarNota(a3, 40, "A3");
        return a1 + a2 + a3;
    }

    public boolean estaAprovadoPorNota(double notaFinal) {
        return notaFinal >= NOTA_MINIMA_APROVACAO;
    }

    public String situacao(double notaFinal, double frequencia) {
        if (estaAprovadoPorNota(notaFinal) && frequencia >= FREQUENCIA_MINIMA) {
            return "APROVADO";
        }
        return "REPROVADO";
    }

    public boolean podeFazerAI(double a1, double a2, double a3, double frequencia) {
        return false;
    }

    private void validarNota(double nota, double notaMaxima, String nomeAvaliacao) {
        if (nota < 0 || nota > notaMaxima) {
            throw new IllegalArgumentException(
                    nomeAvaliacao + " deve estar entre 0 e " + notaMaxima);
        }
    }
}
