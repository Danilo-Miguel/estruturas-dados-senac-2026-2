public class ArvoreBinaria {
    No raiz;

    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    private No inserirRec(No no, int valor) {
        if (no == null) {
            return new No(valor);
        }
        if (valor < no.valor) {
            no.esquerda = inserirRec(no.esquerda, valor);
        } else if (valor > no.valor) {
            no.direita = inserirRec(no.direita, valor);
        }
        
        return no;
    }

    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(No no, int valor) {
        if (no == null) {
            return false;
        }
        if (valor == no.valor) {
            return true;
        }
        
        if (valor < no.valor){
            return buscarRec(no.esquerda, valor);
        } else {
            return buscarRec(no.direita, valor);
        }
    }

    public int contarNos(){
        return contarNosRec(raiz);
    }

    private int contarNosRec(No no) {
        if (no == null) {
            return 0;
        }
        return 1 + contarNosRec(no.esquerda) + contarNosRec(no.direita);
    }

    public int contarFolhas() {
        return contarFolhasRec(raiz);
    }

    private int contarFolhasRec(No no){
        if (no == null) {
            return 0;
        }
        
        if (no.esquerda == null && no.direita == null) {
            return 1;
        }
        
        return contarFolhasRec(no.esquerda) + contarFolhasRec(no.direita);
    }

    public int altura(){
        return alturaRec(raiz);
    }

    private int alturaRec(No no){
        if (no == null) {
            return -1;
        }
        
        int alturaEsquerda = alturaRec(no.esquerda);
        int alturaDireita = alturaRec(no.direita);
        
        return Math.max(alturaEsquerda, alturaDireita) + 1;
    }

    public boolean estaBalanceada() {
        return estaBalanceadaRec(raiz);
    }

    private boolean estaBalanceadaRec(No no) {
        if (no == null) {
            return true;
        }
        
        int alturaEsquerda = alturaRec(no.esquerda);
        int alturaDireita = alturaRec(no.direita);
        
        if (Math.abs(alturaEsquerda - alturaDireita) <= 1 
            && estaBalanceadaRec(no.esquerda) 
            && estaBalanceadaRec(no.direita)) {
            return true;
        }
        
        return false;
    }

    public int[] emOrdem() {
        java.util.ArrayList<Integer> lista = new java.util.ArrayList<>();
        emOrdemRec(raiz, lista);
        
        int[] resultado = new int[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            resultado[i] = lista.get(i);
        }
        return resultado;
    }

    private void emOrdemRec(No no, java.util.ArrayList<Integer> lista) {
        if (no != null) {
            emOrdemRec(no.esquerda, lista);
            lista.add(no.valor);
            emOrdemRec(no.direita, lista);
        }
    }

    public int maximo() {
        No atual = raiz;
        while (atual.direita != null) {
            atual = atual.direita;
        }
        return atual.valor;
    }

    public int profundidade(int valor) {
        return profundidadeRec(raiz, valor, 0);
    }

    private int profundidadeRec(No no, int valor, int nivelAtual){
        if (no == null) {
            return -1;
        }
        
        if (valor == no.valor) {
            return nivelAtual;
        }
        
        if (valor < no.valor) {
            return profundidadeRec(no.esquerda, valor, nivelAtual + 1);
        } else {
            return profundidadeRec(no.direita, valor, nivelAtual + 1);
        }
    }

    public int contarConexoes(){
        int totalNos = contarNos();
        
        if (totalNos == 0) {
            return 0;
        }
        
        return totalNos - 1;
    }

}