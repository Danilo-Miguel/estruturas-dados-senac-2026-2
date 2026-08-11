package com.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        calculateSum(5, 10, "Danilo");
    }

  public static void calculateSum(int a, int b, String userName) {
        System.out.println(a + b + " " + userName);
    }  
}