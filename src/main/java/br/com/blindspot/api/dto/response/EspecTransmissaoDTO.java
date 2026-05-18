package br.com.blindspot.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EspecTransmissaoDTO {
    private String tipoTransmissao;
    private Integer marchas;
    private String tracao;
    private String diferencial;
}
