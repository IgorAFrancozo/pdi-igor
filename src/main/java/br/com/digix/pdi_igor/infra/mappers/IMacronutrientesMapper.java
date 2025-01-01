package br.com.digix.pdi_igor.infra.mappers;

import br.com.digix.pdi_igor.dominio.entidades.Macronutrientes;
import br.com.digix.pdi_igor.infra.dtos.MacronutrientesCalculadosDTO;
import br.com.digix.pdi_igor.infra.dtos.MacronutrientesResponseDTO;

public interface IMacronutrientesMapper {

    Macronutrientes paraEntidade(MacronutrientesCalculadosDTO macronutrientesCalculadosDTO);

    MacronutrientesResponseDTO paraResponse(Macronutrientes macronutrientes);
}
