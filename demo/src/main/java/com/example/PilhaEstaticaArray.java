package com.example;

/**
 * Exemplo 2: Pilha estatica usando apenas array.
 *
 * Regra da Pilha: LIFO (ultimo que entra, primeiro que sai).
 */
public class PilhaEstaticaArray {

    // Array fixo (estatico) para guardar os elementos.
    private int[] dados;

    // Indice do topo. -1 significa pilha vazia.
    private int topo;

    // Construtor: define a capacidade fixa da pilha.
    public PilhaEstaticaArray(int capacidade) {
        this.dados = new int[capacidade];
        this.topo = -1;
    }

    // Empilha (push): adiciona no topo.
    public boolean push(int valor) {
        if (estaCheia()) {
            System.out.println("Pilha cheia. Nao foi possivel empilhar " + valor);
            return false;
        }
        topo++;
        dados[topo] = valor;
        return true;
    }

    // Desempilha (pop): remove do topo.
    public int pop() {
        if (estaVazia()) {
            System.out.println("Pilha vazia. Nada para desempilhar.");
            return -1;
        }
        int removido = dados[topo];
        topo--;
        return removido;
    }

    // Consulta topo sem remover.
    public int peek() {
        if (estaVazia()) {
            System.out.println("Pilha vazia. Nao ha topo.");
            return -1;
        }
        return dados[topo];
    }

    public boolean estaVazia() {
        return topo == -1;
    }

    public boolean estaCheia() {
        return topo == dados.length - 1;
    }

    public int tamanho() {
        return topo + 1;
    }

    public void exibir() {
        System.out.print("Topo -> ");
        for (int i = topo; i >= 0; i--) {
            System.out.print(dados[i] + " ");
        }
        System.out.println("<- Base");
    }

    public static void main(String[] args) {
        // 1) Declarar e inicializar pilha estatica (capacidade fixa = 5).
        PilhaEstaticaArray pilha = new PilhaEstaticaArray(5);

        // 2) Ver capacidade e tamanho atual.
        System.out.println("Capacidade: " + pilha.dados.length);
        System.out.println("Tamanho inicial: " + pilha.tamanho());

        // 3) Inserir elementos (push).
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.exibir();

        // 4) Consultar topo (peek).
        System.out.println("Topo atual: " + pilha.peek());

        // 5) Remover elemento (pop).
        int removido = pilha.pop();
        System.out.println("Removido do topo: " + removido);
        pilha.exibir();

        // 6) Encher pilha para mostrar limite estatico.
        pilha.push(40);
        pilha.push(50);
        pilha.push(60);
        boolean ok = pilha.push(70); // deve falhar (cheia)
        System.out.println("Tentou push 70? " + ok);
        pilha.exibir();
    }
}