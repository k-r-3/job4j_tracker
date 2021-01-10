package ru.job4j.tracker;

public class FindByID implements UserAction {
    private final Output out;

    public FindByID(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find Item by ID";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askInt("Insert item ID : "));
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(item);
            System.lineSeparator();
        } else {
            out.println("ID not found, please try again");
            System.lineSeparator();
        }
        return true;
    }
}
