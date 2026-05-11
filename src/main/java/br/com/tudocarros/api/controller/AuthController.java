package br.com.tudocarros.api.controller;

import br.com.tudocarros.api.dto.LoginDTO;
import br.com.tudocarros.api.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO data) {
        try {
            // Cria um token provisório com os dados que o usuário digitou
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
            
            // O Spring Security vai verificar se a senha bate com a do "admin123"
            var auth = this.authenticationManager.authenticate(usernamePassword);
            
            // Se chegou aqui, a senha está certa. Gera o Token JWT!
            var token = tokenService.generateToken(auth.getName());
            
            // Devolve o token em formato JSON
            return ResponseEntity.ok(Map.of("token", token));
            
        } catch (Exception e) {
            // Se a senha estiver errada, devolve erro 403 Forbidden
            return ResponseEntity.status(403).body(Map.of("erro", "Usuário ou senha incorretos"));
        }
    }
}