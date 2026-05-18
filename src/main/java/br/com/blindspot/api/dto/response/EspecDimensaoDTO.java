package br.com.blindspot.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EspecDimensaoDTO {
    private Integer comprimentoMm;
    private Integer larguraMm;
    private Integer alturaMm;
    private Integer entreEixosMm;
    private Integer pesoKg;
    private String capacidadeCarga;
}
