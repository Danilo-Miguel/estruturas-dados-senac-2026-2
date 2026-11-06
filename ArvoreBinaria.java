import java.util.ArrayList;
import java.util.List;

public class ArvoreBinaria {
    public No raiz;

    // Tarefa 1: insere na posição certa; repetido é ignorado
    public void inserir(int valor) {
        raiz = inserir(raiz, valor);
    }

    private No inserir(No atual, int valor) {
        if (atual == null) {
            return new No(valor);
        }
        if (valor < atual.valor) {
            atual.esquerda = inserir(atual.esquerda, valor);
        } else if (valor > atual.valor) {
            atual.direita = inserir(atual.direita, valor);
        }
        return atual;
    }

    // Tarefa 2: true se o valor existe
    public boolean buscar(int valor) {
        No atual = raiz;
        while (atual != null) {
            if (valor == atual.valor) {
                return true;
            }
            atual = (valor < atual.valor) ? atual.esquerda : atual.direita;
        }
        return false;
    }

    // Tarefa 3: total de nós
    public int contarNos() {
        return contarNos(raiz);
    }

    private int contarNos(No no) {
        if (no == null) {
            return 0;
        }
        return 1 + contarNos(no.esquerda) + contarNos(no.direita);
    }

    // Tarefa 4: nós sem filhos
    public int contarFolhas() {
        return contarFolhas(raiz);
    }

    private int contarFolhas(No no) {
        if (no == null) {
            return 0;
        }
        if (no.esquerda == null && no.direita == null) {
            return 1;
        }
        return contarFolhas(no.esquerda) + contarFolhas(no.direita);
    }

    // Tarefa 5: arestas no caminho mais longo (vazia = -1, só raiz = 0)
    public int altura() {
        return altura(raiz);
    }

    private int altura(No no) {
        if (no == null) {
            return -1;
        }
        return 1 + Math.max(altura(no.esquerda), altura(no.direita));
    }

    // Tarefa 6: diferença de altura <= 1 em TODO nó
    public boolean estaBalanceada() {
        return verificarBalanceamento(raiz) != -2;
    }

    // devolve a altura, ou -2 se encontrar um nó desbalanceado
    private int verificarBalanceamento(No no) {
        if (no == null) {
            return -1;
        }
        int esq = verificarBalanceamento(no.esquerda);
        if (esq == -2) {
            return -2;
        }
        int dir = verificarBalanceamento(no.direita);
        if (dir == -2) {
            return -2;
        }
        if (Math.abs(esq - dir) > 1) {
            return -2;
        }
        return 1 + Math.max(esq, dir);
    }

    // Tarefa 7: percurso em-ordem (esquerda, raiz, direita)
    public int[] emOrdem() {
        List<Integer> lista = new ArrayList<>();
        emOrdem(raiz, lista);
        int[] resultado = new int[lista.size()];
        for (int i = 0; i < resultado.length; i++) {
            resultado[i] = lista.get(i);
        }
        return resultado;
    }

    private void emOrdem(No no, List<Integer> lista) {
        if (no == null) {
            return;
        }
        emOrdem(no.esquerda, lista);
        lista.add(no.valor);
        emOrdem(no.direita, lista);
    }

    // Tarefa 8: maior valor (nó mais à direita); assume árvore não vazia
    public int maximo() {
        No atual = raiz;
        while (atual.direita != null) {
            atual = atual.direita;
        }
        return atual.valor;
    }

    // Tarefa 9: profundidade do nó (raiz = 0); -1 se não existir
    public int profundidade(int valor) {
        No atual = raiz;
        int nivel = 0;
        while (atual != null) {
            if (valor == atual.valor) {
                return nivel;
            }
            atual = (valor < atual.valor) ? atual.esquerda : atual.direita;
            nivel++;
        }
        return -1;
    }

    // Tarefa 10: n nós => n-1 arestas; vazia = 0
    public int contarConexoes() {
        int n = contarNos();
        return n == 0 ? 0 : n - 1;
    }
}