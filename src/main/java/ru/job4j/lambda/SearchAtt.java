package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

public class SearchAtt {

    public static List<Attachment> filter(List<Attachment> list, int value) {
        List<Attachment> rsl = new ArrayList<>();
        BiPredicate<Attachment, Integer> func = new BiPredicate<Attachment, Integer>() {
            @Override
            public boolean test(Attachment att, Integer integer) {
                return att.getSize() == integer;
            }
        };
        for (Attachment att : list) {
            if (func.test(att, value)) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filter(List<Attachment> list, String value) {
        List<Attachment> rsl = new ArrayList<>();
        BiPredicate<Attachment, String> func = new BiPredicate<Attachment, String>() {
            @Override
            public boolean test(Attachment att, String s) {
                return att.getName().contains(s);
            }
        };
        for (Attachment att : list) {
            if (func.test(att, value)) {
                rsl.add(att);
            }
        }
        return rsl;
    }
}
