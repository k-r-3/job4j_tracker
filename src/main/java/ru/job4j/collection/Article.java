package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;


public class Article {
    public static boolean generateBy(String origin, String line) {
        origin = origin.toUpperCase();
        line = line.toUpperCase();
        Map<String, Integer> map = new HashMap<>();
        String[] lineArr = line.split(" ");
        for (String o : origin.split(" ")) {
            if (map.containsKey(o)) {
                map.put(o, map.get(o) + 1);
            }
            map.put(o, 1);
        }
        int startSize = map.size();
        for (String l : line.split(" ")) {
            if (map.containsKey(l)) {
                map.put(l, map.get(l) - 1);
                if (map.get(l) == 0) {
                    map.remove(l);
                }
            }
            if (map.containsKey(l + ",")) {
                map.put(l + ",", map.get(l + ",") - 1);
                if (map.get(l + ",") == 0) {
                    map.remove(l + ",");
                }
            }
            if (map.containsKey(l + ".")) {
                map.put(l + ".", map.get(l + ".") - 1);
                if (map.get(l + ".") == 0) {
                    map.remove(l + ".");
                }
            }
            if (map.containsKey(l + "!")) {
                map.put(l + "!", map.get(l + "!") - 1);
                if (map.get(l + "!") == 0) {
                    map.remove(l + "!");
                }
            }
        }
        return map.size() == startSize - lineArr.length;
    }
}
