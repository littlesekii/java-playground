package com.littlesekii.playground.examples.dependencyInjection;

public class PushNotifier implements INotifier {

    @Override
    public void send(String message) {
        System.out.println("Enviando: " + message);
    }
    
}
