package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askInt("Insert item ID : "));
        if (tracker.delete(id)) {
            System.out.println("item was removed\n");
        } else {
            System.out.println("ID not found, please try again\n");
        }
        return true;
    }
}
