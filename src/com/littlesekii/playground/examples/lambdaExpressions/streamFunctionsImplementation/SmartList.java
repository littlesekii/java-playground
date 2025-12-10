package com.littlesekii.playground.examples.lambdaExpressions.streamFunctionsImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SmartList<T> {
    
    private List<T> list;

    public SmartList() {
        list = new ArrayList<>();
    }
    
    public List<T> getList() {
        return list;
    }

    public void forEach(Consumer<T> consumer) {
        for (int i = 0; i < list.size(); i++)
            consumer.accept(list.get(i));
    }

    public SmartList<T> filter(Predicate<T> predicate) {
        SmartList<T> filtered = new SmartList<>();

        for (int i = 0; i < list.size(); i++)
            if (predicate.test(list.get(i)))
                filtered.list.add(list.get(i));
        
        return filtered;
    }

    public <R> SmartList<R> map(Function<T, R> mapper) {
        SmartList<R> mapped = new SmartList<>();

        for (int i = 0; i < list.size(); i++)
            mapped.list.add(mapper.apply(list.get(i)));

        return mapped;
    }

}
