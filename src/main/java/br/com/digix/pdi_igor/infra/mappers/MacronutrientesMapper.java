package br.com.digix.pdi_igor.infra.mappers;

import br.com.digix.pdi_igor.dominio.entidades.Macronutrientes;
import br.com.digix.pdi_igor.infra.dtos.MacronutrientesCalculadosDTO;
import br.com.digix.pdi_igor.infra.dtos.MacronutrientesResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class MacronutrientesMapper implements IMacronutrientesMapper {

    @Override
    public Macronutrientes toEntity(MacronutrientesCalculadosDTO dto) {
        return new Macronutrientes(
                null, // ID será gerado pelo banco
                dto.getCalorias(),
                dto.getProteinas(),
                dto.getCarboidratos(),
                dto.getGorduras(),
                dto.getObjetivo()
        );
    }

    @Override
    public MacronutrientesResponseDTO toResponse(Macronutrientes entity) {
        return new MacronutrientesResponseDTO(
                entity.getCalorias(),
                entity.getProteinas(),
                entity.getCarboidratos(),
                entity.getGorduras(),
                entity.getObjetivo()
        );
    }
}
