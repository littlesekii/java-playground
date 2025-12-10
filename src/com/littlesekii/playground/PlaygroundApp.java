package com.littlesekii.playground;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import com.littlesekii.playground.examples.lambdaExpressions.streamFunctionsImplementation.SmartList;

public class PlaygroundApp {

    public static void main(String[] args) {

        SmartList<String> names = new SmartList<>();


        names.getList().add("Davi");
        names.getList().add("Flávia");
        names.getList().add("Lucas");
        names.getList().add("Mariana");
        names.getList().add("João");
        names.getList().add("Letícia");
        names.getList().add("Gabriel");
        names.getList().add("Ana");
        names.getList().add("Matheus");
        names.getList().add("Beatriz");
        names.getList().add("Rafael");
        names.getList().add("Camila");

        names.forEach(
            name -> {
                if (name.contains("i")) 
                    System.out.println(name);
                else 
                    System.out.print("");
            }
        );

        System.out.println();

        names.filter(name -> name.contains("M") || name.contains("m"))
            .forEach(System.out::println);

        var mappedList = names.map(s -> (s.contains("Davi")) ? 1 : "Amanda");

        // SmartList<String> mappedList2 = names.map(s -> (s.contains("Davi")) ? 1 : "Amanda");

        System.out.println(mappedList);

        AtomicInteger i = new AtomicInteger(0);
        Map<Integer, String> s = names.getList().stream().collect(Collectors.toMap(k -> i.addAndGet(1), v -> v));

        System.out.println("d");

    }
}
