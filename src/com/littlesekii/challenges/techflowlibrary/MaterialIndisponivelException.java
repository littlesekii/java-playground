package com.littlesekii.challenges.techflowlibrary;

public class MaterialIndisponivelException extends Exception {
    public MaterialIndisponivelException(String titulo, StatusMaterial status) {
        super("❌ O material '" + titulo + "' não pode ser emprestado. Status: " + status.getDescricao());
    }
}
