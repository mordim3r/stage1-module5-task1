package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {

        return list->list.stream()
                .allMatch(s->Character.isUpperCase(s.charAt(0)));

    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> {
            List<Integer> evens = list.stream()
                    .filter(n -> n % 2 == 0)
                    .toList();
            list.addAll(evens);
        };

    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> values.stream()
                .filter(s -> Character.isUpperCase(s.charAt(0)))  // начинается с заглавной
                .filter(s -> s.endsWith("."))                      // заканчивается точкой
                .filter(s -> s.split(" ").length > 3)             // больше 3 слов
                .toList();
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return list -> list.stream()
                .collect(Collectors.toMap(
                        s -> s,          // ключ — сама строка
                        s -> s.length()  // значение — длина строки
                ));
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> result = new ArrayList<>(list1);
            result.addAll(list2);
            return result;
        };
    }
}
