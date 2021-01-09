package ru.job4j.tracker;

public class FindByID implements UserAction {
    @Override
    public String name() {
        return "Find Item by ID";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askInt("Insert item ID : "));
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item + "\n");
        } else {
            System.out.println("ID not found, please try again\n");
        }
        return true;
    }
}
