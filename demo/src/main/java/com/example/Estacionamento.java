package com.example;

public class Estacionamento {

    private final String[] vagas;
    private int topo;

    public Estacionamento(int capacidade) {
        vagas = new String[capacidade];
        topo = -1;
    }

    public boolean estacionar(String placa) {
        if (estaCheio()) {
            return false;
        }
        topo++;
        vagas[topo] = placa;
        return true;
    }

    public String sair() {
        if (estaVazia()) {
            return null;
        }
        String placa = vagas[topo];
        vagas[topo] = null;
        topo--;
        return placa;
    }

    public boolean estaVazia() {
        return topo == -1;
    }

    public boolean estaCheio() {
        return topo == vagas.length - 1;
    }

    public int quantidade() {
        return topo + 1;
    }

    public int vagasDisponiveis() {
        return vagas.length - quantidade();
    }

    public String placasDisponiveis(){
        String resultado = "";
        for(int i = 0; i <= topo; i++){
            resultado += vagas[i] + " ";
        }
        return resultado;
    }
}