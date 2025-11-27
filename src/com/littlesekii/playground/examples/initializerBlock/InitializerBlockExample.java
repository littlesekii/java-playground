package com.littlesekii.playground.examples.initializerBlock;

public class InitializerBlockExample {
        
    public static int number = 123;

    //Static Initializer block
    static {
        System.out.println("InitializerBlockExample ready!");
        number = 67;
    }

    public int numberI = 61;

    //Instance Initializer block
    {
        System.out.println("InitializerBlockExample instantiated!");
        numberI = 69;
    }
    
    
}
