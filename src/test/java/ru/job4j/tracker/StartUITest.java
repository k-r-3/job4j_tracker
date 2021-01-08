package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        String[] answers = {"Test item"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item result = tracker.findAll()[0];
        Item expected = new Item("Test item");
        assertThat(result.getName(), is(expected.getName()));
    }
}