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
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MARCA_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_MODELO_MARCA"))
    private Marca marca;

    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    protected Modelo() {}

    public Modelo(Marca marca, String nome) {
        this.marca = marca;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public Marca getMarca() {
        return marca;
    }

    public String getNome() {
        return nome;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
