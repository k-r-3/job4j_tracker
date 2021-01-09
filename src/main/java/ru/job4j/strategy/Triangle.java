package ru.job4j.strategy;

public class Triangle implements Shape {
    @Override
    public String draw() {
        String sep = System.lineSeparator();
        return    "   ^    " + sep
                + " /   \\ " + sep
                + "/_____\\" + sep;
    }
}
