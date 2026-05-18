package br.com.blindspot.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.blindspot.api.domain.AppUser;
import br.com.blindspot.api.dto.request.CadastroDTO;
import br.com.blindspot.api.dto.request.LoginDTO;
import br.com.blindspot.api.dto.response.MensagemResponseDTO;
import br.com.blindspot.api.dto.response.TokenResponseDTO;
import br.com.blindspot.api.exception.UserAlreadyExistsException;
import br.com.blindspot.api.repository.AppUserRepository;
import br.com.blindspot.api.security.TokenService;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public TokenResponseDTO login(LoginDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken(auth.getName());
        return new TokenResponseDTO(token);
    }

    public MensagemResponseDTO cadastro(CadastroDTO data) {
        if (appUserRepository.findByUsername(data.username()).isPresent()) {
            throw new UserAlreadyExistsException("Nome de usuário já cadastrado");
        }

        AppUser user = new AppUser(
                data.username(),
                passwordEncoder.encode(data.password()),
                "USER");
        appUserRepository.save(user);

        return new MensagemResponseDTO("Usuário cadastrado com sucesso");
    }
}
