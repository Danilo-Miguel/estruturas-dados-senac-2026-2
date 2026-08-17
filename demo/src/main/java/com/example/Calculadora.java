package com.example;

public class Calculadora {

    private double primeiroValor;
    private double segundoValor;

    // Atributo somente leitura: tem getter, mas NÃO tem setter.
    // O único jeito de mudar o resultado é executando uma operação.
    private double resultado;

    public Calculadora(double primeiroValor, double segundoValor) {
        setPrimeiroValor(primeiroValor);
        setSegundoValor(segundoValor);
    }

    public double getPrimeiroValor() {
        return primeiroValor;
    }

    public void setPrimeiroValor(double primeiroValor) {
        this.primeiroValor = primeiroValor;
    }

    public double getSegundoValor() {
        return segundoValor;
    }

    public void setSegundoValor(double segundoValor) {
        this.segundoValor = segundoValor;
    }

    public double getResultado() {
        return resultado;
    }

    public double somar() {
        resultado = primeiroValor + segundoValor;
        return resultado;
    }

    public double subtrair() {
        resultado = primeiroValor - segundoValor;
        return resultado;
    }

    public double multiplicar() {
        resultado = primeiroValor * segundoValor;
        return resultado;
    }

    public double dividir() {
        if (segundoValor == 0) {
            throw new ArithmeticException("Não é possível dividir por zero.");
        }
        resultado = primeiroValor / segundoValor;
        return resultado;
    }
}
