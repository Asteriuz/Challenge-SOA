package br.com.tudocarros.api.controller;

import br.com.tudocarros.api.domain.AppUser;
import br.com.tudocarros.api.dto.CadastroDTO;
import br.com.tudocarros.api.dto.LoginDTO;
import br.com.tudocarros.api.exception.UserAlreadyExistsException;
import br.com.tudocarros.api.repository.AppUserRepository;
import br.com.tudocarros.api.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.Map;

@RestController
@Tag(name = "Autenticação", description = "Endpoints de autenticação")
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken(auth.getName());
        return ResponseEntity.ok(Map.of("token", token));
    }

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastro(@RequestBody @Valid CadastroDTO data) {
        if (appUserRepository.findByUsername(data.username()).isPresent()) {
            throw new UserAlreadyExistsException("Já existe um usuário com esse username");
        }

        AppUser user = new AppUser(
                data.username(),
                passwordEncoder.encode(data.password()),
                "USER"
        );
        appUserRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensagem", "Usuário cadastrado com sucesso"));
    }
}
