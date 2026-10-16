package com.example;

/**
 * Exemplo simples para apresentar conceitos básicos de árvores.
 * Agora utilizando a classe No separada em outro arquivo.
 */
public class ArvoreExemploSimples {

    /**
     * Verifica se um no e folha.
     */
    public static boolean ehFolha(No no) {
        if (no == null) {
            return false;
        }
        return no.getFilhos().isEmpty();
    }

    /**
     * Conta quantos nos existem na arvore.
     */
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

    /**
     * Conta quantas folhas existem na arvore.
     */
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

    /**
     * Calcula a altura da arvore.
     */
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

    /**
     * Encontra a profundidade de um no a partir do nome.
     */
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

    /**
     * Exibe a arvore com recuo para mostrar a hierarquia.
     */
    public static void exibirArvore(No raiz, int nivel) {
        if (raiz == null) {
            return;
        }
        for (int i = 0; i < nivel; i++) {
            System.out.print("  ");
        }
        
        System.out.println("-" + raiz.getNome());

        for (No filho : raiz.getFilhos()) {
            exibirArvore(filho, nivel + 1);
        }
    }

    public static void main(String[] args) {
        No raiz = new No("Empresa");

        No financeiro = new No("Financeiro");
        No vendas = new No("Vendas");
        No suporte = new No("Suporte");


        raiz.adicionarFilho(financeiro);
        raiz.adicionarFilho(vendas);
        raiz.adicionarFilho(suporte);


        No contas = new No("Contas");
        No cobranca = new No("Cobranca");
        No lojaFisica = new No("Loja Fisica");
        No lojaOnline = new No("Loja Online");


        financeiro.adicionarFilho(contas);
        financeiro.adicionarFilho(cobranca);
        vendas.adicionarFilho(lojaFisica);
        vendas.adicionarFilho(lojaOnline);

        System.out.println("Arvore montada em etapas:\n");
        exibirArvore(raiz, 0);

        System.out.println("\nRaiz: " + raiz.getNome());

        System.out.println("Quantidade total de nos: " + contarNos(raiz));
        System.out.println("Quantidade de folhas: " + contarFolhas(raiz));
        System.out.println("Altura da arvore: " + altura(raiz));

        System.out.println("Profundidade de Empresa: " + profundidade(raiz, "Empresa", 0));
        System.out.println("Profundidade de Vendas: " + profundidade(raiz, "Vendas", 0));
        System.out.println("Profundidade de Loja Online: " + profundidade(raiz, "Loja Online", 0));

        System.out.println("\nContas e folha? " + ehFolha(contas));
        System.out.println("Financeiro e folha? " + ehFolha(financeiro));
    }
}