package br.com.digix.pdi_igor.aplicacao;

import br.com.digix.pdi_igor.dominio.Objetivo;
import br.com.digix.pdi_igor.dominio.entidades.Macronutrientes;
import br.com.digix.pdi_igor.infra.dtos.MacronutrientesCalculadosDTO;
import br.com.digix.pdi_igor.infra.dtos.MacronutrientesRequestDTO;
import br.com.digix.pdi_igor.infra.dtos.MacronutrientesResponseDTO;
import br.com.digix.pdi_igor.infra.mappers.IMacronutrientesMapper;
import br.com.digix.pdi_igor.infra.mappers.MacronutrientesMapper;
import org.springframework.stereotype.Service;

@Service
public class CalculaMacronutrientes {

    private final IMacronutrientesMapper mapper;

    public CalculaMacronutrientes(IMacronutrientesMapper mapper) {
        this.mapper = mapper;
    }

    public MacronutrientesResponseDTO calcular(MacronutrientesRequestDTO request, Objetivo objetivo) {
        double tmb;

        // Cálculo da TMB
        if (request.getPercentualDeGordura() > 0) {
            double massaMagra = request.getPeso() - (request.getPeso() * request.getPercentualDeGordura() / 100);
            tmb = 370 + (21.6 * massaMagra);
        } else {
            tmb = (10 * request.getPeso()) +
                    (6.25 * request.getAltura()) -
                    (5 * request.getIdade()) +
                    request.getGenero().getConstanteFormula();
        }

        // Multiplicação pelo fator de atividade
        double calorias = tmb * request.getNivelAtividade().getFator();
        MacronutrientesCalculadosDTO calculados = calcularMacronutrientes(calorias, objetivo);

        // Mapeamento para entidade e resposta
        Macronutrientes entidade = mapper.toEntity(calculados);
        return mapper.toResponse(entidade);
    }

    private MacronutrientesCalculadosDTO calcularMacronutrientes(double calorias, Objetivo objetivo) {
        double proteinas, gorduras, carboidratos;

        switch (objetivo) {
            case CUTTING -> {
                proteinas = calorias * 0.4 / 4;
                gorduras = calorias * 0.3 / 9;
                carboidratos = calorias * 0.3 / 4;
            }
            case BULKING -> {
                proteinas = calorias * 0.3 / 4;
                gorduras = calorias * 0.3 / 9;
                carboidratos = calorias * 0.4 / 4;
            }
            default -> { // MANUTENCAO
                proteinas = calorias * 0.3 / 4;
                gorduras = calorias * 0.3 / 9;
                carboidratos = calorias * 0.4 / 4;
            }
        }

        return new MacronutrientesCalculadosDTO(calorias, proteinas, carboidratos, gorduras, objetivo);
    }
}