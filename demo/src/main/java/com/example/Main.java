package com.example;

public class Main {
    public static void main(String[] args) {
        Estacionamento e = new Estacionamento(3);

        e.estacionar("ABC1234");
        e.estacionar("XYZ5678");
        System.out.println(e.placasDisponiveis());
        System.out.println("Livres: " + e.vagasDisponiveis());
        System.out.println("Saiu: " + e.sair());
        
    }
}