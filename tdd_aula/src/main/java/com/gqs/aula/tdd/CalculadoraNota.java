package com.gqs.aula.tdd;

public class CalculadoraNota {
    public static final double NOTA_MINIMA_APROVACAO = 70;
    public static final double FREQUENCIA_MINIMA = 75;
    public static final double PONTOS_MINIMOS_PARA_AI = 40;
    public static final double NOTA_MAXIMA_AI = 30;

    private static final String SITUACAO_APROVADO = "APROVADO";
    private static final String SITUACAO_REPROVADO_POR_FALTA = "REPROVADO POR FALTA";
    private static final String SITUACAO_REPROVADO_POR_NOTA = "REPROVADO POR NOTA";

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
        if (frequencia < FREQUENCIA_MINIMA) {
            return SITUACAO_REPROVADO_POR_FALTA;
        }
        if (!estaAprovadoPorNota(notaFinal)) {
            return SITUACAO_REPROVADO_POR_NOTA;
        }
        return SITUACAO_APROVADO;
    }

    public boolean podeFazerAI(double a1, double a2, double a3, double frequencia) {
        double notaFinal = calcularNotaFinal(a1, a2, a3);
        return !estaAprovadoPorNota(notaFinal)
                && frequencia >= FREQUENCIA_MINIMA
                && (a1 + a3 >= PONTOS_MINIMOS_PARA_AI
                || a2 + a3 >= PONTOS_MINIMOS_PARA_AI);
    }

    public double aplicarAI(double a1, double a2, double a3, double notaAI) {
        validarNota(notaAI, NOTA_MAXIMA_AI, "AI");
        double notaFinal = calcularNotaFinal(a1, a2, a3);
        double menorNota = Math.min(a1, a2);

        if (notaAI > menorNota) {
            return notaFinal - menorNota + notaAI;
        }
        return notaFinal;
    }

    private void validarNota(double nota, double notaMaxima, String nomeAvaliacao) {
        if (nota < 0 || nota > notaMaxima) {
            throw new IllegalArgumentException(
                    nomeAvaliacao + " deve estar entre 0 e " + notaMaxima);
        }
    }
}
