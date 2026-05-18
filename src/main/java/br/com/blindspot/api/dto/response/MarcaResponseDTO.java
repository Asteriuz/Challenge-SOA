package br.com.blindspot.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarcaResponseDTO {
    private Long id;
    private String nome;
    private String urlLogo;
}
