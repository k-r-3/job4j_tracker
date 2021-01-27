package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class Article {
    public static boolean generateBy(String origin, String line) {
        Map<String, Integer> map = new HashMap<>();
        int amount = 0;
        origin = origin.toUpperCase();
        line = line.toUpperCase();
        String[] lineArr = line.split(" ");
        String[] originArr = origin.split(" ");
        for (String o : originArr) {
            String word = o.replaceAll("[,!.]", "");
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        for (String l : lineArr) {
            if (map.containsKey(l)) {
                map.put(l, map.get(l) - 1);
                amount++;
                if (map.get(l) == 0) {
                    map.remove(l);
                }
            }
        }
        return amount == lineArr.length;
    }
}
