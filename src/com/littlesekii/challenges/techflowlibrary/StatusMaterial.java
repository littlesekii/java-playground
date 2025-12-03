package com.littlesekii.challenges.techflowlibrary;

public enum StatusMaterial {
    DISPONIVEL("✅ Disponível"),
    EMPRESTADO("📖 Emprestado"),
    MANUTENCAO("🔧 Em manutenção"),
    RESERVADO("⏳ Reservado");

    private String descricao;

    private StatusMaterial(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}