package ru.job4j.tracker;

import java.util.Comparator;

public class ItemComparator implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return  o1.compareTo(o2);
    }
}
