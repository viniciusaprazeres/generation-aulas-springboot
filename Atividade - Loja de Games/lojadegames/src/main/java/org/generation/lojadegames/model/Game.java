package org.generation.lojadegames.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O atributo nome é obrigatório!")
    @Size(min = 1, max = 200, message = "O nome deve conter entre 1 e 200 caracteres.")
    private String nome;

    @NotBlank(message = "O atributo descrição é obrigatório!")
    @Size(min = 10, max = 1000, message = "A descrição deve conter entre 10 e 1000 caracteres.")
    private String descricao;

    @NotBlank(message = "O atributo desenvolvedora é obrigatório!")
    @Size(min = 1, max = 100, message = "A desenvolvedora deve conter entre 1 e 100 caracteres.")
    private String desenvolvedora;

    @NotBlank(message = "O atributo desenvolvedora é obrigatório!")
    @Size(min = 1, max = 100, message = "A distribuidora deve conter entre 1 e 100 caracteres.")
    private String distribuidora;

    private Float preco;

    @ManyToOne
    @JsonIgnoreProperties("game")
    private Genero genero;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDesenvolvedora() {
        return desenvolvedora;
    }

    public void setDesenvolvedora(String desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }

    public String getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(String distribuidora) {
        this.distribuidora = distribuidora;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
