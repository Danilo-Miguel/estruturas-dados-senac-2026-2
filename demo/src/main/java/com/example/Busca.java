package com.example; // mesmo pacote do Main e da Calculadora

public class Busca { // classe só com métodos de busca, pra comparar complexidade

    // BUSCA LINEAR - complexidade O(n)
    // "O(n)" quer dizer: no pior caso, o número de passos cresce na mesma
    // proporção do tamanho do array. Se o array dobra de tamanho, o trabalho
    // no pior caso também dobra.
    public static int buscaLinear(int[] valores, int alvo) {
        for (int i = 0; i < valores.length; i++) { // percorre o array posição por posição, do início ao fim
            if (valores[i] == alvo) { // achou o número procurado?
                return i; // se achou, devolve a posição (índice) na hora
            }
        }
        return -1; // se o laço terminou e não achou, devolve -1 (não encontrado)
    }

    // BUSCA BINÁRIA - complexidade O(log n)
    // "O(log n)" quer dizer: a cada passo, descartamos metade do que resta
    // procurar. Bem mais rápido que O(n) para arrays grandes.
    // IMPORTANTE: só funciona se o array já estiver ORDENADO.
    public static int buscaBinaria(int[] valoresOrdenados, int alvo) {
        int inicio = 0;                          // primeira posição do trecho onde ainda pode estar o alvo
        int fim = valoresOrdenados.length - 1;    // última posição do trecho

        while (inicio <= fim) { // enquanto ainda sobrar um trecho válido pra olhar
            int meio = inicio + (fim - inicio) / 2; // calcula a posição do meio do trecho atual

            if (valoresOrdenados[meio] == alvo) { // o valor do meio é o que procuramos?
                return meio; // achou, devolve a posição
            } else if (valoresOrdenados[meio] < alvo) { // o alvo é maior que o valor do meio?
                inicio = meio + 1; // então só pode estar na metade da direita: descarta a esquerda
            } else { // o alvo é menor que o valor do meio
                fim = meio - 1; // então só pode estar na metade da esquerda: descarta a direita
            }
        }
        return -1; // trecho ficou vazio (inicio passou do fim) e não achou: devolve -1
    }
}
