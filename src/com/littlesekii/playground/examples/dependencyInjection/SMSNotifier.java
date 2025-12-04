package com.littlesekii.playground.examples.dependencyInjection;

public class SMSNotifier implements INotifier {

    @Override
    public void send(String message) {
        System.out.println("Enviando SMS: " + message);
    }
    
}
