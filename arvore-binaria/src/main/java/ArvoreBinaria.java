import java.util.ArrayList;
import java.util.List;

public class ArvoreBinaria {
    public No raiz;

  
    public void inserir(int valor) {
        if (raiz == null) {
            raiz = new No(valor);
            return;
        }
        No atual = raiz;
        while (true) {
            if (valor < atual.valor) {
                if (atual.esquerda == null) {
                    atual.esquerda = new No(valor);
                    return;
                }
                atual = atual.esquerda;
            } else if (valor > atual.valor) {
                if (atual.direita == null) {
                    atual.direita = new No(valor);
                    return;
                }
                atual = atual.direita;
            } else {
                return; 
            }
        }
    }

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
        return 1 + Math.max(altura(no.esquerda), altura(no.direita));
    }

 
    public boolean estaBalanceada() {
        return alturaOuDesbalanceada(raiz) != -2;
    }


    
   
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

    private int alturaOuDesbalanceada(No no) {
        if (no == null) {
            return -1;
        }
        int esq = alturaOuDesbalanceada(no.esquerda);
        if (esq == -2) {
            return -2;
        }
        int dir = alturaOuDesbalanceada(no.direita);
        if (dir == -2) {
            return -2;
        }
        if (Math.abs(esq - dir) > 1) {
            return -2;
        }
        return 1 + Math.max(esq, dir);
    }
//oi

    
    public int maximo() {
        No atual = raiz;
        while (atual.direita != null) {
            atual = atual.direita;
        }
        return atual.valor;
    }

    
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

   
    public int contarConexoes() {
        int n = contarNos();
        return n == 0 ? 0 : n - 1;
    }
}