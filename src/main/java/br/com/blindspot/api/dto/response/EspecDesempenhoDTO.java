package br.com.blindspot.api.dto.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EspecDesempenhoDTO {
    private BigDecimal aceleracao0100;
    private Integer velocidadeMax;
    private String modosConducao;
}
