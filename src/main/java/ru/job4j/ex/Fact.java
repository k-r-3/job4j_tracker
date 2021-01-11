package ru.job4j.ex;

public class Fact {

    public int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(n + " is a negative integer");
        }
        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}
