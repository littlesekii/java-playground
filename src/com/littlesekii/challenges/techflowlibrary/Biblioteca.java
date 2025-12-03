package com.littlesekii.challenges.techflowlibrary;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    
    private List<MaterialBibliografico> livros;
    
    static class Relatorio {

        public static void exibir(Biblioteca biblioteca) {

            List<MaterialBibliografico> livros = biblioteca.buscarPorNome("");

            int qtdLivros = livros.size();
            int qtdLivrosFisicos = (int) livros.stream().filter(livro -> livro.getClass() == LivroFisico.class).count();
            int qtdLivrosDigitais = qtdLivros - qtdLivrosFisicos;
            int qtdLivrosEmprestados = (int) livros.stream().filter(livro -> livro.getStatus() == StatusMaterial.EMPRESTADO).count();
            int qtdLivrosDisponiveis = qtdLivros - qtdLivrosEmprestados;

            StringBuilder stringBuilder = new StringBuilder("📊 === RELATÓRIO ESTATÍSTICO ===");
            stringBuilder.append("\nTotal de materiais: " + qtdLivros);
            stringBuilder.append("\nLivros físicos: " + qtdLivrosFisicos);
            stringBuilder.append("\nLivros digitais: " + qtdLivrosDigitais);
            stringBuilder.append("\nMateriais disponíveis: " + qtdLivrosDisponiveis);
            stringBuilder.append("\nMateriais emprestados: " + qtdLivrosEmprestados);

            System.out.println(stringBuilder + "\n");            
        }
    }

    public Biblioteca() {
        livros = new ArrayList<>();
    }

    public Biblioteca cadastrarLivro(LivroFisico livro) {
        livros.add(livro);

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("✅ Livro cadastrado: " + livro.getNome() + " (Físico)")
            .append("\nAutor: " + livro.getAutor())
            .append("\nISBN: " + livro.getIsbn())
            .append("\nStatus: " + livro.getStatus().getDescricao());

        System.out.println(stringBuilder + "\n");

        return this;
    }

    public Biblioteca cadastrarLivro(LivroDigital livro) {
        livros.add(livro);

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("✅ Livro cadastrado: " + livro.getNome() + " (Digital)")
            .append("\nAutor: " + livro.getAutor())
            .append("\nLink: " + livro.getLink())
            .append("\nStatus: " + livro.getStatus().getDescricao());

        System.out.println(stringBuilder + "\n");

        return this;
    }

    public Biblioteca solicitarEmprestimo(LivroFisico livro, String matricula) {

        StringBuilder stringBuilder = new StringBuilder();

        try {
            stringBuilder.append("Aluno: " + matricula + " tentando empréstimo de \"" + livro.getNome() + "\"...");
            livro.realizarEmprestimo(matricula);

            stringBuilder.append("\nEmpréstimo realizado com sucesso!")
                .append("\nData devolução: " + LocalDate.now().plusDays(3).toString())
                .append("\nStatus atual: " + livro.getStatus().getDescricao());

        } catch (MaterialIndisponivelException e) {
            stringBuilder.append("\nErro: O material \"" + livro.getNome() + "\" não pode ser emprestado.")
                .append("\nStatus: " + livro.getStatus().getDescricao());
        }

        System.out.println(stringBuilder + "\n");
        return this;
    }

    @MetodoLegado(motivo = "Motivo: Substituído por cálculo dinamico de dias.")
    @Deprecated
    public Biblioteca realizarDevolucao(LivroFisico livro, int diasAtraso) {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Devolução: \"" + livro.getNome() + "\"");
        if (livro.realizarDevolucao()) {

            stringBuilder.append("\nDevolvido com sucesso!");            

            if (diasAtraso > 0) {
                stringBuilder.append("\nMulta por atraso: R$" + livro.calcularMulta(diasAtraso) + " (" + diasAtraso + " dias)");
            }
        } else {
            stringBuilder.append("\nImpossível devolver! Livro não consta como emprestado.");
        }

        System.out.println(stringBuilder + "\n");
        return this;
    }

    public Biblioteca realizarDevolucao(LivroFisico livro) {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Devolução: \"" + livro.getNome() + "\"");
        if (livro.realizarDevolucao()) {

            stringBuilder.append("\nDevolvido com sucesso!");

            int diasAtraso = (int) ChronoUnit.DAYS.between(livro.getEmprestimo().getData().minusDays(5), LocalDate.now());

            if (diasAtraso > 0) {
                stringBuilder.append("\nMulta por atraso: R$" + livro.calcularMulta(diasAtraso) + " (" + diasAtraso + " dias)");
            }
        } else {
            stringBuilder.append("\nImpossível devolver! Livro não consta como emprestado.");
        }

        System.out.println(stringBuilder + "\n");
        return this;
    }

    public List<MaterialBibliografico> buscarPorNome(String src) {
        List<MaterialBibliografico> result = livros.stream()
            .filter(livro -> livro.getNome().contains(src))
            .toList();
        return result;
    }

    public List<MaterialBibliografico> buscarPorAutor(String src) {
        List<MaterialBibliografico> result = livros.stream()
            .filter(livro -> livro.getAutor().nome().contains(src))
            .toList();
        return result;
    }

    public List<MaterialBibliografico> buscarPorIsbn(String src) {
        List<MaterialBibliografico> result = livros.stream()
            .filter(livro -> ((LivroFisico) livro).getIsbn().contains(src))
            .toList();
        return result;
    }

    public List<MaterialBibliografico> buscarPorLink(String src) {
        List<MaterialBibliografico> result = livros.stream()
            .filter(livro -> ((LivroDigital) livro).getLink().contains(src))
            .toList();
        return result;
    }
}
