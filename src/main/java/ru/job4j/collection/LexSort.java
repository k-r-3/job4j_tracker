package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        StringBuilder ls = new StringBuilder();
        StringBuilder rs = new StringBuilder();
        int size = 0;
        int index = 0;
        while (size < 2) {
            if (left.charAt(index) != '.') {
                ls.append(left.charAt(index));
            }
            if (right.charAt(index) != '.') {
                rs.append(right.charAt(index));
            }
            index++;
            size++;
        }
        return Integer.compare(Integer.parseInt(ls.toString()), Integer.parseInt(rs.toString()));
//    @Override
//    public int compare(String left, String right) {
//        int leftString;
//        int rightString;
//        StringBuilder sb = new StringBuilder();
//        for (char symbol : left.toCharArray()) {
//            if (symbol == '.') {
//                break;
//            }
//            sb.append(symbol);
//            leftString = Integer.parseInt(sb.toString());
//            symbol += symbol;
//
//        }
//        return Integer.compare(Integer.parseInt(left), Integer.parseInt(right));
    }
}
