package ru.job4j.stream;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlattingMap {
    Integer[][] example = {{3,4},
                           {5,6}
    };


    public List<Integer> flatting(Integer[][] input) {
        return List.of(input).stream()
                .flatMap(i -> List.of(i)
                        .stream())
                .collect(Collectors.toList());
    }
}
