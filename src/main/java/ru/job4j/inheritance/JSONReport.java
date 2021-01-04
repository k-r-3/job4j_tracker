package ru.job4j.inheritance;

public class JSONReport extends TextReport {

    @Override
    public String generate(String name, String body) {
        return String.format("%s : name %n%s : body", name, body);
    }
}
