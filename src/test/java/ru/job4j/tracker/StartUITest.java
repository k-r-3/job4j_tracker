package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Output out = new StubOutput();
        UserAction[] actions = {
                new CreateItem(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
        assertThat(out.toString(), is("Menu." + System.lineSeparator() +
                "0. Create a new Item" + System.lineSeparator() +
                "1. Exit" + System.lineSeparator() +
                "=== Create a new Item ====" + System.lineSeparator() +
                System.lineSeparator() + System.lineSeparator() +
                "Menu." + System.lineSeparator() +
                "0. Create a new Item" + System.lineSeparator() +
                "1. Exit" + System.lineSeparator() +
                "Exit..." + System.lineSeparator()));
    }

    @Test
    public void whenShowItems() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Item for show"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        Output out = new StubOutput();
        UserAction[] actions = {
                new ShowItems(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() +
                "0. Show all Items" + System.lineSeparator() +
                "1. Exit" + System.lineSeparator() +
                "All items :" + System.lineSeparator() +
                item.toString() + System.lineSeparator() +
                System.lineSeparator() + System.lineSeparator() +
                "Menu." + System.lineSeparator() +
                "0. Show all Items" + System.lineSeparator() +
                "1. Exit" + System.lineSeparator() +
                "Exit..." + System.lineSeparator()));
    }

    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New Item"));
        String name = item.toString();
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        Output out = new StubOutput();
        UserAction[] actions = {
                new FindByID(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).toString(), is(name));
        assertThat(out.toString(), is("Menu." + System.lineSeparator() +
                "0. Find Item by ID" + System.lineSeparator() +
                "1. Exit" + System.lineSeparator() +
                name + System.lineSeparator() +
                System.lineSeparator() + System.lineSeparator() +
                "Menu." + System.lineSeparator() +
                "0. Find Item by ID" + System.lineSeparator() +
                "1. Exit" + System.lineSeparator() +
                "Exit..." + System.lineSeparator()));
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New Item"));
        String name = item.toString();
        Input in = new StubInput(
                new String[] {"0", "New Item", "1"}
        );
        Output out = new StubOutput();
        UserAction[] actions = {
                new FindByName(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() +
                "0. Find Item by name" + System.lineSeparator() +
                "1. Exit" + System.lineSeparator() +
                name + System.lineSeparator() +
                System.lineSeparator() + System.lineSeparator() +
                "Menu." + System.lineSeparator() +
                "0. Find Item by name" + System.lineSeparator() +
                "1. Exit" + System.lineSeparator() +
                "Exit..." + System.lineSeparator()));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        Output out = new StubOutput();
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", "1", "New item name", "1"}
        );
        UserAction[] actions = {
                new ReplaceItem(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
        assertThat(out.toString(), is("Menu." + System.lineSeparator() +
                "0. Replace Item" + System.lineSeparator() +
                "1. Exit" + System.lineSeparator() +
                "Replacing an item" + System.lineSeparator() +
                System.lineSeparator() + System.lineSeparator() +
                "Menu." + System.lineSeparator() +
                "0. Replace Item" + System.lineSeparator() +
                "1. Exit" + System.lineSeparator() +
                "Exit..." + System.lineSeparator()));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("item for deletion"));
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        UserAction[] actions = {
                new DeleteItem(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
        assertThat(out.toString(), is("Menu." + System.lineSeparator() +
                "0. Delete Item" + System.lineSeparator() +
                "1. Exit" + System.lineSeparator() +
                "item was removed" + System.lineSeparator() +
                System.lineSeparator() + System.lineSeparator() +
                "Menu." + System.lineSeparator() +
                "0. Delete Item" + System.lineSeparator() +
                "1. Exit" + System.lineSeparator() +
                "Exit..." + System.lineSeparator()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator() +
                        "Exit..." + System.lineSeparator()
        ));
    }
}