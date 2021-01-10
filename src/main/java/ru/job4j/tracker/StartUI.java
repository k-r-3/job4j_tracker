package ru.job4j.tracker;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = Integer.valueOf(input.askStr("Select : "));
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        UserAction[] actions = {new CreateItem(output), new ShowItems(output), new ReplaceItem(output),
                new DeleteItem(output), new FindByID(output), new FindByName(output), new Exit(output)};
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI(output).init(input, tracker, actions);
    }
}
