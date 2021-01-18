package ru.job4j.tracker;

import java.util.List;

public class FindByName implements UserAction {
    private final Output out;

    public FindByName(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find Item by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Object sep = System.lineSeparator();
        String name = input.askStr("Insert item name : ");
        List<Item> items = tracker.findByName(name);
        if (items.size() != 0) {
            for(Item item : items) {
                out.println(item);
            }
            out.println(sep);
        } else {
            out.println("Item not found, please try again");
            out.println(sep);
        }
        return true;
    }
}
