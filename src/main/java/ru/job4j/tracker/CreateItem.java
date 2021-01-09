package ru.job4j.tracker;

public class CreateItem implements UserAction {
    @Override
    public String name() {
        return "Create a new Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        System.out.println();
        Item item = new Item(name);
        tracker.add(item);
        return true;
    }
}