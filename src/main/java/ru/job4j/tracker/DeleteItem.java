package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    private final Output out;

    public DeleteItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askInt("Insert item ID : "));
        if (tracker.delete(id)) {
            out.println("item was removed");
            String sep = System.lineSeparator();
            out.println(sep);
        } else {
            out.println("ID not found, please try again");
            String sep = System.lineSeparator();
            out.println(sep);
        }
        return true;
    }
}
