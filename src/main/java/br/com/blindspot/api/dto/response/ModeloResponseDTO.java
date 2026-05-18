package br.com.blindspot.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModeloResponseDTO {
    private Long id;
    private String nome;
    private Long marcaId;
    private String marcaNome;
}
