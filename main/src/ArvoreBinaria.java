import java.util.ArrayList;
import java.util.List;

public class ArvoreBinaria {

    // teste

    No raiz;

    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    private No inserirRecursivo(No no, int valor) {
        if (no == null) {
            return new No(valor);
        }
        if (valor < no.valor) {
            no.esquerda = inserirRecursivo(no.esquerda, valor);
        } else if (valor > no.valor) {
            no.direita = inserirRecursivo(no.direita, valor);
        }
        return no;
    }

    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(No no, int valor) {
        if (no == null) {
            return false;
        }
        if (valor == no.valor) {
            return true;
        }
        return valor < no.valor ? buscarRecursivo(no.esquerda, valor) : buscarRecursivo(no.direita, valor);
    }

    public int contarNos() {
        return contarNosRecursivo(raiz);
    }

    private int contarNosRecursivo(No no) {
        if (no == null) {
            return 0;
        }
        return 1 + contarNosRecursivo(no.esquerda) + contarNosRecursivo(no.direita);
    }

    public int contarFolhas() {
        return contarFolhasRecursivo(raiz);
    }

    private int contarFolhasRecursivo(No no) {
        if (no == null) {
            return 0;
        }
        if (no.esquerda == null && no.direita == null) {
            return 1;
        }
        return contarFolhasRecursivo(no.esquerda) + contarFolhasRecursivo(no.direita);
    }

    public int altura() {
        return alturaRecursiva(raiz);
    }

    private int alturaRecursiva(No no) {
        if (no == null) {
            return -1;
        }
        int alturaEsquerda = alturaRecursiva(no.esquerda);
        int alturaDireita = alturaRecursiva(no.direita);
        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }

    public boolean estaBalanceada() {
        return estaBalanceadaRecursivo(raiz);
    }

    private boolean estaBalanceadaRecursivo(No no) {
        if (no == null) {
            return true;
        }
        int alturaEsquerda = alturaRecursiva(no.esquerda);
        int alturaDireita = alturaRecursiva(no.direita);
        if (Math.abs(alturaEsquerda - alturaDireita) > 1) {
            return false;
        }
        return estaBalanceadaRecursivo(no.esquerda) && estaBalanceadaRecursivo(no.direita);
    }

    public int[] emOrdem() {
        List<Integer> resultado = new ArrayList<>();
        emOrdemRecursivo(raiz, resultado);
        return resultado.stream().mapToInt(i -> i).toArray();
    }

    private void emOrdemRecursivo(No no, List<Integer> resultado) {
        if (no != null) {
            emOrdemRecursivo(no.esquerda, resultado);
            resultado.add(no.valor);
            emOrdemRecursivo(no.direita, resultado);
        }
    }

    public int maximo() {
        if (raiz == null) {
            throw new IllegalStateException("A árvore está vazia.");
        }
        No atual = raiz;
        while (atual.direita != null) {
            atual = atual.direita;
        }
        return atual.valor;
    }

    private int maximoRecursivo(No no) {
        if (no == null) {
            throw new IllegalStateException("A árvore está vazia.");
        }
        if (no.direita == null) {
            return no.valor;
        }
        return maximoRecursivo(no.direita);
    }

    public int profundidade(int valor) {
        return profundidadeRecursiva(raiz, valor, 0);
    }

    private int profundidadeRecursiva(No no, int valor, int profundidade) {
        if (no == null) {
            return -1;
        }
        if (valor == no.valor) {
            return profundidade;
        }
        int profundidadeEsquerda = profundidadeRecursiva(no.esquerda, valor, profundidade + 1);
        if (profundidadeEsquerda != -1) {
            return profundidadeEsquerda;
        }
        return profundidadeRecursiva(no.direita, valor, profundidade + 1);
    }

    public int contarConexoes() {
        return contarConexoesRecursivo(raiz);
    }

    private int contarConexoesRecursivo(No no) {
        if (no == null) {
            return 0;
        }
        int conexoesEsquerda = contarConexoesRecursivo(no.esquerda);
        int conexoesDireita = contarConexoesRecursivo(no.direita);
        return conexoesEsquerda + conexoesDireita + (no.esquerda != null ? 1 : 0) + (no.direita != null ? 1 : 0);
    }
}