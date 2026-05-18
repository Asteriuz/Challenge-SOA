package br.com.blindspot.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipamentoDTO {
    private Long id;
    private String descricao;
    private String categoria;
}
