package br.com.digix.pdi_igor.repositorio;

import br.com.digix.pdi_igor.dominio.entidades.Macronutrientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MacronutrientesRepository extends JpaRepository<Macronutrientes, Long> {
}