package br.com.blindspot.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.blindspot.api.domain.AppUser;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
}
