package com.littlesekii.playground;

import com.littlesekii.playground.examples.methodChaining.MethodChainExample;

public class PlaygroundApp {
    
    public static void main(String[] args) {

        MethodChainExample chain = new MethodChainExample("Good morning sunshine!");
        chain.print();

        chain.setMessage("Good night moonlight!").print();

    }
}
