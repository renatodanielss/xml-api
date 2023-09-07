package br.com.xml.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegiaoConsolidatedDTO {
    private String sigla;
    private Double geracaoValorConsolidado;
    private Double compraValorConsolidado;
    private Double precoMedioValorConsolidado;
}
