package ru.job4j.singleton;
import ru.job4j.tracker.Tracker;

import java.util.Arrays;

public enum TrackerSingle4 {
    INSTANCE;
    private final Tracker instance = new Tracker();

    private TrackerSingle4(){}

    public Tracker getInstance() {
        return instance;
    }
}

