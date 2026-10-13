package com.example;

import java.util.ArrayList;
import java.util.List;

public class No {

    private String nome;
    private List<No> filhos;

    public  No(String nome) {
        this.nome = nome;

        this.filhos = new ArrayList<>();
    }

    public void adicionarFilho(No filho) {
        filhos.add(filho);
    }

    public List<No> getFilhos() {
        return filhos;
    }

    public String getNome() {
        return nome;
    }

    public void setFilhos(List<No> filhos) {
        this.filhos = filhos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
