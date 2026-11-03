public class ArvoreBinaria {
    No raiz;

    void inserir(int valor) {
        raiz = inserir(raiz, valor);
    }

    private No inserir(No no, int valor) {
        if(no== null) {
            return new No(valor);
        }
        if(valor < no.valor) {
            no.esquerda = inserir(no.esquerda, valor);
        } else if(valor > no.valor) {
            no.direita = inserir(no.direita, valor);
        }

        return no;
    }

    public boolean buscar(int valor) {
        return buscar(raiz, valor);
    }

    private boolean buscar(No no, int valor) {
        if(no == null) {
            return false;
        }
        if(valor == no.valor) {
            return true;
        } else if(valor < no.valor) {
            return buscar(no.esquerda, valor);
        } else {
            return buscar(no.direita, valor);
        }
    }
    
    public int contarNos() {
        return contarNos(raiz);
    }


    private int contarNos(No no) {
        if(no == null) {
            return 0;
        }
        return 1 + contarNos(no.esquerda) + contarNos(no.direita);
    }

    public int contarFolhas() {
        return contarFolhas(raiz);
    }

    private int contarFolhas(No no) {
        if(no == null) {
            return 0;
        }
        if(no.esquerda == null && no.direita == null) {
            return 1;
        }
        return contarFolhas(no.esquerda) + contarFolhas(no.direita);
    }

    public int altura() {
        return altura(raiz);
    }

    private int altura(No no) {
        if(no == null) {
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
        if(no == null) {
            return true;
        }
        int alturaEsquerda = altura(no.esquerda);
        int alturaDireita = altura(no.direita);
        if(Math.abs(alturaEsquerda - alturaDireita) > 1) {
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
        if(no == null) {
            return index;
        }
        index = emOrdem(no.esquerda, resultado, index);
        resultado[index++] = no.valor;
        index = emOrdem(no.direita, resultado, index);
        return index;
    }

    public int maximo() {
        if(raiz == null) {
            throw new IllegalStateException("A árvore está vazia");
        }
        return maximo(raiz);
    }

    private int maximo(No no) {
        if(no.direita == null) {
            return no.valor;
        }
        return maximo(no.direita);
    }

    public int profundidade(int valor) {
        return profundidade(raiz, valor, 0);
    }

    private int profundidade(No no, int valor, int profundidade) {
        if(no == null) {
            return -1;
        }
        if(valor == no.valor) {
            return profundidade;
        } else if(valor < no.valor) {
            return profundidade(no.esquerda, valor, profundidade + 1);
        } else {
            return profundidade(no.direita, valor, profundidade + 1);
        }
    }

    public int contarConexoes() {
        return contarConexoes(raiz);
    }

    private int contarConexoes(No no) {
        if(no == null) {
            return 0;
        }
        int conexoes = 0;
        if(no.esquerda != null) {
            conexoes++;
        }
        if(no.direita != null) {
            conexoes++;
        }
        return conexoes + contarConexoes(no.esquerda) + contarConexoes(no.direita);
    }

}
