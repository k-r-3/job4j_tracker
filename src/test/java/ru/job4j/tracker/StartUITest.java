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
        new CreateItem().execute(input, tracker);
        Item result = tracker.findAll()[0];
        Item expected = new Item("Test item");
        assertThat(result.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("old item");
        tracker.add(item);
        String[] answers = {String.valueOf(item.getId()), "new item"};
        Input input = new StubInput(answers);
        new ReplaceItem().execute(input, tracker);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is("new item"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("item for deletion");
        tracker.add(item);
        String[] answers = {String.valueOf(item.getId())};
        Input input = new StubInput(answers);
        new DeleteItem().execute(input, tracker);
        Item result = tracker.findById(item.getId());
        assertNull(result);
    }
}