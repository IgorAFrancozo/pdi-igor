package br.com.digix.pdi_igor.infra.dtos;

import br.com.digix.pdi_igor.dominio.Objetivo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MacronutrientesResponseDTO {
    private double calorias;
    private double proteinas;
    private double carboidratos;
    private double gorduras;
    private Objetivo objetivo;
}
