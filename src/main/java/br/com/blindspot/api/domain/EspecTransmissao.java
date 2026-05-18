package br.com.blindspot.api.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BS_ESPEC_TRANSMISSAO")
public class EspecTransmissao {

    @Id
    @Column(name = "ID_VERSAO")
    private Long idVersao;

    @OneToOne
    @MapsId
    @JoinColumn(name = "ID_VERSAO", nullable = false, foreignKey = @ForeignKey(name = "FK_TRANS_VERSAO"))
    private Versao versao;

    @Column(name = "TIPO_TRANSMISSAO", length = 50)
    private String tipoTransmissao;

    @Column(name = "MARCHAS")
    private Integer marchas;

    @Column(name = "TRACAO", length = 50)
    private String tracao;

    @Column(name = "DIFERENCIAL", length = 150)
    private String diferencial;

    protected EspecTransmissao() {}

    public EspecTransmissao(Versao versao) {
        this.versao = versao;
        this.idVersao = versao.getIdVersao();
    }

    public Long getIdVersao() {
        return idVersao;
    }

    public Versao getVersao() {
        return versao;
    }

    public String getTipoTransmissao() {
        return tipoTransmissao;
    }

    public Integer getMarchas() {
        return marchas;
    }

    public String getTracao() {
        return tracao;
    }

    public String getDiferencial() {
        return diferencial;
    }

    public void setTipoTransmissao(String tipoTransmissao) {
        this.tipoTransmissao = tipoTransmissao;
    }

    public void setMarchas(Integer marchas) {
        this.marchas = marchas;
    }

    public void setTracao(String tracao) {
        this.tracao = tracao;
    }

    public void setDiferencial(String diferencial) {
        this.diferencial = diferencial;
    }
}
