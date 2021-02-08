package ru.job4j.stream.simplestream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {

    static class InnerFeature {
         private static List<Integer> innerList;

         private static List<Integer> getInnerList() {
             return innerList;
         }

         private static void setInnerList(List<Integer> list) {
             innerList = list;
         }

         private static void map(Function<Integer, Integer> fun) {
             var mappedList = new ArrayList<Integer>();
             for (Integer i : innerList) {
                 mappedList.add(fun.apply(i));
             }
             setInnerList(mappedList);
         }

         private static void filter(Predicate<Integer> fun) {
             var filteredList = new ArrayList<Integer>();
             for (Integer i : innerList) {
                 if (fun.test(i)) {
                     filteredList.add(i);
                 }
             }
             setInnerList(filteredList);
         }
     }

    public static EasyStream of(List<Integer> source) {
        InnerFeature.setInnerList(source);
        return new EasyStream();
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        InnerFeature.map(fun);
        return new EasyStream();
    }

    public EasyStream filter(Predicate<Integer> fun) {
        InnerFeature.filter(fun);
        return new EasyStream();
    }

    public List<Integer> collect() {
         return InnerFeature.getInnerList();
    }
}