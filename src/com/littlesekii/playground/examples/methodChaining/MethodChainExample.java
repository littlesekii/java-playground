package com.littlesekii.playground.examples.methodChaining;

public class MethodChainExample {
    
    private String message;

    public MethodChainExample() {
        message = "";
    }

    public MethodChainExample(String message) {
        this.message = message;
    }

    public MethodChainExample setMessage(String message) {
        this.message = message;
        return this;
    }

    public void print() {
        System.out.println(message);
    }

}
