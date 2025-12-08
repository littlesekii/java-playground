package com.littlesekii.challenges.productsminewow.model;

public class Product {
    
    private int codigo;
    private String nome;
    private CategoriaProduto categoria;
    private int qtdEstoque;
    private double preco;

    public Product() {
    }

    public Product(int codigo, String nome, CategoriaProduto categoria, int qtdEstoque, double preco) {
        setCodigo(codigo);
        setNome(nome);
        setCategoria(categoria);
        setQtdEstoque(qtdEstoque);
        setPreco(preco);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.replace(";", "");
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProduto categoria) {
        this.categoria = categoria;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        if (qtdEstoque < 0)
            throw new IllegalArgumentException("qtdEstoque não pode ser negativo.");
        this.qtdEstoque = qtdEstoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco < 0)
            throw new IllegalArgumentException("preco não pode ser negativo.");
        this.preco = preco;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + codigo;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
        result = prime * result + qtdEstoque;
        long temp;
        temp = Double.doubleToLongBits(preco);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (codigo != other.codigo)
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (categoria != other.categoria)
            return false;
        if (qtdEstoque != other.qtdEstoque)
            return false;
        if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Product [codigo=" + codigo + ", nome=" + nome + ", categoria=" + categoria + ", qtdEstoque="
                + qtdEstoque + ", preco=" + preco + "]";
    }

    


}
