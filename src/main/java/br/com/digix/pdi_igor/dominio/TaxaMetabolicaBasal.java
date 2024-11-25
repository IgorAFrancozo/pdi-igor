package br.com.digix.pdi_igor.dominio;

import jakarta.persistence.*;

@Entity
public class TaxaMetabolicaBasal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double peso; // em kg
    private double altura; // em cm
    private int idade; // em anos
    @Enumerated(EnumType.STRING)
    private Genero genero; // Enum para masculino/feminino

    @Enumerated(EnumType.STRING)
    private NivelAtividade nivelAtividade; // Enum com fatores de atividade

    private Double percentualGordura; // Opcional para usar a fórmula de Katch-McArdle
    private double taxaBasal; // Valor calculado final (TMB)
    private String formulaUsada;
}
