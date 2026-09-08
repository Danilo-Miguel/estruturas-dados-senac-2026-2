package com.example;

public class ArrayEstatico {

    /**
     * Insere um valor na primeira posicao livre do array (indice igual a tamanho).
     *
     * Complexidade: O(1).
     *
     * @param array array estatico de destino
     * @param tamanho quantidade atual de elementos em uso
     * @param valor valor a inserir
     * @return novo tamanho apos a insercao; se estiver cheio, retorna o mesmo tamanho
     */
    public static int inserirNoFim(int[] array, int tamanho, int valor) {
        // Verifica se ha espaco disponivel.
        if (tamanho >= array.length) {
            System.out.println("Array cheio. Nao foi possivel inserir " + valor);
            return tamanho;
        }

        // Escreve o valor na primeira posicao livre (que e 'tamanho').
        array[tamanho] = valor;

        // Retorna o novo tamanho aumentado em 1.
        return tamanho + 1;
    }

    /**
     * Insere um valor em um indice especifico, deslocando os elementos a direita.
     *
     * Complexidade: O(n).
     *
     * @param array array estatico de destino
     * @param tamanho quantidade atual de elementos em uso
     * @param indice posicao onde o novo valor sera inserido
     * @param valor valor a inserir
     * @return novo tamanho apos a insercao; em caso invalido, retorna o tamanho original
     */
    public static int inserirEmPosicao(int[] array, int tamanho, int indice, int valor) {
        if (tamanho >= array.length) {
            System.out.println("Array cheio. Nao foi possivel inserir " + valor);
            return tamanho;
        }
        if (indice < 0 || indice > tamanho) {
            System.out.println("Indice invalido para insercao: " + indice);
            return tamanho;
        }

        for (int i = tamanho; i > indice; i--) {
            array[i] = array[i - 1];
        }

        array[indice] = valor;
        return tamanho + 1;
    }

    /**
     * Remove o elemento de um indice especifico, deslocando os elementos a esquerda.
     *
     * Complexidade: O(n).
     *
     * @param array array estatico de origem
     * @param tamanho quantidade atual de elementos em uso
     * @param indice posicao a remover
     * @return novo tamanho apos a remocao; em caso invalido, retorna o tamanho original
     */
    public static int removerPorIndice(int[] array, int tamanho, int indice) {
        if (tamanho == 0) {
            System.out.println("Array vazio. Nada para remover.");
            return tamanho;
        }
        if (indice < 0 || indice >= tamanho) {
            System.out.println("Indice invalido para remocao: " + indice);
            return tamanho;
        }

        for (int i = indice; i < tamanho - 1; i++) {
            array[i] = array[i + 1];
        }

        // Limpa ultima posicao usada (opcional, mas didatico).
        array[tamanho - 1] = 0;
        return tamanho - 1;
    }

    /**
     * Busca um valor no trecho ocupado do array ([0, tamanho)).
     *
     * Complexidade: O(n).
     *
     * @param array array estatico de origem
     * @param tamanho quantidade atual de elementos em uso
     * @param valor valor procurado
     * @return indice do valor encontrado ou -1 se nao existir
     */
    public static int buscar(int[] array, int tamanho, int valor) {
        for (int i = 0; i < tamanho; i++) {
            if (array[i] == valor) {
                return i;
            }
        }
        return -1;
    }

    // -------------------------------------------------
    // EXIBICAO DOS DADOS (somente elementos em uso)
    // -------------------------------------------------

    /**
     * Exibe os elementos usando for com indice.
     *
     * @param array array de origem
     * @param tamanho quantidade de elementos em uso
     */
    public static void exibirComIndice(int[] array, int tamanho) {
        System.out.println("--- exibirComIndice ---");
        for (int i = 0; i < tamanho; i++) {
            // 'i' e o indice, 'array[i]' e o valor naquela posicao.
            System.out.println("indice " + i + " -> " + array[i]);
        }
    }

    /**
     * Exibe os elementos usando for-each.
     *
     * Como for-each percorre o array inteiro, este metodo copia primeiro
     * apenas o trecho realmente ocupado para evitar mostrar posicoes vazias.
     *
     * @param array array de origem
     * @param tamanho quantidade de elementos em uso
     */
    public static void exibirForEach(int[] array, int tamanho) {
        System.out.println("--- exibirForEach ---");
        // Copia somente os elementos ocupados para um array temporario.
        int[] usados = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            usados[i] = array[i];
        }
        // Agora percorre sem risco de mostrar posicoes vazias.
        for (int valor : usados) {
            System.out.println(valor);
        }
    }

    /**
     * Exibe os elementos usando while.
     *
     * @param array array de origem
     * @param tamanho quantidade de elementos em uso
     */
    public static void exibirWhile(int[] array, int tamanho) {
        System.out.println("--- exibirWhile ---");
        int i = 0;
        while (i < tamanho) {       // continua enquanto houver elementos
            System.out.println(array[i]);
            i++;                    // avanca para o proximo
        }
    }
}
