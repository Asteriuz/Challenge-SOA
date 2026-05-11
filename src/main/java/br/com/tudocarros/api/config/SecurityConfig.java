package br.com.tudocarros.api.config;

import br.com.tudocarros.api.security.SecurityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity // Permite usar anotações como @PreAuthorize nos Controllers depois
public class SecurityConfig {

    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                // Define que a API é Stateless (não guarda sessão), exigência para JWT
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        // 1. Libera o Swagger para a banca conseguir testar
                        .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()

                        // 2. Libera a rota de Login para qualquer um conseguir gerar o token
                        .requestMatchers(HttpMethod.POST, "/api/v1/auth/login").permitAll()

                        // 3. (Opcional) Regras específicas para o endpoint de busca da concorrência
                        // Se você quiser que só Admins usem a busca, descomente a linha abaixo e
                        // comente a anyRequest
                        // .requestMatchers(HttpMethod.POST,
                        // "/api/v1/specifications/search").hasRole("ADMIN")

                        // 4. Qualquer outra requisição precisa do Token JWT válido
                        .anyRequest().authenticated())
                // 5. Troca o httpBasic pelo nosso filtro de JWT
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    // Gerenciador de Autenticação do Spring (Necessário para a classe de Login
    // depois)
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    // Criptografia de senhas (Mantevemos igual ao seu exemplo, pois é o padrão de
    // mercado)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        // Criando um usuário fixo para o MVP
        UserDetails admin = org.springframework.security.core.userdetails.User
                .withUsername("admin")
                .password(encoder.encode("admin123"))
                .roles("ADMIN")
                .build();

        return new org.springframework.security.provisioning.InMemoryUserDetailsManager(admin);
    }
}