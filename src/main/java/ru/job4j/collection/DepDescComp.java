package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
//        if (o1.length() < o2.length()) {
//            return Integer.compare(o1.length(), o2.length());
//        } else if (o1.length() > o2.length()) {
//            return Integer.compare(o2.length(), o1.length());
//        }
        if (o1.length() != o2.length()) {
            return Integer.compare(o1.length(), o2.length());
        }
        String leftEnd = String.valueOf(o1.charAt(o1.length() - 1));
        String rightEnd = String.valueOf(o2.charAt(o1.length() - 1));
        return Integer.compare(Integer.parseInt(leftEnd), Integer.parseInt(rightEnd));
    }
}