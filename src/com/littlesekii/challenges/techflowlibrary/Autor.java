package com.littlesekii.challenges.techflowlibrary;

public record Autor(String nome,  String nacionalidade, int anoNascimento) {
    @Override
    public String toString() {
        return nome + "(" + nacionalidade + ", " + anoNascimento + ")";
    }
}
