package br.com.blindspot.api.dto.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VersaoResumoDTO {
    private Long id;
    private String nome;
    private Integer anoModelo;
    private BigDecimal preco;
    private String urlFotoPrincipal;
    private String nomeModelo;
    private String nomeMarca;
}
