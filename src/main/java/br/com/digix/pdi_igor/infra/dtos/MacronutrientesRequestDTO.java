package br.com.digix.pdi_igor.infra.dtos;

import br.com.digix.pdi_igor.dominio.Genero;
import br.com.digix.pdi_igor.dominio.NivelAtividade;
import br.com.digix.pdi_igor.dominio.Objetivo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class MacronutrientesRequestDTO {
    @NotNull
    private double peso;

    @NotNull
    private double altura;

    @NotNull
    @Min(0)
    private int idade;

    @NotNull
    private Genero genero;

    @NotNull
    private NivelAtividade nivelAtividade;

    private double percentualDeGordura; // Opcional

    @NotNull
    private Objetivo objetivo; // Incluído no request
}