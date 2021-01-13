package ru.job4j.singleton;

import org.junit.Test;
import ru.job4j.tracker.Tracker;

import static org.junit.Assert.*;

public class TrackerSingle1Test {

    @Test
    public void whenCompareTrackerSingleAndTracker() {
        Tracker in = TrackerSingle1.getInstance();
        Tracker out = new Tracker();
        assertSame(out, in);
    }
    @Test
    public void whenCompareCoupleTrackerSingle() {
        Tracker in = TrackerSingle1.getInstance();
        Tracker out = TrackerSingle1.getInstance();
        assertSame(out, in);
    }
}