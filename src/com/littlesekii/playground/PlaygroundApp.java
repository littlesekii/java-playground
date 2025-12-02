package com.littlesekii.playground;

import java.util.ArrayList;
import java.util.List;

import com.littlesekii.playground.examples.lambdaExpressions.LambdaFunctionalInterfaceExample;
import com.littlesekii.playground.examples.lambdaExpressions.LambdaFunctionalInterfaceGenericExample;
import com.littlesekii.playground.examples.lambdaExpressions.LambdaFunctionalInterfaceMethodReferenceExample;

public class PlaygroundApp {

    public static void main(String[] args) {

        LambdaFunctionalInterfaceExample lambda = () -> System.out.println("Hey\n");
        lambda.run();


        LambdaFunctionalInterfaceGenericExample<String> apresentacao0 = (String val) -> {
            return "Meu nome é " + val + "!";
        };
        LambdaFunctionalInterfaceGenericExample<String> apresentacao1 = (String val) -> "Me chamo " + val + "!";
        LambdaFunctionalInterfaceGenericExample<String> apresentacao2 = (val) -> "Pode me chamar de " + val + "!";
        LambdaFunctionalInterfaceGenericExample<String> apresentacao3 = val -> "My name is " + val + "!\n";
        System.out.println(apresentacao0.apply("Davi"));
        System.out.println(apresentacao1.apply("Davi"));
        System.out.println(apresentacao2.apply("Davi"));
        System.out.println(apresentacao3.apply("Davi"));


        apresentar(n -> "Watashi no namae wa " + n + " desu!\n", "Bacaiarou");


        LambdaFunctionalInterfaceMethodReferenceExample apresentacao4 = System.out::println;
        apresentacao4.apply("Olá! Me chamo RIOTLaF\n");


        String names[] = { "Zoranin", "Buggs", "Sirius Black" };
        List<String> nameList = List.of(names);


        System.out.println("My beloved viewers: ");
        nameList.forEach(name -> System.out.println(name));
        nameList.forEach(System.out::println);
        
    }

    public static void apresentar(LambdaFunctionalInterfaceGenericExample<String> apresentacao, String nome) {
        System.out.println(apresentacao.apply(nome));
    }
}
