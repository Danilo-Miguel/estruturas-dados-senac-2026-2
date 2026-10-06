package com.example;

import java.util.NoSuchElementException;

/**
 * Lista Duplamente Encadeada (Doubly Linked List).
 *
 * Diferenca para a lista simples:
 * - Cada no tem referencia para o PROXIMO e para o ANTERIOR.
 * - Isso permite percorrer nos dois sentidos (frente e tras).
 * - Operacoes no fim da lista ficam O(1) porque guardamos ponteiro para o tail.
 *
 * Estrutura de memoria de cada no:
 *
 *   anterior <- [ valor ] -> proximo
 *
 * @param <T> tipo de dado armazenado
 */
public class ListaDuplamenteEncadeada<T> {

    // -------------------------------------------------------------------------
    // No interno
    // -------------------------------------------------------------------------

    private static class No<T> {
        T valor;
        No<T> proximo;
        No<T> anterior;

        No(T valor) {
            this.valor = valor;
        }
    }

    // -------------------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------------------

    // Ponteiro para o primeiro no.
    private No<T> head;

    // Ponteiro para o ultimo no. Permite addLast/removeLast em O(1).
    private No<T> tail;

    private int size;

    // -------------------------------------------------------------------------
    // Consultas basicas
    // -------------------------------------------------------------------------

    public boolean isEmpty()  { return size == 0; }
    public int     size()     { return size; }

    // -------------------------------------------------------------------------
    // Insercao
    // -------------------------------------------------------------------------

    /**
     * Insere no inicio.
     * Complexidade: O(1)
     */
    public void addFirst(T valor) {
        No<T> novo = new No<>(valor);

        if (isEmpty()) {
            head = tail = novo;
        } else {
            novo.proximo  = head;   // novo aponta para o antigo head
            head.anterior = novo;   // antigo head aponta de volta para o novo
            head = novo;            // head avanca para o novo
        }
        size++;
    }

    /**
     * Insere no fim.
     * Complexidade: O(1)  <- vantagem sobre lista simples!
     */
    public void addLast(T valor) {
        No<T> novo = new No<>(valor);

        if (isEmpty()) {
            head = tail = novo;
        } else {
            novo.anterior = tail;   // novo aponta de volta para o antigo tail
            tail.proximo  = novo;   // antigo tail aponta para o novo
            tail = novo;            // tail avanca para o novo
        }
        size++;
    }

    // -------------------------------------------------------------------------
    // Remocao
    // -------------------------------------------------------------------------

    /**
     * Remove o primeiro elemento e retorna seu valor.
     * Complexidade: O(1)
     */
    public T removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("Lista vazia");

        T removido = head.valor;

        if (head == tail) {
            // Unico elemento
            head = tail = null;
        } else {
            head = head.proximo;
            head.anterior = null;   // desconecta do no removido
        }
        size--;
        return removido;
    }

    /**
     * Remove o ultimo elemento e retorna seu valor.
     * Complexidade: O(1)  <- vantagem sobre lista simples!
     */
    public T removeLast() {
        if (isEmpty()) throw new NoSuchElementException("Lista vazia");

        T removido = tail.valor;

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.anterior;
            tail.proximo = null;    // desconecta do no removido
        }
        size--;
        return removido;
    }

    /**
     * Remove a primeira ocorrencia do valor informado.
     * Complexidade: O(n)
     */
    public boolean removeByValue(T valor) {
        No<T> atual = head;

        while (atual != null) {
            boolean igual = (valor == null)
                    ? atual.valor == null
                    : valor.equals(atual.valor);

            if (igual) {
                desconectar(atual);
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    /**
     * Remove um no isolando-o da cadeia.
     * Como temos ponteiro para anterior, nao precisamos percorrer do inicio.
     * Complexidade: O(1) dado o no
     */
    private void desconectar(No<T> no) {
        if (no.anterior != null) {
            no.anterior.proximo = no.proximo;
        } else {
            head = no.proximo;  // era o head
        }

        if (no.proximo != null) {
            no.proximo.anterior = no.anterior;
        } else {
            tail = no.anterior; // era o tail
        }

        size--;
    }

    // -------------------------------------------------------------------------
    // Exibicao
    // -------------------------------------------------------------------------

    /** Exibe da frente para o fim. */
    public void exibirFrenteParaTras() {
        System.out.print("HEAD <-> ");
        No<T> atual = head;
        while (atual != null) {
            System.out.print(atual.valor);
            if (atual.proximo != null) System.out.print(" <-> ");
            atual = atual.proximo;
        }
        System.out.println(" <-> null");
    }

    /** Exibe do fim para a frente (possivel gracias ao ponteiro anterior). */
    public void exibirTrasParaFrente() {
        System.out.print("TAIL <-> ");
        No<T> atual = tail;
        while (atual != null) {
            System.out.print(atual.valor);
            if (atual.anterior != null) System.out.print(" <-> ");
            atual = atual.anterior;
        }
        System.out.println(" <-> null");
    }

    // =========================================================================
    // DEMO
    // =========================================================================

    public static void main(String[] args) {

        // =====================================================================
        // PARTE 1 - Lista Duplamente Encadeada
        // =====================================================================
        System.out.println("=== LISTA DUPLAMENTE ENCADEADA ===\n");

        ListaDuplamenteEncadeada<Integer> dupla = new ListaDuplamenteEncadeada<>();

        dupla.addLast(10);
        dupla.addLast(20);
        dupla.addLast(30);
        dupla.addFirst(5);   // insere antes do 10

        System.out.println("Apos insercoes:");
        dupla.exibirFrenteParaTras();   // 5 <-> 10 <-> 20 <-> 30
        dupla.exibirTrasParaFrente();   // 30 <-> 20 <-> 10 <-> 5

        System.out.println("\nRemovendo primeiro: " + dupla.removeFirst()); // 5
        System.out.println("Removendo ultimo : " + dupla.removeLast());    // 30
        dupla.exibirFrenteParaTras();   // 10 <-> 20

        System.out.println("\nRemovendo valor 20: " + dupla.removeByValue(20));
        dupla.exibirFrenteParaTras();   // 10

        // =====================================================================
        // PARTE 2 - Lista Circular Simplesmente Encadeada
        // =====================================================================
        System.out.println("\n=== LISTA CIRCULAR SIMPLESMENTE ENCADEADA ===\n");

        ListaCircular<Integer> circular = new ListaCircular<>();

        circular.add(1);
        circular.add(2);
        circular.add(3);
        circular.add(4);
        circular.add(5);

        System.out.println("Lista circular (5 voltas a partir do head):");
        circular.exibir(5); // gira 1 x tamanho

        System.out.println("\nRemovendo 3:");
        circular.remove(3);
        circular.exibir(4);

        System.out.println("\nJogo de Josephus com 5 pessoas, saindo a cada 3 passos:");
        ListaCircular.josephus(5, 3);
    }
}


// =============================================================================
// Lista Circular Simplesmente Encadeada
//
// O ULTIMO no aponta de volta para o HEAD, formando um ciclo.
//
//   head -> [1] -> [2] -> [3]
//             ^-----------/
//
// Uso tipico: revezamento, jogos em roda, round-robin de processos.
// =============================================================================

class ListaCircular<T> {

    private static class No<T> {
        T valor;
        No<T> proximo;
        No(T valor) { this.valor = valor; }
    }

    private No<T> head;
    private int   size;

    public boolean isEmpty() { return size == 0; }
    public int     size()    { return size; }

    /**
     * Adiciona no fim da lista circular.
     * Mantemos um ponteiro 'tail' local percorrendo ate o ultimo no.
     * Complexidade: O(n). Para O(1) guardar-se-ia referencia ao tail.
     */
    public void add(T valor) {
        No<T> novo = new No<>(valor);

        if (isEmpty()) {
            head = novo;
            novo.proximo = head;    // aponta para si mesmo -> primeiro ciclo
        } else {
            No<T> atual = head;
            while (atual.proximo != head) {
                atual = atual.proximo;
            }
            atual.proximo = novo;   // penultimo aponta para o novo
            novo.proximo  = head;   // novo aponta de volta para o head
        }
        size++;
    }

    /**
     * Remove a primeira ocorrencia do valor.
     * Complexidade: O(n)
     */
    public boolean remove(T valor) {
        if (isEmpty()) return false;

        // Caso especial: remover o head
        if (head.valor.equals(valor)) {
            if (size == 1) {
                head = null;
            } else {
                // Encontra o tail para redirecionar o ciclo
                No<T> tail = head;
                while (tail.proximo != head) tail = tail.proximo;
                head = head.proximo;
                tail.proximo = head;    // tail volta a apontar para o novo head
            }
            size--;
            return true;
        }

        // Caso geral
        No<T> atual = head;
        while (atual.proximo != head) {
            if (atual.proximo.valor.equals(valor)) {
                atual.proximo = atual.proximo.proximo; // pula o no removido
                size--;
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    /**
     * Exibe 'voltas' nos a partir do head.
     * Como a lista e circular, podemos girar quantas vezes quisermos.
     */
    public void exibir(int voltas) {
        if (isEmpty()) { System.out.println("(vazia)"); return; }

        No<T> atual = head;
        System.out.print("HEAD -> ");
        for (int i = 0; i < voltas; i++) {
            System.out.print(atual.valor);
            if (i < voltas - 1) System.out.print(" -> ");
            atual = atual.proximo;
        }
        System.out.println(" -> (volta ao HEAD)");
    }

    /**
     * Problema de Josephus:
     * n pessoas em roda; elimina-se a cada 'passo' posicoes.
     * Quem sobra?
     *
     * Exemplo classico de uso da lista circular.
     */
    public static void josephus(int n, int passo) {
        ListaCircular<Integer> roda = new ListaCircular<>();
        for (int i = 1; i <= n; i++) roda.add(i);

        No<Integer> atual = roda.head;

        System.out.print("Ordem de eliminacao: ");
        while (roda.size() > 1) {
            // Anda (passo - 1) nos alem do atual
            for (int i = 1; i < passo; i++) {
                atual = atual.proximo;
            }
            System.out.print(atual.valor + " ");
            No<Integer> proximo = atual.proximo;
            roda.remove(atual.valor);
            atual = proximo;
        }
        System.out.println();
        System.out.println("Sobrevivente: " + roda.head.valor);
    }
}