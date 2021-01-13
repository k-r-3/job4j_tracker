package ru.job4j.singleton;
import ru.job4j.tracker.Tracker;

import java.util.Arrays;

public class TrackerSingle1 {
    private static Tracker instance;

    private TrackerSingle1(){}

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }
}
