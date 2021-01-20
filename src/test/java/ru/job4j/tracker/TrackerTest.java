
package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenItemSort() {
        Tracker tracker = new Tracker();
        Item first = new Item();
        Item third = new Item();
        Item second = new Item();
        tracker.add(second);
        second.setId(1);
        tracker.add(third);
        third.setId(2);
        tracker.add(first);
        first.setId(0);
        List<Item> result = new ArrayList<>(tracker.findAll());
        Collections.sort(result);
        assertThat(result, is(List.of(first, second, third)));
    }

    @Test
    public void whenItemReversSort() {
        Tracker tracker = new Tracker();
        Item first = new Item();
        Item third = new Item();
        Item second = new Item();
        tracker.add(second);
        second.setId(1);
        tracker.add(third);
        third.setId(2);
        tracker.add(first);
        first.setId(0);
        List<Item> result = new ArrayList<>(tracker.findAll());
        Collections.sort(result, new ItemReversComparator());
        assertThat(result, is(List.of(third, second, first)));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }
}
