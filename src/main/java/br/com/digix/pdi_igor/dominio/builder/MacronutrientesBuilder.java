package br.com.digix.pdi_igor.dominio.builder;

import br.com.digix.pdi_igor.dominio.Objetivo;
import br.com.digix.pdi_igor.dominio.TaxaMetabolicaBasal;
import lombok.Builder;

@Builder
public class MacronutrientesBuilder {

    private TaxaMetabolicaBasal tmb;
    private Objetivo objetivo;
    private double carboidratos;
    private double proteinas;
    private double gorduras;
}
