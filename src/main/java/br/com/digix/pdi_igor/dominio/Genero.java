package br.com.digix.pdi_igor.dominio;

import lombok.Getter;

@Getter
public enum Genero {
    MASCULINO(5),
    FEMININO(-151);

    private final int constanteFormula;

    Genero(int constanteFormula) {
        this.constanteFormula = constanteFormula;
    }
}
