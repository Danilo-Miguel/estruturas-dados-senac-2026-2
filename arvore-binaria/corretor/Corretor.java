import java.util.Arrays;

public class Corretor {
    private int testes;
    private int aprovados;

    public static void main(String[] args) {
        new Corretor().executar();
    }

    private void executar() {
        ArvoreBinaria arvoreA = new ArvoreBinaria();
        int[] valoresA = {8, 4, 12, 2, 6, 10, 14};
        for (int valor : valoresA) {
            arvoreA.inserir(valor);
        }

        verificar("contarNos", 7, arvoreA.contarNos());
        verificar("contarFolhas", 4, arvoreA.contarFolhas());
        verificar("altura", 2, arvoreA.altura());
        verificar("buscaExiste", true, arvoreA.buscar(10));
        verificar("buscaNaoExiste", false, arvoreA.buscar(5));
        verificar("balanceada", true, arvoreA.estaBalanceada());
        verificar("emOrdem", new int[]{2, 4, 6, 8, 10, 12, 14}, arvoreA.emOrdem());
        verificar("maximo", 14, arvoreA.maximo());
        verificar("profRaiz", 0, arvoreA.profundidade(8));
        verificar("profMeio", 1, arvoreA.profundidade(12));
        verificar("profFolha", 2, arvoreA.profundidade(6));
        verificar("profAusente", -1, arvoreA.profundidade(99));
        verificar("conexoes", 6, arvoreA.contarConexoes());
        arvoreA.inserir(8);
        verificar("inserirDuplicado", 7, arvoreA.contarNos());

        ArvoreBinaria arvoreB = new ArvoreBinaria();
        int[] valoresB = {1, 2, 3, 4};
        for (int valor : valoresB) {
            arvoreB.inserir(valor);
        }

        verificar("alturaDegenerada", 3, arvoreB.altura());
        verificar("naoBalanceada", false, arvoreB.estaBalanceada());
        verificar("folhasDegenerada", 1, arvoreB.contarFolhas());
        verificar("emOrdemDegenerada", new int[]{1, 2, 3, 4}, arvoreB.emOrdem());

        ArvoreBinaria arvoreC = new ArvoreBinaria();
        verificar("vaziaNos", 0, arvoreC.contarNos());
        verificar("vaziaAltura", -1, arvoreC.altura());
        verificar("vaziaBalanceada", true, arvoreC.estaBalanceada());
        verificar("vaziaEmOrdem", 0, arvoreC.emOrdem().length);
        verificar("vaziaConexoes", 0, arvoreC.contarConexoes());

        String resultado = aprovados == testes ? "APROVADO" : "REPROVADO";
        System.out.println(resultado + ": " + aprovados + "/" + testes + " testes");
        System.exit(aprovados == testes ? 0 : 1);
    }

    private void verificar(String nome, int esperado, int obtido) {
        verificar(nome, esperado == obtido,
                Integer.toString(esperado), Integer.toString(obtido));
    }

    private void verificar(String nome, boolean esperado, boolean obtido) {
        verificar(nome, esperado == obtido,
                Boolean.toString(esperado), Boolean.toString(obtido));
    }

    private void verificar(String nome, int[] esperado, int[] obtido) {
        verificar(nome, Arrays.equals(esperado, obtido),
                Arrays.toString(esperado), Arrays.toString(obtido));
    }

    private void verificar(String nome, boolean passou, String esperado, String obtido) {
        testes++;
        if (passou) {
            aprovados++;
            System.out.println("[OK] " + nome);
        } else {
            System.out.println("[FALHOU] " + nome
                    + " (esperado " + esperado + ", obtido " + obtido + ")");
        }
    }
}
