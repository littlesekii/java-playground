package com.littlesekii.playground;

import com.littlesekii.playground.examples.nestedClasses.AnonymousClassExample;
import com.littlesekii.playground.examples.nestedClasses.LocalClassExample;
import com.littlesekii.playground.examples.nestedClasses.NestedClassExample;
import com.littlesekii.playground.examples.nestedClasses.StaticNestedClassExample;

public class PlaygroundApp {
    
    public static void main(String[] args) {

        NestedClassExample.NestedClass nested = new NestedClassExample().new NestedClass();
        nested.print();

        System.out.println();
        
        StaticNestedClassExample.NestedClass staticNested = new StaticNestedClassExample.NestedClass();
        staticNested.print();

        System.out.println();

        LocalClassExample local = new LocalClassExample();
        local.print();

        System.out.println();

        AnonymousClassExample anonymous = new AnonymousClassExample();
        anonymous.print();

    }
}
