package com.littlesekii.challenges.productsminewow.model;

public enum CategoriaProduto {
    VIDEOGAMES("videogames"),
    CONSOLES("consoles"),
    PERIFERICOS("periféricos");

    private String value;

    CategoriaProduto(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CategoriaProduto from(String value) {
        for (CategoriaProduto categoria : CategoriaProduto.values()) {
            if (categoria.value.equals(value)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Categoria inválida: " + value);
    }
}
