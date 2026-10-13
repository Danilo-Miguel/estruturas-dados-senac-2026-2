package com.example;

/**
 * Exemplo simples para apresentar conceitos basicos de arvores.
 *
 * A proposta aqui e montar a estrutura aos poucos, para deixar visivel a
 * construcao em etapas: primeiro a raiz, depois os filhos e por fim os netos.
 */
public class ArvoreExemploSimples {

    /**
     * Representa um no de uma arvore generica.
     *
     * Neste primeiro contato, um no guarda:
     * - um nome;
     * - uma lista de filhos.
     *
     * Essa ideia e suficiente para estudar raiz, no, folha, altura e profundidade.
     */

        /**
         * Adiciona um filho ao no atual.
         *
         * @param filho no que sera ligado como filho
         */
      
    }

    /**
     * Verifica se um no e folha.
     *
     * Folha e o no que nao possui filhos.
     *
     * @param no no que sera analisado
     * @return true quando o no nao tem filhos; false caso contrario
     */
    public static boolean ehFolha(No no) {
        // Se o no nem existe, retornamos false neste material.
        if (no == null) {
            return false;
        }

        // Um no e folha quando sua lista de filhos esta vazia.
        return no.getFilhos().isEmpty();
    }

    /**
     * Conta quantos nos existem na arvore.
     *
     * @param raiz inicio da subarvore analisada
     * @return quantidade total de nos
     */
    public static int contarNos(No raiz) {
        // Arvore vazia nao tem nos.
        if (raiz == null) {
            return 0;
        }

        // Comecamos contando o proprio no atual.
        int total = 1;

        // Depois somamos a quantidade de nos de cada filho.
        for (No filho : raiz.getFilhos()) {
            total += contarNos(filho);
        }

        // Retorna a soma final.
        return total;
    }

    /**
     * Conta quantas folhas existem na arvore.
     *
     * @param raiz inicio da subarvore analisada
     * @return quantidade de folhas
     */
    public static int contarFolhas(No raiz) {
        // Se nao existe no, nao existe folha.
        if (raiz == null) {
            return 0;
        }

        // Se o no atual nao tem filhos, ele mesmo ja e uma folha.
        if (ehFolha(raiz)) {
            return 1;
        }

        // Acumula a quantidade de folhas encontradas nos filhos.
        int totalFolhas = 0;

        // Percorre cada filho e soma as folhas dele.
        for (No filho : raiz.getFilhos()) {
            totalFolhas += contarFolhas(filho);
        }

        // Retorna a quantidade final de folhas.
        return totalFolhas;
    }

    /**
     * Calcula a altura da arvore.
     *
     * Aqui a altura sera a quantidade de arestas no caminho mais longo da raiz
     * ate uma folha.
     *
     * @param raiz inicio da subarvore analisada
     * @return altura da arvore
     */
    public static int altura(No raiz) {
        // Arvore vazia tem altura -1 para manter folha com altura 0.
        if (raiz == null) {
            return -1;
        }

        // Se nao tem filhos, o no atual ja e uma folha.
        if (ehFolha(raiz)) {
            return 0;
        }

        // Guarda a maior altura encontrada entre os filhos.
        int maiorAlturaDosFilhos = -1;

        // Calcula a altura de cada filho.
        for (No filho : raiz.getFilhos()) {
            int alturaDoFilho = altura(filho);

            // Atualiza a maior altura quando encontrar um valor maior.
            if (alturaDoFilho > maiorAlturaDosFilhos) {
                maiorAlturaDosFilhos = alturaDoFilho;
            }
        }

        // Soma 1 para considerar a descida do no atual ate o filho mais profundo.
        return 1 + maiorAlturaDosFilhos;
    }

    /**
     * Encontra a profundidade de um no a partir do nome.
     *
     * @param raiz inicio da subarvore analisada
     * @param nomeProcurado nome do no desejado
     * @param nivelAtual profundidade acumulada ate o momento
     * @return profundidade do no, ou -1 se ele nao existir
     */
    public static int profundidade(No raiz, String nomeProcurado, int nivelAtual) {
        // Se o caminho terminou, o no nao foi encontrado aqui.
        if (raiz == null) {
            return -1;
        }

        // Se encontramos o nome, devolvemos a profundidade atual.
        if (raiz.getNome().equals(nomeProcurado)) {
            return nivelAtual;
        }

        // Procura o no desejado em cada filho.
        for (No filho : raiz.getFilhos()) {
            int resultado = profundidade(filho, nomeProcurado, nivelAtual + 1);

            // Se encontrou em algum filho, devolve o resultado imediatamente.
            if (resultado != -1) {
                return resultado;
            }
        }

        // Se nenhum filho continha o nome, retornamos -1.
        return -1;
    }

    /**
     * Exibe a arvore com recuo para mostrar a hierarquia.
     *
     * @param raiz inicio da subarvore a ser exibida
     * @param nivel nivel atual de recuo
     */
    public static void exibirArvore(No raiz, int nivel) {
        // Se nao existe no, nao ha nada para mostrar.
        if (raiz == null) {
            return;
        }

        // Imprime dois espacos por nivel para destacar a hierarquia.
        for (int i = 0; i < nivel; i++) {
            System.out.print("  ");
        }

        // Mostra o nome do no atual.
        System.out.println("- " + raiz.getNome());

        // Exibe cada filho em um nivel abaixo.
        for (No filho : raiz.getFilhos()) {
            exibirArvore(filho, nivel + 1);
        }
    }

    /**
     * Metodo principal com construcao gradual da arvore.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {
        // PASSO 1: criar somente a raiz.
        No raiz = new No("Empresa");

        // PASSO 2: criar os filhos diretos da raiz.
        No financeiro = new No("Financeiro");
        No vendas = new No("Vendas");
        No suporte = new No("Suporte");

        // PASSO 3: ligar os filhos diretos na raiz.
        raiz.adicionarFilho(financeiro);
        raiz.adicionarFilho(vendas);
        raiz.adicionarFilho(suporte);

        // PASSO 4: criar nos de um nivel mais abaixo.
        No contas = new No("Contas");
        No cobranca = new No("Cobranca");
        No lojaFisica = new No("Loja Fisica");
        No lojaOnline = new No("Loja Online");

        // PASSO 5: ligar os novos nos aos seus pais.
        financeiro.adicionarFilho(contas);
        financeiro.adicionarFilho(cobranca);
        vendas.adicionarFilho(lojaFisica);
        vendas.adicionarFilho(lojaOnline);

        // Desenho aproximado da arvore montada:
        //
        // Empresa
        // |- Financeiro
        // |  |- Contas
        // |  \- Cobranca
        // |- Vendas
        // |  |- Loja Fisica
        // |  \- Loja Online
        // \- Suporte

        // Mostra a estrutura inteira para facilitar a visualizacao.
        System.out.println("Arvore montada em etapas:\n");
        exibirArvore(raiz, 0);

        // Explica quem e a raiz.
        System.out.println("\nRaiz: " + raiz.getNome());

        // Mostra a quantidade total de nos.
        System.out.println("Quantidade total de nos: " + contarNos(raiz));

        // Mostra a quantidade de folhas.
        System.out.println("Quantidade de folhas: " + contarFolhas(raiz));

        // Mostra a altura da arvore.
        System.out.println("Altura da arvore: " + altura(raiz));

        // Mostra profundidades de alguns nos.
        System.out.println("Profundidade de Empresa: " + profundidade(raiz, "Empresa", 0));
        System.out.println("Profundidade de Vendas: " + profundidade(raiz, "Vendas", 0));
        System.out.println("Profundidade de Loja Online: " + profundidade(raiz, "Loja Online", 0));

        // Mostra exemplos de folha e de no interno.
        System.out.println("\nContas e folha? " + ehFolha(contas));
        System.out.println("Financeiro e folha? " + ehFolha(financeiro));
    }
}
