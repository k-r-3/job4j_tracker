package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.List.of;
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
        List<UserAction> actions = new ArrayList<>(of(
                new CreateItem(out),
                new Exit(out)));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. Create a new Item" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "=== Create a new Item ====" + System.lineSeparator()
                + System.lineSeparator() + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Create a new Item" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "Exit..." + System.lineSeparator()));
    }

    @Test
    public void whenShowItems() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Item for show"));
        Item item2 = tracker.add(new Item("Item2 for show"));
        List<Item> items = new ArrayList<>(of(item, item2));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        Output out = new StubOutput();
        List<UserAction> actions = new ArrayList<>(of(
                new ShowItems(out),
                new Exit(out)));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll(), is(items));
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. Show all Items" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "All items :" + System.lineSeparator()
                + item.toString() + System.lineSeparator()
                + item2.toString() + System.lineSeparator()
                + System.lineSeparator() + System.lineSeparator()
                + "Menu." + System.lineSeparator() + "0. Show all Items"
                + System.lineSeparator() + "1. Exit" + System.lineSeparator()
                + "Exit..." + System.lineSeparator()));
    }

    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New Item"));
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        Output out = new StubOutput();
        List<UserAction> actions = new ArrayList<>(of(
                new FindByID(out),
                new Exit(out)));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(),
                is(tracker.findAll().get(0).getName()));
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. Find Item by ID" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + tracker.findAll().get(0) + System.lineSeparator()
                + System.lineSeparator() + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Find Item by ID" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "Exit..." + System.lineSeparator()));
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New Item"));
        Input in = new StubInput(
                new String[] {"0", "New Item", "1"}
        );
        Output out = new StubOutput();
        List<UserAction> actions = new ArrayList<>(of(
                new FindByName(out),
                new Exit(out)));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("New Item"));
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. Find Item by name" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + tracker.findAll().get(0) + System.lineSeparator()
                + System.lineSeparator() + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Find Item by name" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "Exit..." + System.lineSeparator()));
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
        List<UserAction> actions = new ArrayList<>(of(
                new ReplaceItem(out),
                new Exit(out)));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. Replace Item" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "Replacing an item" + System.lineSeparator()
                + System.lineSeparator() + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Replace Item" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "Exit..." + System.lineSeparator()));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("item for deletion"));
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        List<UserAction> actions = new ArrayList<>(of(
                new DeleteItem(out),
                new Exit(out)));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. Delete Item" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "item was removed" + System.lineSeparator()
                + System.lineSeparator() + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Delete Item" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "Exit..." + System.lineSeparator()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>(of(
                new Exit(out)));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator()
                        + "Exit..." + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"8", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>(of(
                new Exit(out)));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. Exit%n"
                                + "Exit...%n"
                )
        ));
    }
}