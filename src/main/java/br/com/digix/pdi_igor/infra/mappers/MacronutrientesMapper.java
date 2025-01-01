package br.com.digix.pdi_igor.infra.mappers;

import br.com.digix.pdi_igor.dominio.entidades.Macronutrientes;
import br.com.digix.pdi_igor.infra.dtos.MacronutrientesCalculadosDTO;
import br.com.digix.pdi_igor.infra.dtos.MacronutrientesResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class MacronutrientesMapper implements IMacronutrientesMapper {

    @Override
    public Macronutrientes paraEntidade(MacronutrientesCalculadosDTO macronutrientesCalculadosDTO) {
        return new Macronutrientes(
                null,
                macronutrientesCalculadosDTO.getCalorias(),
                macronutrientesCalculadosDTO.getProteinas(),
                macronutrientesCalculadosDTO.getCarboidratos(),
                macronutrientesCalculadosDTO.getGorduras(),
                macronutrientesCalculadosDTO.getObjetivo()
        );
    }

    @Override
    public MacronutrientesResponseDTO paraResponse(Macronutrientes macronutrientes) {
        return new MacronutrientesResponseDTO(
                macronutrientes.getCalorias(),
                macronutrientes.getProteinas(),
                macronutrientes.getCarboidratos(),
                macronutrientes.getGorduras(),
                macronutrientes.getObjetivo()
        );
    }
}
