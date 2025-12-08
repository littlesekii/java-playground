package com.littlesekii.challenges.productsminewow.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.littlesekii.challenges.productsminewow.model.CategoriaProduto;
import com.littlesekii.challenges.productsminewow.model.Product;
import com.littlesekii.challenges.productsminewow.repository.CSVFile;

public class ProductService {

    public static List<String> fields = List.of( 
        "codigo", 
        "nome", 
        "categoria", 
        "qtd", 
        "valor" 
    );

    private Set<Integer> cacheCodigo;
    private Map<Integer, Product> cacheProdutos;
    
    private final CSVFile repository;

    public ProductService(CSVFile repository) {
        this.repository = repository;
        this.cacheCodigo = new HashSet<>();
        this.cacheProdutos = new HashMap<>();

        loadFullCache();
    }

    public void save(Product product) {
        
        if (cacheCodigo.contains(product.getCodigo())) {
            cacheProdutos.put(product.getCodigo(), product);          
            replaceAll(new ArrayList<>(cacheProdutos.values()));
            return;
        }

        cacheCodigo.add(product.getCodigo());
        cacheProdutos.put(product.getCodigo(), product);
        repository.appendLine(
            List.of(
                String.valueOf(product.getCodigo()),
                String.valueOf(product.getNome()),
                String.valueOf(product.getCategoria().getValue()),
                String.valueOf(product.getQtdEstoque()),
                String.valueOf(product.getPreco())
            )
        );
    }

    public void replaceAll(List<Product> products) { 
        List<List<String>> replaceLines = new ArrayList<>();

        for (Product product: products) {
            replaceLines.add(List.of(
                String.valueOf(product.getCodigo()),
                String.valueOf(product.getNome()),
                String.valueOf(product.getCategoria().getValue()),
                String.valueOf(product.getQtdEstoque()),
                String.valueOf(product.getPreco())
            ));
        }

        repository.replaceLines(replaceLines);
    }

    public void remove(Integer codigo) {
        // List<Product> products = findAll().stream()
        //     .filter(product -> product.getCodigo() != codigo)
        //     .toList();

        // replaceAll(products);

        cacheCodigo.remove(codigo);
        cacheProdutos.remove(codigo);

        replaceAll(cacheProdutos.values().stream().toList());
    }

    public List<Product> findAll() {
        // List<Product> products = new ArrayList<>();

        // List<List<String>> data = repository.getLines();
        // for (List<String> line : data) {
        //     products.add(new Product(
        //         Integer.parseInt(line.get(0)),
        //         line.get(1),
        //         CategoriaProduto.from(line.get(2)),
        //         Integer.parseInt(line.get(3)),
        //         Double.parseDouble(line.get(4))
        //     ));                   
        // }
        // return products;

        return new ArrayList<>(cacheProdutos.values());
    }

    public Map<Integer, Product> findAllHashMap() {
        // List<Product> allProducts = findAll();
        // Map<Integer, Product> products = new HashMap<>(allProducts.size());
        // for (Product product : allProducts) {
        //     products.put(product.getCodigo(), product);
        // }
        // return products;

        return cacheProdutos;
    }

    private void loadFullCache() {
        List<List<String>> lines = repository.getLines();
        cacheProdutos.clear();
        cacheCodigo.clear();
        
        for (List<String> line : lines) {
            Product p = parseLine(line);
            cacheProdutos.put(p.getCodigo(), p);
            cacheCodigo.add(p.getCodigo());
        }
    }
    
    private Product parseLine(List<String> line) {
        return new Product(
            Integer.parseInt(line.get(0)),
            line.get(1),
            CategoriaProduto.from(line.get(2)),
            Integer.parseInt(line.get(3)),
            Double.parseDouble(line.get(4))
        );
    }


    public Product findByCodigo(int codigo) {
        // Map<Integer, Product> products = findAllHashMap();
        // return products.get(codigo);

        return cacheProdutos.get(codigo);
    }

    public List<Product> findAllByName(String qry) {
        // return findAll()
        //     .stream()
        //     .filter(i -> i.getNome().contains(qry))
        //     .toList();

        return cacheProdutos.values().stream()
            .filter(i -> i.getNome().contains(qry))
            .toList();
    }

    public void clear() {
        cacheCodigo.clear();
        cacheProdutos.clear();
        repository.clear();
    }

}
