package com.littlesekii.challenges.techflowlibrary;

public interface Emprestavel {
    boolean realizarEmprestimo(String matricula) throws MaterialIndisponivelException;
    boolean realizarDevolucao();
    double calcularMulta(int diasAtraso);
}
