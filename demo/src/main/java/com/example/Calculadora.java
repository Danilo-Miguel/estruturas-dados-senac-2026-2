package com.example; // mesmo pacote do Main

public class Calculadora { // classe que representa uma calculadora simples

    private double primeiroValor; // atributo PRIVADO: ninguém de fora acessa direto (encapsulamento)
    private double segundoValor;  // atributo PRIVADO também

    // resultado também é privado, mas repare: só existe getResultado() lá embaixo,
    // não existe setResultado(). Ou seja: dá pra ler de fora, mas não pra escrever direto.
    // Só uma operação (somar, subtrair, multiplicar, dividir) pode mudar esse valor.
    private double resultado;

    public Calculadora(double primeiroValor, double segundoValor) { // construtor: roda quando fazemos "new Calculadora(...)"
        setPrimeiroValor(primeiroValor); // usa o próprio setter pra guardar o valor recebido
        setSegundoValor(segundoValor);   // idem para o segundo valor
    }

    public double getPrimeiroValor() { // getter: método público que devolve o valor do atributo privado
        return primeiroValor;
    }

    public void setPrimeiroValor(double primeiroValor) { // setter: método público que altera o atributo privado
        this.primeiroValor = primeiroValor; // "this.primeiroValor" é o atributo da classe; "primeiroValor" é o parâmetro recebido
    }

    public double getSegundoValor() { // getter do segundo valor
        return segundoValor;
    }

    public void setSegundoValor(double segundoValor) { // setter do segundo valor
        this.segundoValor = segundoValor;
    }

    public double getResultado() { // só leitura: não existe setResultado()
        return resultado;
    }

    public double somar() { // operação 1: soma os dois valores guardados
        resultado = primeiroValor + segundoValor; // guarda o resultado no atributo
        return resultado; // e também devolve pra quem chamou
    }

    public double subtrair() { // operação 2: subtração
        resultado = primeiroValor - segundoValor;
        return resultado;
    }

    public double multiplicar() { // operação 3: multiplicação
        resultado = primeiroValor * segundoValor;
        return resultado;
    }

    public double dividir() { // operação 4: divisão
        if (segundoValor == 0) { // proteção: não existe divisão por zero
            throw new ArithmeticException("Não é possível dividir por zero."); // interrompe o programa com uma mensagem clara
        }
        resultado = primeiroValor / segundoValor;
        return resultado;
    }
}
