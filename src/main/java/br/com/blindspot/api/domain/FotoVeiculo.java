package br.com.blindspot.api.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BS_FOTO_VEICULO")
public class FotoVeiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FOTO")
    private Long idFoto;

    @ManyToOne
    @JoinColumn(name = "ID_VERSAO", nullable = false, foreignKey = @ForeignKey(name = "FK_FOTO_VERSAO"))
    private Versao versao;

    @Column(name = "URL_FOTO", nullable = false, length = 500)
    private String urlFoto;

    @Column(name = "IS_PRINCIPAL")
    private Boolean isPrincipal;

    protected FotoVeiculo() {}

    public FotoVeiculo(Versao versao, String urlFoto) {
        this.versao = versao;
        this.urlFoto = urlFoto;
        this.isPrincipal = false;
    }

    public Long getIdFoto() {
        return idFoto;
    }

    public Versao getVersao() {
        return versao;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public Boolean getIsPrincipal() {
        return isPrincipal;
    }

    public void setVersao(Versao versao) {
        this.versao = versao;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public void setIsPrincipal(Boolean isPrincipal) {
        this.isPrincipal = isPrincipal;
    }
}
