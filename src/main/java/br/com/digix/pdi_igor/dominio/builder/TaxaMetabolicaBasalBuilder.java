package br.com.digix.pdi_igor.dominio.builder;

import br.com.digix.pdi_igor.dominio.Genero;
import br.com.digix.pdi_igor.dominio.NivelAtividade;
import lombok.Builder;

@Builder
public class TaxaMetabolicaBasalBuilder {
    private double peso;
    private double altura;
    private int idade;
    private Genero genero;
    private NivelAtividade nivelAtividade;
    private Double percentualGordura;
    private double taxaBasal;
    private String formulaUsada;
}
