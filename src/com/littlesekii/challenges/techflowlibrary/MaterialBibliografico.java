package com.littlesekii.challenges.techflowlibrary;

public abstract class MaterialBibliografico {
    protected String nome;
    protected Autor autor;
    protected StatusMaterial status;

    public MaterialBibliografico() {}
    public MaterialBibliografico(String nome, Autor autor, StatusMaterial status) {
        this.nome = nome;
        this.autor = autor;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Autor getAutor() {
        return autor;
    }
    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    public StatusMaterial getStatus() {
        return status;
    }
    public void setStatus(StatusMaterial status) {
        this.status = status;
    }   
}
