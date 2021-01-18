package ru.job4j.collection;

import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> listString = new ArrayList<>();
        listString.add("Petr");
        listString.add("Ivan");
        listString.add("Stepan");
        for(String element : listString) {
            System.out.println(element);
        }
    }
}
