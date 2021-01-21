package ru.job4j.tracker;

public class ValidateInput implements Input {
    private Input in;
    private Output out;

    public ValidateInput(Input in, Output out) {
        this.in = in;
        this.out = out;
    }

    @Override
    public String askStr(String question) {
        return in.askStr(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = in.askInt(question);
                invalid = false;
            } catch (NumberFormatException e) {
                out.println("Data not valid, please try again");
            }
        } while (invalid);
        return value;
    }
}
