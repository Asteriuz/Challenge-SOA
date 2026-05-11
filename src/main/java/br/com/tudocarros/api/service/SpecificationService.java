package br.com.tudocarros.api.service;

import br.com.tudocarros.api.dto.SpecRequestDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SpecificationService {

    public Map<String, Object> generateStandardSpecs(SpecRequestDTO request) {
        
        // 1. Busca os dados brutos da concorrência (Simulando uma busca em IA ou API externa)
        Map<String, String> dadosBrutosEncontrados = mockBuscaDadosConcorrencia(request.marca(), request.modelo(), request.versao());

        // 2. Prepara a saída padronizada (Obrigatório pelo desafio)
        Map<String, Object> respostaPadronizada = new HashMap<>();
        respostaPadronizada.put("veiculo", request.marca() + " " + request.modelo() + " " + request.versao());
        
        Map<String, String> especificacoes = new HashMap<>();

        // 3. Verifica apenas os atributos que o usuário pediu
        for (String atributoPedido : request.atributosDesejados()) {
            
            // Busca o atributo ignorando maiúsculas/minúsculas (ex: "Motor" == "motor")
            String valorEncontrado = dadosBrutosEncontrados.entrySet().stream()
                    .filter(entry -> entry.getKey().equalsIgnoreCase(atributoPedido))
                    .map(Map.Entry::getValue)
                    .findFirst()
                    .orElse(null);

            // A REGRA DE OURO DA FORD: Se não achou, colocar "vazio / não disponível"
            if (valorEncontrado != null && !valorEncontrado.isBlank()) {
                especificacoes.put(atributoPedido, valorEncontrado);
            } else {
                especificacoes.put(atributoPedido, "vazio / não disponível");
            }
        }

        respostaPadronizada.put("especificacoes", especificacoes);
        
        // No futuro, aqui você chamará o VehicleRepository para salvar essa resposta no Oracle!

        return respostaPadronizada;
    }

    // Método que simula a "Abordagem Livre" encontrando a Ranger Raptor
    private Map<String, String> mockBuscaDadosConcorrencia(String marca, String modelo, String versao) {
        Map<String, String> bancoDeDadosExterno = new HashMap<>();
        
        if (marca.equalsIgnoreCase("Ford") && modelo.equalsIgnoreCase("Ranger") && versao.equalsIgnoreCase("Raptor")) {
            bancoDeDadosExterno.put("Motor", "3.0 V6 Bi-Turbo Gasolina");
            bancoDeDadosExterno.put("Potência", "397 cv");
            bancoDeDadosExterno.put("Torque", "59,4 kgfm");
            bancoDeDadosExterno.put("Transmissão", "Automática de 10 marchas");
            bancoDeDadosExterno.put("Tração", "4WD (Integral)");
            bancoDeDadosExterno.put("Capacidade de Carga", "736 kg");
            bancoDeDadosExterno.put("0 a 100 km/h", "5,8 segundos");
            // Nota: Não colocamos "Teto Solar" de propósito para testar a regra do "não disponível"
        }
        
        return bancoDeDadosExterno;
    }
}