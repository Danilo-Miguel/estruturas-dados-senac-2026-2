package com.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        calculateSum(5, 10, "Danilo");
        calculateSum(2, 3, "Alice");

        // Demonstração da Calculadora encapsulada: os atributos primeiroValor e
        // segundoValor só podem ser lidos/alterados pelos getters e setters,
        // e o resultado só pode ser lido (não existe setResultado).
        Calculadora calculadora = new Calculadora(10, 5);
        System.out.println("Soma: " + calculadora.somar());
        System.out.println("Subtração: " + calculadora.subtrair());
        System.out.println("Multiplicação: " + calculadora.multiplicar());
        System.out.println("Divisão: " + calculadora.dividir());

        calculadora.setPrimeiroValor(20);
        calculadora.setSegundoValor(4);
        System.out.println("Resultado atualizado: " + calculadora.getResultado());
        System.out.println("Nova divisão: " + calculadora.dividir());
    }

  public static void calculateSum(int a, int b, String userName) {
        System.out.println(a + b + " " + userName);
    }
}