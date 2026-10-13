package com.example;

import java.util.ArrayList;
import java.util.List;

public class ArvoreExemploSimples {

    public static boolean ehFolha(No no) {
        if (no == null) {
            return false;
        }

        return no.getFilhos().isEmpty();
    }

    public static int contarNos(No raiz) {
        if (raiz == null) {
            return 0;
        }

        int total = 1;

        for (No filho : raiz.getFilhos()) {
            total += contarNos(filho);
        }

        return total;
    }

    public static int contarFolhas(No raiz) {
        if (raiz == null) {
            return 0;
        }

        if (ehFolha(raiz)) {
            return 1;
        }

        int totalFolhas = 0;

        for (No filho : raiz.getFilhos()) {
            totalFolhas += contarFolhas(filho);
        }

        return totalFolhas;
    }


    public static int altura(No raiz) {
        if (raiz == null) {
            return -1;
        }

        if (ehFolha(raiz)) {
            return 0;
        }

        int maiorAlturaDosFilhos = -1;

        for (No filho : raiz.getFilhos()) {
            int alturaDoFilho = altura(filho);

            if (alturaDoFilho > maiorAlturaDosFilhos) {
                maiorAlturaDosFilhos = alturaDoFilho;
            }
        }

        return 1 + maiorAlturaDosFilhos;
    }

    public static int profundidade(No raiz, String nomeProcurado, int nivelAtual) {
        if (raiz == null) {
            return -1;
        }

        if (raiz.getNome().equals(nomeProcurado)) {
            return nivelAtual;
        }

        for (No filho : raiz.getFilhos()) {
            int resultado = profundidade(filho, nomeProcurado, nivelAtual + 1);

            if (resultado != -1) {
                return resultado;
            }
        }

        return -1;
    }

 
    public static void exibirArvore(No raiz, int nivel) {
        if (raiz == null) {
            return;
        }

        for (int i = 0; i < nivel; i++) {
            System.out.print("  ");
        }

        System.out.println("- " + raiz.getNome());

        for (No filho : raiz.getFilhos()) {
            exibirArvore(filho, nivel + 1);
        }
    }


    public static void main(String[] args) {
        // PASSO 1: criar somente a raiz.
        No raiz = new No("Empresa");

        // PASSO 2: criar os filhos diretos da raiz.
        No financeiro = new No("Financeiro");
        No vendas = new No("Vendas");
        No suporte = new No("Suporte");

        // PASSO 3: ligar os filhos diretos na raiz.
        raiz.adicionarFilho(financeiro);
        raiz.adicionarFilho(vendas);
        raiz.adicionarFilho(suporte);

        // PASSO 4: criar nos de um nivel mais abaixo.
        No contas = new No("Contas");
        No cobranca = new No("Cobranca");
        No lojaFisica = new No("Loja Fisica");
        No lojaOnline = new No("Loja Online");

        // PASSO 5: ligar os novos nos aos seus pais.
        financeiro.adicionarFilho(contas);
        financeiro.adicionarFilho(cobranca);
        vendas.adicionarFilho(lojaFisica);
        vendas.adicionarFilho(lojaOnline);

        // Desenho aproximado da arvore montada:
        //
        // Empresa
        // |- Financeiro
        // |  |- Contas
        // |  \- Cobranca
        // |- Vendas
        // |  |- Loja Fisica
        // |  \- Loja Online
        // \- Suporte

        // Mostra a estrutura inteira para facilitar a visualizacao.
        System.out.println("Arvore montada em etapas:\n");
        exibirArvore(raiz, 0);

        // Explica quem e a raiz.
        System.out.println("\nRaiz: " + raiz.getNome());

        // Mostra a quantidade total de nos.
        System.out.println("Quantidade total de nos: " + contarNos(raiz));

        // Mostra a quantidade de folhas.
        System.out.println("Quantidade de folhas: " + contarFolhas(raiz));

        // Mostra a altura da arvore.
        System.out.println("Altura da arvore: " + altura(raiz));

        // Mostra profundidades de alguns nos.
        System.out.println("Profundidade de Empresa: " + profundidade(raiz, "Empresa", 0));
        System.out.println("Profundidade de Vendas: " + profundidade(raiz, "Vendas", 0));
        System.out.println("Profundidade de Loja Online: " + profundidade(raiz, "Loja Online", 0));

        // Mostra exemplos de folha e de no interno.
        System.out.println("\nContas e folha? " + ehFolha(contas));
        System.out.println("Financeiro e folha? " + ehFolha(financeiro));
    }
}