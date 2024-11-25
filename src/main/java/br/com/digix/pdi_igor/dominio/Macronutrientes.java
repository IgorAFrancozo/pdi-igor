package br.com.digix.pdi_igor.dominio;

import jakarta.persistence.*;

@Entity
public class Macronutrientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private TaxaMetabolicaBasal tmb;

    @Enumerated(EnumType.STRING)
    private Objetivo objetivo;

    private double carboidratos;
    private double proteinas;
    private double gorduras;

}
