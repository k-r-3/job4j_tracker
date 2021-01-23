package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        List<String> rsl = new ArrayList<>();
        Set<String> temp = new LinkedHashSet<>();
        for (String element : deps) {
            String start = "";
            for (String value : element.split("/")) {
                start += value;
                temp.add(start);
                start += "/";
            }
        }
        return new ArrayList<>(temp);
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}