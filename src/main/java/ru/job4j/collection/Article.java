package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class Article {
    public static boolean generateBy(String origin, String line) {
        origin = origin.toUpperCase();
        line = line.toUpperCase();
        Map<Integer, String> map = new HashMap<>();
        int i = 0;
        int count = 0;
        for (String l : line.split(" ")) {
            map.put(i++, l);
        }
        for (int j = 0; j < map.size(); j++) {
            if (origin.contains(map.get(j))) {
                count++;
            }
        }
        return count == map.size();
    }
}
