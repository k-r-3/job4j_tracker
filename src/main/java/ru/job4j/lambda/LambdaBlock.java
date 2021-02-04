package ru.job4j.lambda;

import java.util.Comparator;

public class LambdaBlock {

    private Comparator<String> comparator = (left, right) -> {
        System.out.println("compare " + left.length() + " : " +  right.length());
        return Integer.compare(right.length(), left.length());
    };
}
