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
@Table(name = "BS_MODELO")
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MODELO")
    private Long idModelo;

    @ManyToOne
    @JoinColumn(name = "ID_MARCA", nullable = false, foreignKey = @ForeignKey(name = "FK_MODELO_MARCA"))
    private Marca marca;

    @Column(name = "NOME_MODELO", nullable = false, length = 100)
    private String nomeModelo;

    protected Modelo() {}

    public Modelo(Marca marca, String nomeModelo) {
        this.marca = marca;
        this.nomeModelo = nomeModelo;
    }

    public Long getIdModelo() {
        return idModelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public String getNomeModelo() {
        return nomeModelo;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }
}
