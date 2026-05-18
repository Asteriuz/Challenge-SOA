package br.com.blindspot.api.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BS_EQUIPAMENTO")
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EQUIPAMENTO")
    private Long idEquipamento;

    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIA", nullable = false, foreignKey = @ForeignKey(name = "FK_EQUIP_CATEG"))
    private CategoriaEquip categoria;

    @Column(name = "DESCRICAO", nullable = false, length = 150)
    private String descricao;

    @ManyToMany(mappedBy = "equipamentos")
    private Set<Versao> versoes = new HashSet<>();

    protected Equipamento() {}

    public Equipamento(CategoriaEquip categoria, String descricao) {
        this.categoria = categoria;
        this.descricao = descricao;
    }

    public Long getIdEquipamento() {
        return idEquipamento;
    }

    public CategoriaEquip getCategoria() {
        return categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setCategoria(CategoriaEquip categoria) {
        this.categoria = categoria;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Versao> getVersoes() {
        return versoes;
    }

    public void setVersoes(Set<Versao> versoes) {
        this.versoes = versoes;
    }
}
