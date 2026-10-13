private  class No {
    // Nome do no, usado para facilitar a leitura do exemplo.
    private String nome;

    // Lista com os filhos do no atual.
    private List<No> filhos;

    /**
     * Cria um no com o nome informado.
     *
     * @param nome texto que identifica o no
     */
    private No(String nome) {
        // Guarda o nome recebido.
        this.nome = nome;

        // Comeca com lista vazia, pois no inicio o no ainda nao tem filhos.
        this.filhos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<No> getFilhos() {
        return filhos;
    }

    public void setFilhos(List<No> filhos) {
        this.filhos = filhos;
    }
