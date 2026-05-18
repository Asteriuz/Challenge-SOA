package br.com.blindspot.api.dto.response;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VersaoDetalhesDTO {
    private Long id;
    private String nome;
    private Integer anoFabricacao;
    private Integer anoModelo;
    private BigDecimal preco;
    private BigDecimal notaMedia;
    private Long qtdAvaliacoes;
    
    private String nomeModelo;
    private String nomeMarca;
    
    private EspecMotorDTO motor;
    private EspecTransmissaoDTO transmissao;
    private EspecDesempenhoDTO desempenho;
    private EspecDimensaoDTO dimensao;
    
    private EquipamentosCategoriadosDTO equipamentos;
    private List<FotoVeiculoDTO> fotos;
}
