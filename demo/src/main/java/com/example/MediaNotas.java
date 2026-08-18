package com.example;

import javax.swing.JOptionPane;

public class MediaNotas {

    private double nota1, nota2, nota3, media;

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public void calcularMedia() {
        // double nota1, nota2, nota3, media;

        setNota1(Double.parseDouble(JOptionPane.showInputDialog("Digite a primeira nota: ")));
        setNota2(Double.parseDouble(JOptionPane.showInputDialog("Digite a segunda nota: ")));
        setNota3(Double.parseDouble(JOptionPane.showInputDialog("Digite a terceira nota: ")));

        setMedia((getNota1() + getNota2() + getNota3()) / 3);
        JOptionPane.showMessageDialog(null, "A média é: " + getMedia());

    }
}