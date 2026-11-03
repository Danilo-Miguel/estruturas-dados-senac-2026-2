public class ArvoreBinaria {
    No raiz;

    void inserir(int valor) {
        raiz = inserir(raiz, valor);
    }

    private No inserir(No no, int valor) {
        if (no == null) {
            return new No(valor);
        }
        if (valor < no.valor) {
            no.esquerda = inserir(no.esquerda, valor);
        } else if (valor > no.valor) {
            no.direita = inserir(no.direita, valor);
        }
        return no;
    }

    public boolean buscar(int valor) {
        No atual = raiz;
        while (atual != null) {
            if (valor == atual.valor) {
                return true;
            } else if (valor < atual.valor) {
                atual = atual.esquerda;
            } else {
                atual = atual.direita;
            }
        }
        return false;
    }

    public int contarNos() {
        return contarNos(raiz);
    }

    private int contarNos(No no) {
        if (no == null) {
            return 0;
        }
        return 1 + contarNos(no.esquerda) + contarNos(no.direita);
    }

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

    public int altura() {
        return altura(raiz);
    }
     
    private int altura(No no) {
        if (no == null) {
            return -1;
        }
        int alturaEsquerda = altura(no.esquerda);
        int alturaDireita = altura(no.direita);
        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }


    public boolean estaBalanceada() {
        return estaBalanceada(raiz);
    }

    private boolean estaBalanceada(No no) {
        if (no == null) {
            return true;
        }
        int alturaEsquerda = altura(no.esquerda);
        int alturaDireita = altura(no.direita);

        if (Math.abs(alturaEsquerda - alturaDireita) > 1) {
            return false;
        }
        return estaBalanceada(no.esquerda) && estaBalanceada(no.direita);
    }

    public int[] emOrdem() {
        int[] resultado = new int[contarNos()];
        emOrdem(raiz, resultado, 0);
        return resultado;
    }

    private int emOrdem(No no, int[] resultado, int index) {
        if (no == null) {
            return index;
        }
        index = emOrdem(no.esquerda, resultado, index);
        resultado[index++] = no.valor;
        index = emOrdem(no.direita, resultado, index);
        return index;
    }

    public int maximo() {
        No atual = raiz;
        while (atual.direita != null) {
            atual = atual.direita;
        }
        return atual.valor;
    }

    public int profundidade(int valor) {
        No atual = raiz;
        int profundidade = 0;
        while (atual != null) {
            if (valor == atual.valor) {
                return profundidade;
            } else if (valor < atual.valor) {
                atual = atual.esquerda;
            } else {
                atual = atual.direita;
            }
            profundidade++;
        }
        return -1;
    }

    public int contarConexoes() {
        int total = contarNos();
        return total == 0 ? 0 : total - 1;
    }
    
}
