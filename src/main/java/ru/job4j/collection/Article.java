package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class Article {
    public static boolean generateBy(String origin, String line) {
        origin = origin.toUpperCase();
        line = line.toUpperCase();
        boolean result = true;
        String[] originArr = origin.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String l : line.split(" ")) {
            int count = 0;
            for (String o : originArr) {
                if (o.startsWith(l)) {
                    if (o.length() == l.length() || o.length() == (l.length() + 1)) {
                      count++;
                    }
                }
            }
            map.put(l, count);
        }
        for (int value : map.values()) {
            if (value == 0) {
                result = false;
            }
        }
        return result;
    }
}
