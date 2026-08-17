package com.example; // este arquivo pertence ao pacote com.example

public class Main { // classe principal, é ela que o Java executa primeiro

    public static void main(String[] args) { // método main: ponto de entrada do programa
        System.out.println("Hello world!"); // imprime um texto fixo no console

        calculateSum(5, 10, "Danilo"); // chama o método de soma com 5 e 10
        calculateSum(2, 3, "Alice");   // chama de novo, com outros números

        // ---- Encapsulamento: usando a classe Calculadora ----
        Calculadora calculadora = new Calculadora(10, 5); // cria o objeto (10 e 5 vão para os atributos privados via o construtor)
        System.out.println("Soma: " + calculadora.somar());               // pede pra calculadora somar e imprime o resultado
        System.out.println("Subtração: " + calculadora.subtrair());       // idem, para subtração
        System.out.println("Multiplicação: " + calculadora.multiplicar());// idem, para multiplicação
        System.out.println("Divisão: " + calculadora.dividir());          // idem, para divisão

        calculadora.setPrimeiroValor(20); // troca o primeiro valor usando o setter (não dá pra fazer calculadora.primeiroValor = 20 direto, é private)
        calculadora.setSegundoValor(4);   // troca o segundo valor usando o setter
        System.out.println("Resultado atualizado: " + calculadora.getResultado()); // getResultado só lê; ainda mostra o resultado da última operação
        System.out.println("Nova divisão: " + calculadora.dividir()); // agora sim recalcula com os valores novos (20 / 4)

        // ---- Complexidade: busca linear (O(n)) x busca binária (O(log n)) ----
        int[] numeros = {5, 12, 18, 23, 31, 40, 55, 62, 70, 89}; // array já ordenado, necessário para a busca binária
        System.out.println("Busca linear (índice de 62): " + Busca.buscaLinear(numeros, 62));  // percorre item por item até achar
        System.out.println("Busca binária (índice de 62): " + Busca.buscaBinaria(numeros, 62)); // vai "cortando o array ao meio"
    }

    public static void calculateSum(int a, int b, String userName) { // recebe dois números e um nome
        System.out.println(a + b + " " + userName); // soma os números e imprime junto com o nome
    }
}
