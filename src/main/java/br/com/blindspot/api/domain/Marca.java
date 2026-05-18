package br.com.blindspot.api.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "BS_MARCA")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @Column(name = "URL_LOGO", length = 255)
    private String urlLogo;

    protected Marca() {}

    public Marca(String nome, String urlLogo) {
        this.nome = nome;
        this.urlLogo = urlLogo;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }
}
