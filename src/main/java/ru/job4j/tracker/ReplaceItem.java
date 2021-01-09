package ru.job4j.tracker;

public class ReplaceItem implements UserAction {
    @Override
    public String name() {
        return "Replace Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askInt("Insert item ID : "));
        String name = input.askStr("Insert new item name : ");
        if (tracker.replace(id, new Item(name))) {
            System.out.println("Replacing an item\n");
        } else {
            System.out.println("ID not found, please try again\n");

        }
        return true;
    }
}
