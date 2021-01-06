package ru.job4j.tracker;

import java.lang.reflect.Array;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class StartUI {

    public static void main(String[] args) {
        Item[] items = new Item[4];
        for (int i = 0; i < 4; i++) {
            items[i] = new Item(i, "# " + i);
        }
        String currentDateTime = DateTimeFormatter
                .ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss")
                .format(items[0].getCreated());
        System.out.println(currentDateTime);
        Tracker tracker = new Tracker();
        for (Item item : items) {
            tracker.add(item);
        }
        System.out.println(tracker.findById(3));
        System.out.println(Arrays.toString(tracker.findByName("# 2")));
    }
}
