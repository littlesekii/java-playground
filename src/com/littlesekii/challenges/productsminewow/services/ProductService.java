package com.littlesekii.challenges.productsminewow.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    
    private final CSVFile repository;

    public ProductService(CSVFile repository) {
        this.repository = repository;
    }

    public void save(Product product) {
        // Map<Integer, Product> productsMap = findAllHashMap();

        // if (productsMap.get(product.getCodigo()) != null) {
        //     productsMap.put(product.getCodigo(), product);
        //     replaceAll(new ArrayList<>(productsMap.values()));
        //     return;
        // }

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
        List<Product> products = findAll().stream()
            .filter(product -> product.getCodigo() != codigo)
            .toList();
        replaceAll(products);
    }

    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();

        List<List<String>> data = repository.getLines();
        for (List<String> line : data) {
            products.add(new Product(
                Integer.parseInt(line.get(0)),
                line.get(1),
                CategoriaProduto.from(line.get(2)),
                Integer.parseInt(line.get(3)),
                Double.parseDouble(line.get(4))
            ));                   
        }
        return products;
    }

    public Map<Integer, Product> findAllHashMap() {
        List<Product> allProducts = findAll();
        Map<Integer, Product> products = new HashMap<>(allProducts.size());
        for (Product product : allProducts) {
            products.put(product.getCodigo(), product);
        }
        return products;
    }


    public Product findByCodigo(int codigo) {
        Map<Integer, Product> products = findAllHashMap();
        return products.get(codigo);
    }

    public List<Product> findAllByName(String qry) {
        return findAll()
            .stream()
            .filter(i -> i.getNome().contains(qry))
            .toList();
    }

}
