package br.com.digix.pdi_igor.dominio;

import lombok.Getter;

@Getter
public enum Objetivo {
    MANUTENCAO("Manutenção do peso"),
    CUTTING("Cutting (Perda de peso)"),
    BULKING("Bulking (Ganho de peso)");

    private final String descricao;

    Objetivo(String descricao) {
        this.descricao = descricao;
    }
}