package com.example;

public class ArvoreDemo extends ArvoreBase<String> {
    
    @Override 
    public void demonstrar() {
        NoArvore<String> empresa = new NoArvore<>("Empresa");
        definirRaiz(empresa);

        NoArvore<String> financeiro = new NoArvore<>("Financeiro");
        empresa.adicionarFilho(financeiro);

        NoArvore<String> contas = new NoArvore<>("Contas");
        financeiro.adicionarFilho(contas);
        exibirResumo();

        //----------//

        NoArvore<String> senac = new NoArvore<>("Senac");
        definirRaiz(senac);

        NoArvore<String> disciplinas = new NoArvore<>("Estruturas de Dados");
        senac.adicionarFilho(disciplinas);

        NoArvore<String> provas = new NoArvore<>("P1");
        disciplinas.adicionarFilho(provas);

        NoArvore<String> notas = new NoArvore<>("10");
        provas.adicionarFilho(notas);
        exibirResumo();
    }

    public static void main(String[] args) {
        new ArvoreDemo().executarDemonstracao();
    }
}