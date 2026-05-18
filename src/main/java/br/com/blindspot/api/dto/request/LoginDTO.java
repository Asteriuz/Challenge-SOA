package br.com.blindspot.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record LoginDTO(
        @Schema(description = "Nome de usuário para login", example = "user123") @NotBlank(message = "Usuário é obrigatório") String username,
        @Schema(description = "Senha do usuário", example = "senha123") @NotBlank(message = "Senha é obrigatória") String password) {
}
