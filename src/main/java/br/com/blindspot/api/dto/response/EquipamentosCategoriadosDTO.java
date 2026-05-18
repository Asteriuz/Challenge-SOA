package br.com.blindspot.api.dto.response;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipamentosCategoriadosDTO {
    private Map<String, List<EquipamentoDTO>> equipamentos;
}
