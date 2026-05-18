package br.com.blindspot.api.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BS_VERSAO")
public class Versao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VERSAO")
    private Long idVersao;

    @ManyToOne
    @JoinColumn(name = "ID_MODELO", nullable = false, foreignKey = @ForeignKey(name = "FK_VERSAO_MODELO"))
    private Modelo modelo;

    @Column(name = "NOME_VERSAO", nullable = false, length = 150)
    private String nomeVersao;

    @Column(name = "ANO_FABRICACAO", nullable = false)
    private Integer anoFabricacao;

    @Column(name = "ANO_MODELO", nullable = false)
    private Integer anoModelo;

    @Column(name = "PRECO_ATUAL", precision = 12, scale = 2)
    private BigDecimal precoAtual;

    @Column(name = "NOTA_MEDIA", precision = 3, scale = 2)
    private BigDecimal notaMedia;

    @Column(name = "QTD_AVALIACOES")
    private Long qtdAvaliacoes;

    @ManyToMany
    @JoinTable(
        name = "BS_VERSAO_EQUIPAMENTO",
        joinColumns = @JoinColumn(name = "ID_VERSAO", foreignKey = @ForeignKey(name = "FK_VE_VERSAO")),
        inverseJoinColumns = @JoinColumn(name = "ID_EQUIPAMENTO", foreignKey = @ForeignKey(name = "FK_VE_EQUIP"))
    )
    private Set<Equipamento> equipamentos = new HashSet<>();

    protected Versao() {}

    public Versao(Modelo modelo, String nomeVersao, Integer anoFabricacao, Integer anoModelo) {
        this.modelo = modelo;
        this.nomeVersao = nomeVersao;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.notaMedia = BigDecimal.ZERO;
        this.qtdAvaliacoes = 0L;
    }

    public Long getIdVersao() {
        return idVersao;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public String getNomeVersao() {
        return nomeVersao;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public BigDecimal getPrecoAtual() {
        return precoAtual;
    }

    public BigDecimal getNotaMedia() {
        return notaMedia;
    }

    public Long getQtdAvaliacoes() {
        return qtdAvaliacoes;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public void setNomeVersao(String nomeVersao) {
        this.nomeVersao = nomeVersao;
    }

    public void setPrecoAtual(BigDecimal precoAtual) {
        this.precoAtual = precoAtual;
    }

    public void setNotaMedia(BigDecimal notaMedia) {
        this.notaMedia = notaMedia;
    }

    public void setQtdAvaliacoes(Long qtdAvaliacoes) {
        this.qtdAvaliacoes = qtdAvaliacoes;
    }

    public Set<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(Set<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }

    public void addEquipamento(Equipamento equipamento) {
        this.equipamentos.add(equipamento);
        equipamento.getVersoes().add(this);
    }

    public void removeEquipamento(Equipamento equipamento) {
        this.equipamentos.remove(equipamento);
        equipamento.getVersoes().remove(this);
    }
}
