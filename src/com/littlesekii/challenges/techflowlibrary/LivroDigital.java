package com.littlesekii.challenges.techflowlibrary;

public final class LivroDigital extends MaterialBibliografico {
    
    private String link;

    public LivroDigital(String nome, Autor autor, StatusMaterial status, String link) {
        super(nome, autor, status);
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
