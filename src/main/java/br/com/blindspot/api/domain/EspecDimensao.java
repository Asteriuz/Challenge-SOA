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
@Table(name = "BS_ESPEC_DIMENSAO")
public class EspecDimensao {

    @Id
    @Column(name = "VERSAO_ID")
    private Long versaoId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "VERSAO_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_DIMENS_VERSAO"))
    private Versao versao;

    @Column(name = "COMPRIMENTO_MM")
    private Integer comprimentoMm;

    @Column(name = "LARGURA_MM")
    private Integer larguraMm;

    @Column(name = "ALTURA_MM")
    private Integer alturaMm;

    @Column(name = "ENTRE_EIXOS_MM")
    private Integer entreEixosMm;

    @Column(name = "PESO_KG")
    private Integer pesoKg;

    @Column(name = "CAPACIDADE_CARGA", length = 100)
    private String capacidadeCarga;

    protected EspecDimensao() {}

    public EspecDimensao(Versao versao) {
        this.versao = versao;
        this.versaoId = versao.getId();
    }

    public Long getVersaoId() {
        return versaoId;
    }

    public Versao getVersao() {
        return versao;
    }

    public Integer getComprimentoMm() {
        return comprimentoMm;
    }

    public Integer getLarguraMm() {
        return larguraMm;
    }

    public Integer getAlturaMm() {
        return alturaMm;
    }

    public Integer getEntreEixosMm() {
        return entreEixosMm;
    }

    public Integer getPesoKg() {
        return pesoKg;
    }

    public String getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setComprimentoMm(Integer comprimentoMm) {
        this.comprimentoMm = comprimentoMm;
    }

    public void setLarguraMm(Integer larguraMm) {
        this.larguraMm = larguraMm;
    }

    public void setAlturaMm(Integer alturaMm) {
        this.alturaMm = alturaMm;
    }

    public void setEntreEixosMm(Integer entreEixosMm) {
        this.entreEixosMm = entreEixosMm;
    }

    public void setPesoKg(Integer pesoKg) {
        this.pesoKg = pesoKg;
    }

    public void setCapacidadeCarga(String capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }
}
