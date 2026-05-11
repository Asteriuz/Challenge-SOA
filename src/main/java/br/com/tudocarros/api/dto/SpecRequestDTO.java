package br.com.tudocarros.api.dto;

import java.util.List;

public record SpecRequestDTO(
        String marca,
        String modelo,
        String versao,
        List<String> atributosDesejados
) {
}