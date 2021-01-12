package ru.job4j.singleton;
import ru.job4j.tracker.Tracker;

import java.util.Arrays;

public class TrackerSingle2 {
    private static final Tracker INSTANCE = new Tracker();

    public static Tracker getInstance() {
        return INSTANCE;
    }
}

