package br.com.digix.pdi_igor.infra.dtos;

import br.com.digix.pdi_igor.dominio.Objetivo;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MacronutrientesCalculadosDTO {
    private final double calorias;
    private final double proteinas;
    private final double carboidratos;
    private final double gorduras;
    private final Objetivo objetivo;
}
