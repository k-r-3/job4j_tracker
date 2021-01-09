package ru.job4j.tracker;

public class FindByName implements UserAction {
    @Override
    public String name() {
        return "Find Item by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Insert item name : ");
        Item[] items = tracker.findByName(name);
        if (items.length != 0) {
            for(Item item : items) {
                System.out.println(item);
            }
            System.out.println();
        } else {
            System.out.println("Item not found, please try again\n");
        }
        return true;
    }
}
