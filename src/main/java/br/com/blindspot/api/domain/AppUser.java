package br.com.blindspot.api.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "BS_USERS")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USERNAME", nullable = false, unique = true, length = 100)
    private String username;

    @Column(name = "SENHA_HASH", nullable = false, length = 255)
    private String senhaHash;

    @Column(name = "ROLE_NAME", nullable = false, length = 50)
    private String roleName;

    protected AppUser() {
    }

    public AppUser(String username, String passwordHash, String roleName) {
        this.username = username;
        this.senhaHash = passwordHash;
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public String getRoleName() {
        return roleName;
    }
}
