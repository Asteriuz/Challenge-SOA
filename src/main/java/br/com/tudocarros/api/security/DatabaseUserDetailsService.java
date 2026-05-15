package br.com.tudocarros.api.security;

import br.com.tudocarros.api.repository.AppUserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;

@Service
public class DatabaseUserDetailsService implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    public DatabaseUserDetailsService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var appUser = appUserRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("Usuário não encontrado: " + username));

        return new User(appUser.getUsername(), appUser.getPasswordHash(),
                List.of(new SimpleGrantedAuthority(
                        "ROLE_" + appUser.getRoleName().toUpperCase(Locale.ROOT))));
    }
}
