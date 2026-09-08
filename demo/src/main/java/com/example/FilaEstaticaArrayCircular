package com.example;

/**
 * Exemplo 3: Fila estatica usando array circular.
 *
 * Regra da Fila: FIFO (primeiro que entra, primeiro que sai).
 */
public class FilaEstaticaArrayCircular {

    // Array fixo da fila.
    private int[] dados;

    // Indice do primeiro elemento (frente da fila).
    private int inicio;

    // Indice onde o proximo elemento sera inserido (fim logico).
    private int fim;

    // Quantidade de elementos em uso.
    private int tamanho;

    // Construtor: define capacidade fixa da fila.
    public FilaEstaticaArrayCircular(int capacidade) {
        this.dados = new int[capacidade];
        this.inicio = 0;
        this.fim = 0;
        this.tamanho = 0;
    }

    // Enfileirar (enqueue): entra no fim.
    public boolean enqueue(int valor) {
        if (estaCheia()) {
            System.out.println("Fila cheia. Nao foi possivel enfileirar " + valor);
            return false;
        }

        dados[fim] = valor;
        fim = (fim + 1) % dados.length; // passo circular
        tamanho++;
        return true;
    }

    // Desenfileirar (dequeue): sai da frente.
    public int dequeue() {
        if (estaVazia()) {
            System.out.println("Fila vazia. Nada para desenfileirar.");
            return -1;
        }

        int removido = dados[inicio];
        inicio = (inicio + 1) % dados.length; // passo circular
        tamanho--;
        return removido;
    }

    // Consulta elemento da frente sem remover.
    public int peek() {
        if (estaVazia()) {
            System.out.println("Fila vazia. Nao ha frente.");
            return -1;
        }
        return dados[inicio];
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public boolean estaCheia() {
        return tamanho == dados.length;
    }

    public int tamanho() {
        return tamanho;
    }

    public int capacidade() {
        return dados.length;
    }

    public void exibir() {
        System.out.print("Frente -> ");
        for (int i = 0; i < tamanho; i++) {
            int indiceReal = (inicio + i) % dados.length;
            System.out.print(dados[indiceReal] + " ");
        }
        System.out.println("<- Fim");
    }
}