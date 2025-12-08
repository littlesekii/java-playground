package com.littlesekii.challenges.productsminewow;

import java.util.List;
import java.util.Random;

import com.littlesekii.challenges.productsminewow.model.CategoriaProduto;
import com.littlesekii.challenges.productsminewow.model.Product;
import com.littlesekii.challenges.productsminewow.repository.CSVFile;
import com.littlesekii.challenges.productsminewow.services.ProductService;

public class Main {

    public static void main(String[] args) {

        CSVFile csvFile = new CSVFile("Products", "./", ProductService.fields);
        ProductService service = new ProductService(csvFile);
        
        // service.remove(14997);

        Random random = new Random();
        CategoriaProduto[] categorias = CategoriaProduto.values();

        // System.out.println(service.findAllByName("Produto 500 "));
        
        // Limpa arquivo antes
        // service.clear();

        // INSERE 15k PRODUTOS COM VALORES ALEATÓRIOS
        for (int i = 1; i <= 15000; i++) {
            CategoriaProduto categoriaAleatoria = categorias[random.nextInt(categorias.length)];
            int quantidadeAleatoria = random.nextInt(100) + 1; // 1-100
            double precoAleatorio = 10.0 + (random.nextDouble() * 990.0); // 10.0 - 1000.0
            
            Product produto = new Product(
                i, // Código único
                "Produto " + i + (random.nextBoolean() ? " Premium" : " Basic"),
                categoriaAleatoria,
                quantidadeAleatoria,
                precoAleatorio
            );
            
            service.save(produto);
            
            // Progresso a cada 1000
            if (i % 1000 == 0) {
                System.out.println("Inseridos: " + i + " produtos");
            }
        }
        
        System.out.println("Total de produtos: " + service.findAll().size());
        
        // TESTE DE UPDATE (altera alguns produtos)
        for (int i = 1; i <= 100; i++) {
            int codigoAleatorio = random.nextInt(15000) + 1;
            Product existente = service.findByCodigo(codigoAleatorio);
            
            if (existente != null) {
                existente.setPreco(existente.getPreco() * 1.1); // Aumenta 10%
                service.save(existente);
            }
        }
        
        // // TESTE DE REMOÇÃO (remove alguns)
        // for (int i = 1; i <= 50; i++) {
        //     int codigoAleatorio = random.nextInt(15000) + 1;
        //     service.remove(codigoAleatorio);
        // }
        
        System.out.println("Final: " + service.findAll().size() + " produtos");
        
        // CALCULA VALOR TOTAL (opcional)
        double valorTotal = service.findAll().stream()
            .mapToDouble(p -> p.getPreco() * p.getQtdEstoque())
            .sum();
        System.out.printf("Valor total do inventário: R$ %.2f%n", valorTotal);

    }
    
}
