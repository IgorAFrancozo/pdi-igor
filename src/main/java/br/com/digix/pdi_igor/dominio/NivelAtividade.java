package br.com.digix.pdi_igor.dominio;

import lombok.Getter;

@Getter
public enum NivelAtividade {
    SEDENTARIO("Sedentário", 1.2),
    LEVE("Leve - 1 a 2 dias por semana", 1.375),
    MODERADO("Moderado - 3 a 5 dias por semana", 1.55),
    PESADO("Pesado - 6 a 7 dias por semana", 1.725),
    ATLETA("Atleta - 2x por dia", 1.9);

    private final String descricao;
    private final double fator;

    NivelAtividade(String descricao, double fator) {
        this.descricao = descricao;
        this.fator = fator;
    }
}