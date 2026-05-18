package br.com.blindspot.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CadastroDTO(
                @Schema(description = "Nome de usuário para login", example = "user123") @NotBlank(message = "Usuário é obrigatório") @Size(min = 3, max = 100, message = "Usuário deve ter entre 3 e 100 caracteres") String username,

                @Schema(description = "Senha do usuário", example = "senha123") @NotBlank(message = "Senha é obrigatória") @Size(min = 8, max = 72, message = "Senha deve ter entre 8 e 72 caracteres") String password) {
}
