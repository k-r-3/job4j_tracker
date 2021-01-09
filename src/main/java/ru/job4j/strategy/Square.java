package ru.job4j.strategy;

public class Square implements Shape {
    @Override
    public String draw() {
        String sep = System.lineSeparator();
        return    " -------- " + sep
                + "|        |" + sep
                + "|        |" + sep
                + "|        |" + sep
                + " -------- ";
    }
}
