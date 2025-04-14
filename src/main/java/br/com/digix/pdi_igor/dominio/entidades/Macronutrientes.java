package br.com.digix.pdi_igor.dominio.entidades;

import br.com.digix.pdi_igor.dominio.Objetivo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Macronutrientes {
    private double calorias;
    private double proteinas;
    private double carboidratos;
    private double gorduras;
    private Objetivo objetivo;
}
