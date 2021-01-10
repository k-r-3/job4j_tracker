//package ru.job4j.tracker;
//
//import org.junit.Test;
//
//import static org.hamcrest.CoreMatchers.nullValue;
//import static org.junit.Assert.*;
//import static org.hamcrest.core.Is.is;
//
//public class StartUITest {
//
//    @Test
//    public void whenCreateItem() {
//        Input in = new StubInput(
//                new String[] {"0", "Item name", "1"}
//        );
//        Tracker tracker = new Tracker();
//        UserAction[] actions = {
//                new CreateItem(),
//                new Exit()
//        };
//        new StartUI().init(in, tracker, actions);
//        assertThat(tracker.findAll()[0].getName(), is("Item name"));
//    }
//
//    @Test
//    public void whenReplaceItem() {
//        Tracker tracker = new Tracker();
//        Item item = tracker.add(new Item("Replaced item"));
//        String replacedName = "New item name";
//        Input in = new StubInput(
//                new String[] {"0", "1", "New item name", "1"}
//        );
//        UserAction[] actions = {
//                new ReplaceItem(),
//                new Exit()
//        };
//        new StartUI().init(in, tracker, actions);
//        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
//    }
//
//    @Test
//    public void whenDeleteItem() {
//        Tracker tracker = new Tracker();
//        Item item = tracker.add(new Item("item for deletion"));
//        Input in = new StubInput(
//                new String[] {"0","1", "1"}
//        );
//        UserAction[] actions = {
//                new DeleteItem(),
//                new Exit()
//        };
//        new StartUI().init(in, tracker, actions);
//        assertThat(tracker.findById(item.getId()), is(nullValue()));
//    }
//}