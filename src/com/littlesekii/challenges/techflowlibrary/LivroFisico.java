package com.littlesekii.challenges.techflowlibrary;

import java.time.LocalDate;

public final class LivroFisico extends MaterialBibliografico implements Emprestavel {
    
    class Emprestimo {
        private String matricula;
        private LocalDate data;
        
        public Emprestimo(String matricula, LocalDate data) {
            this.matricula = matricula;
            this.data = data;
        }

        public LocalDate getData() {
            return data;
        }

        public String getMatricula() {
            return matricula;
        }

    }

    private String isbn;

    private Emprestimo emprestimo;

    private final double VALOR_MULTA_ATRASO = 1.5;

    public LivroFisico(String nome, Autor autor, StatusMaterial status, String isbn) {
        super(nome, autor, status);
        this.isbn = isbn;
        this.emprestimo = null;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }  

    @Override
    public boolean realizarEmprestimo(String matricula) throws MaterialIndisponivelException {
        if (status == StatusMaterial.DISPONIVEL) {
            this.emprestimo = new Emprestimo(matricula, LocalDate.now());
            status = StatusMaterial.EMPRESTADO;
            return true;
        }

        throw new MaterialIndisponivelException(nome, status);
    }

    @Override
    public boolean realizarDevolucao() {
        if (status == StatusMaterial.EMPRESTADO) {
            status = StatusMaterial.DISPONIVEL;
            return true;
        }
        return false;
    }

    @Override
    public double calcularMulta(int diasAtraso) {
        return VALOR_MULTA_ATRASO * diasAtraso;
    }  
}
