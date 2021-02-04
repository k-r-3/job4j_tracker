package ru.job4j;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApi {
    private List<Integer> list = new ArrayList<>(List.of(2, 5, 22, 0, -6, -4, 1));
    private List<Integer> filterList = list.stream()
            .filter(i -> i >= 0)
            .collect(Collectors.toList());

}
