package br.com.blindspot.api.domain;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BS_ESPEC_DESEMPENHO")
public class EspecDesempenho {

    @Id
    @Column(name = "VERSAO_ID")
    private Long versaoId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "VERSAO_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_DESEMP_VERSAO"))
    private Versao versao;

    @Column(name = "ACELERACAO_0_100", precision = 4, scale = 1)
    private BigDecimal aceleracao0100;

    @Column(name = "VELOCIDADE_MAX")
    private Integer velocidadeMax;

    @Column(name = "MODOS_CONDUCAO", length = 255)
    private String modosConducao;

    protected EspecDesempenho() {}

    public EspecDesempenho(Versao versao) {
        this.versao = versao;
        this.versaoId = versao.getId();
    }

    public Long getVersaoId() {
        return versaoId;
    }

    public Versao getVersao() {
        return versao;
    }

    public BigDecimal getAceleracao0100() {
        return aceleracao0100;
    }

    public Integer getVelocidadeMax() {
        return velocidadeMax;
    }

    public String getModosConducao() {
        return modosConducao;
    }

    public void setAceleracao0100(BigDecimal aceleracao0100) {
        this.aceleracao0100 = aceleracao0100;
    }

    public void setVelocidadeMax(Integer velocidadeMax) {
        this.velocidadeMax = velocidadeMax;
    }

    public void setModosConducao(String modosConducao) {
        this.modosConducao = modosConducao;
    }
}
