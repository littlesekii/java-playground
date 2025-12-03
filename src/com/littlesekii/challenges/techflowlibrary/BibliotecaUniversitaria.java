package com.littlesekii.challenges.techflowlibrary;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BibliotecaUniversitaria {

    static {
        System.out.println("READY!");
    }

    public static void main(String[] args) {
        System.out.println("📚 === BIBLIOTECA UNIVERSITÁRIA TECHFLOW === 📚\n");

        Biblioteca biblioteca = new Biblioteca();

        System.out.println("1. CADASTRO DE LIVROS:");
        System.out.println("----------------------------------------");

        biblioteca.cadastrarLivro(new LivroFisico(
            "Dom Casmurro", 
            new Autor("Machado de Assis", "Brasil", 1839), 
            StatusMaterial.DISPONIVEL, 
            "978-85-01-12345-6"
        )).cadastrarLivro(new LivroDigital(
            "Clean Code", 
            new Autor("Robert C. Martin", "EUA", 1952), 
            StatusMaterial.DISPONIVEL, 
            "https://biblioteca.techflow.edu/clean-code"
        )).cadastrarLivro(new LivroFisico(
            "Memórias Póstumas de Brás Cubas", 
            new Autor("Machado de Assis", "Brasil", 1839), 
            StatusMaterial.DISPONIVEL, 
            "978-85-01-12345-7"
        )).cadastrarLivro(new LivroFisico(
            "Quincas Borba", 
            new Autor("Machado de Assis", "Brasil", 1839), 
            StatusMaterial.DISPONIVEL, 
            "978-85-01-12345-8"
        ));


        System.out.println("2. TENTATIVA DE EMPRÉSTIMO:");
        System.out.println("----------------------------------------");

        biblioteca.solicitarEmprestimo(
            (LivroFisico) biblioteca.buscarPorNome("Dom").getFirst()
            ,"2023001"
        );

        biblioteca.solicitarEmprestimo(
            (LivroFisico) biblioteca.buscarPorNome("Dom").getFirst()
            ,"2023002"
        );

        System.out.println("3. DEVOLUÇÃO E CÁLCULO DE MULTA:");
        System.out.println("----------------------------------------");

        biblioteca.realizarDevolucao(
            (LivroFisico) biblioteca.buscarPorNome("Dom").getFirst()
        );

        // biblioteca.realizarDevolucao(
        //     (LivroFisico) biblioteca.buscarPorNome("Dom").getFirst(),
        //     5
        // );

        System.out.println("4. RELATÓRIO DA BIBLIOTECA:");
        System.out.println("----------------------------------------");

        Biblioteca.Relatorio.exibir(biblioteca);

        System.out.println("5. BUSCA COM LAMBDA:");
        System.out.println("----------------------------------------");

        String query = "Machado de Assis";

        System.out.println("\nBuscando livros do autor \"" + query + "\"...");

        biblioteca.buscarPorAutor(query)
            .forEach(livro -> System.out.println("Encontrado: \"" + livro.getNome() + "\""));
        System.out.println();

        System.out.println("6. MÉTODOS DEPRECIADOS:");
        System.out.println("----------------------------------------");

        List.of(biblioteca.getClass().getMethods())
            .forEach(method -> {
                if (method.isAnnotationPresent(MetodoLegado.class)) {
                    MetodoLegado annotation = method.getAnnotation(MetodoLegado.class);

                    StringBuilder methodParameters = new StringBuilder();

                    AtomicInteger index = new AtomicInteger();
                    List.of(method.getParameters())
                        .forEach(parameter -> {
                            methodParameters.append(
                                (index.get() > 0 ? ", " : "") + parameter.getType().getSimpleName() + 
                                " " + parameter.getName()
                            );
                            index.incrementAndGet();
                        }
                    );

                    System.out.println(method.getName() + "(" + methodParameters + ") deprecated - " + annotation.motivo());
                }
            });

    }
}