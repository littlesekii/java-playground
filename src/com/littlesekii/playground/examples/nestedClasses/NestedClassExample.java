package com.littlesekii.playground.examples.nestedClasses;

public class NestedClassExample {
    
    private String value = "RIOTLaF";

    public class NestedClass {
        public void print() {

            String value = "littlesekii";

            System.out.println("External class value: " + NestedClassExample.this.value);
            System.out.println("Internal class value: " + value); //if there isnt a internal field with the same name, external can be accessed this way
        }
    }
}
