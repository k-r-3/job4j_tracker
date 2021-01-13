package ru.job4j.singleton;
import ru.job4j.tracker.Tracker;

import java.util.Arrays;

public class TrackerSingle3 {

    private TrackerSingle3(){}

    private static final class InnerTracker {
        private static final Tracker INSTANCE = new Tracker();
    }

    public static Tracker getInstance() {
        return InnerTracker.INSTANCE;
    }
}


