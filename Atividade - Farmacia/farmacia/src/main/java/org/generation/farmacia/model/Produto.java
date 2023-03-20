package org.generation.farmacia.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O atributo nome é obrigatório!")
    @Size(min = 5, max = 100, message = "O atributo nome deve conter entre 5 e 100 caracteres.")
    private String nome;

    @NotBlank(message = "O atributo nome comercial é obrigatório!")
    @Size(min = 5, max = 100, message = "O atributo nome comercial deve conter entre 5 e 100 caracteres.")
    private String nomeComercial;

    @NotBlank(message = "O atributo fabricante é obrigatório!")
    @Size(min = 5, max = 100, message = "O atributo fabricante deve conter entre 5 e 100 caracteres.")
    private String fabricante;

    //@NotBlank(message = "O atributo preço é obrigatório!")
    private Float preco;

    @ManyToOne
    @JsonIgnoreProperties("produto")
    private Categoria categoria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeComercial() {
        return nomeComercial;
    }

    public void setNomeComercial(String nomeComercial) {
        this.nomeComercial = nomeComercial;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
