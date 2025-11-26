package com.littlesekii.playground.examples.nestedClasses;

public class AnonymousClassExample {

    private String value = "RIOTLaF";

    public void print() {

        interface Printer {
            void print();
        }

        String valueF = "littlesekii";

        Printer anon = new Printer() {

            private String value = "Zoranin";

            @Override
            public void print() {
                System.out.println("External class value: " + AnonymousClassExample.this.value);
                System.out.println("Function class value: " + valueF);
                System.out.println("Anonymous class value: " + this.value);
            }
        };

        anon.print();

    }

}