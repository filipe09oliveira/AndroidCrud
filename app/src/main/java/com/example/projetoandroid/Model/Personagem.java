package com.example.projetoandroid.Model;

import java.io.Serializable;

public class Personagem implements Serializable {

    public Integer id_personagem;
    public String nome;
    public String funcao;
    public String descricao;
    public int imagens;

    public Personagem(){
        id_personagem = 0;
    }

    public Integer getId_personagem() {
        return id_personagem;
    }

    public void setId_personagem(Integer id_personagem) {
        this.id_personagem = id_personagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Personagem{" +
                "nome='" + nome + '\'' +
                ", funcao='" + funcao + '\'' +
                ", descricao='" + descricao + '\'' +
                ", imagens=" + imagens +
                '}';
    }
}
