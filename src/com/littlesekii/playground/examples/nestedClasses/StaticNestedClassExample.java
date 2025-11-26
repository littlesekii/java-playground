package com.littlesekii.playground.examples.nestedClasses;

public class StaticNestedClassExample {

    private static String value = "RIOTLaF";
    
    public static class NestedClass {
        public void print() {
            System.out.println("External class static value: " + StaticNestedClassExample.value);
        }
    }

}
