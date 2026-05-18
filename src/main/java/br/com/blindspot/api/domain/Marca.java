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
    @Column(name = "ID_MARCA")
    private Long idMarca;

    @Column(name = "NOME_MARCA", nullable = false, length = 100)
    private String nomeMarca;

    @Column(name = "URL_LOGO", length = 255)
    private String urlLogo;

    protected Marca() {}

    public Marca(String nomeMarca, String urlLogo) {
        this.nomeMarca = nomeMarca;
        this.urlLogo = urlLogo;
    }

    public Long getIdMarca() {
        return idMarca;
    }

    public String getNomeMarca() {
        return nomeMarca;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }
}
