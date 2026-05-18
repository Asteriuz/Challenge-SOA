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
@Table(name = "BS_ESPEC_MOTOR")
public class EspecMotor {

    @Id
    @Column(name = "VERSAO_ID")
    private Long versaoId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "VERSAO_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_MOTOR_VERSAO"))
    private Versao versao;

    @Column(name = "TIPO_MOTOR", length = 100)
    private String tipoMotor;

    @Column(name = "POTENCIA_CV", precision = 5, scale = 1)
    private BigDecimal potenciaCv;

    @Column(name = "TORQUE_KGFM", precision = 5, scale = 1)
    private BigDecimal torqueKgfm;

    @Column(name = "COMBUSTIVEL", length = 50)
    private String combustivel;

    @Column(name = "VALVULAS")
    private Integer valvulas;

    @Column(name = "CONSUMO_CIDADE", length = 50)
    private String consumoCidade;

    @Column(name = "CONSUMO_ESTRADA", length = 50)
    private String consumoEstrada;

    protected EspecMotor() {}

    public EspecMotor(Versao versao) {
        this.versao = versao;
        this.versaoId = versao.getId();
    }

    public Long getVersaoId() {
        return versaoId;
    }

    public Versao getVersao() {
        return versao;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public BigDecimal getPotenciaCv() {
        return potenciaCv;
    }

    public BigDecimal getTorqueKgfm() {
        return torqueKgfm;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public Integer getValvulas() {
        return valvulas;
    }

    public String getConsumoCidade() {
        return consumoCidade;
    }

    public String getConsumoEstrada() {
        return consumoEstrada;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public void setPotenciaCv(BigDecimal potenciaCv) {
        this.potenciaCv = potenciaCv;
    }

    public void setTorqueKgfm(BigDecimal torqueKgfm) {
        this.torqueKgfm = torqueKgfm;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public void setValvulas(Integer valvulas) {
        this.valvulas = valvulas;
    }

    public void setConsumoCidade(String consumoCidade) {
        this.consumoCidade = consumoCidade;
    }

    public void setConsumoEstrada(String consumoEstrada) {
        this.consumoEstrada = consumoEstrada;
    }
}
