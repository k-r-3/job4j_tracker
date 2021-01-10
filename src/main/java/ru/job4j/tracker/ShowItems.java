package ru.job4j.tracker;

public class ShowItems implements UserAction {
    private final Output out;

    public ShowItems(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all Items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("All items :");
        Item[] items = tracker.findAll();
        for (Item item : items) {
            out.println(item);
        }
        String sep = System.lineSeparator();
        out.println(sep);
        return true;
    }
}
