package ru.job4j.stream.simplestream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
     private static List<Integer> domainList;

    public static EasyStream of(List<Integer> source) {
        domainList = new ArrayList<>(source);
        return new EasyStream();
    }

    public synchronized EasyStream map(Function<Integer, Integer> fun) {
        for (int i = 0; i < domainList.size(); i++) {
            domainList.set(i, fun.apply(domainList.get(i)));
        }
        return new EasyStream();
    }

    public synchronized EasyStream filter(Predicate<Integer> fun) {
        var filteredList = new ArrayList<Integer>();
        for (Integer i : domainList) {
            if (fun.test(i)) {
                filteredList.add(i);
            }
        }
        domainList = filteredList;
        return new EasyStream();
    }

    public List<Integer> collect() {
        return domainList;
    }
}