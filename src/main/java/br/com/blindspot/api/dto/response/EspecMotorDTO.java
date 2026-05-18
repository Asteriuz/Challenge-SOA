package br.com.blindspot.api.dto.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EspecMotorDTO {
    private String tipoMotor;
    private BigDecimal potenciaCv;
    private BigDecimal torqueKgfm;
    private String combustivel;
    private Integer valvulas;
    private String consumoCidade;
    private String consumoEstrada;
}
