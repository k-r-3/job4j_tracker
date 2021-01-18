package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

import static java.util.List.of;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = Integer.valueOf(input.askStr("Select : "));
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(new ConsoleInput(), output);
        List<UserAction> actions = new ArrayList<>(of(new CreateItem(output), new ShowItems(output), new ReplaceItem(output),
                new DeleteItem(output), new FindByID(output), new FindByName(output), new Exit(output)));
        new StartUI(output).init(input, tracker, actions);
    }
}