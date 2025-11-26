package com.littlesekii.playground.examples.nestedClasses;

public class LocalClassExample {
    
    private String value = "RIOTLaF";

    public void print() {

        String valueF = "littlesekii";

        class LocalClass {

            private String value = "Zoranin";

            void print() {
                System.out.println("External class value: " + LocalClassExample.this.value);
                System.out.println("Function value: " + valueF);
                System.out.println("Local class value: " + this.value);
            }
        }

        LocalClass local = new LocalClass();
        local.print();

    }
    

}
