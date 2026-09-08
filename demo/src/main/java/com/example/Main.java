package com.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // 1) DECLARACAO: cria a variavel que vai apontar para um array de int.
        int[] numeros;

        // 2) INICIALIZACAO/CONSTRUCAO: cria o array com 8 posicoes fixas.
        numeros = new int[8];

        // Controla quantos elementos estao realmente em uso.
        int tamanho = 0;

        // 3) TAMANHO TOTAL (capacidade fixa) do array.
        System.out.println("Capacidade do array: " + numeros.length);

        // 4) INSERIR NO FIM (simples).
        tamanho = ArrayEstatico.inserirNoFim(numeros, tamanho, 10);
        tamanho = ArrayEstatico.inserirNoFim(numeros, tamanho, 20);
        tamanho = ArrayEstatico.inserirNoFim(numeros, tamanho, 30);
        ArrayEstatico.exibirComIndice(numeros, tamanho);

        // 4) INSERIR EM POSICAO (precisa deslocar para a direita).
        tamanho = ArrayEstatico.inserirEmPosicao(numeros, tamanho, 1, 15);
        ArrayEstatico.exibirComIndice(numeros, tamanho);

        // 5) REMOVER POR INDICE (precisa deslocar para a esquerda).
        tamanho = ArrayEstatico.removerPorIndice(numeros, tamanho, 2);
        ArrayEstatico.exibirComIndice(numeros, tamanho);

        // Leitura por indice (acesso direto O(1)).
        System.out.println("Elemento no indice 1: " + numeros[1]);

        // Busca simples (linear O(n)).
        int indice = ArrayEstatico.buscar(numeros, tamanho, 30);
        System.out.println("Valor 30 encontrado no indice: " + indice);

        // ---- 3 formas de exibir ----
        ArrayEstatico.exibirComIndice(numeros, tamanho); // mostra indice + valor
        ArrayEstatico.exibirForEach(numeros, tamanho);   // mostra so o valor (for-each)
        ArrayEstatico.exibirWhile(numeros, tamanho);     // mostra so o valor (while)
    }
}