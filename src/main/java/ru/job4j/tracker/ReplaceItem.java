package ru.job4j.tracker;

public class ReplaceItem implements UserAction {
    private final Output out;

    public ReplaceItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Replace Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askInt("Insert item ID : "));
        String name = input.askStr("Insert new item name : ");
        if (tracker.replace(id, new Item(name))) {
            out.println("Replacing an item");
        } else {
            out.println("ID not found, please try again");
        }
        return true;
    }
}
