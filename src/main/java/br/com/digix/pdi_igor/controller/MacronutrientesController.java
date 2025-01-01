package br.com.digix.pdi_igor.controller;

import br.com.digix.pdi_igor.aplicacao.CalculaMacronutrientes;
import br.com.digix.pdi_igor.dominio.Objetivo;
import br.com.digix.pdi_igor.infra.dtos.MacronutrientesRequestDTO;
import br.com.digix.pdi_igor.infra.dtos.MacronutrientesResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/macronutrientes")
public class MacronutrientesController {

    private final CalculaMacronutrientes service;

    public MacronutrientesController(CalculaMacronutrientes service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MacronutrientesResponseDTO> calcularMacronutrientes(
            @RequestBody @Valid MacronutrientesRequestDTO request) {
        Objetivo objetivo = request.getObjetivo();
        MacronutrientesResponseDTO response = service.calcular(request, objetivo);

        return ResponseEntity.ok(response);
    }
}

