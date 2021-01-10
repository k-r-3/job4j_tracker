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
        Object sep = System.lineSeparator();
        int id = Integer.valueOf(input.askInt("Insert item ID : "));
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(item);
            out.println(sep);
        } else {
            out.println("ID not found, please try again");
            out.println(sep);
        }
        return true;
    }
}
