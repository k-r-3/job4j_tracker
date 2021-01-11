package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Input in = new StubInput(new String[] {"one", "1"});
        Output out = new StubOutput();
        ValidateInput validateInput = new ValidateInput(in, out);
        int selected = validateInput.askInt("Enter menu: ");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Input in = new StubInput(new String[] {"1"});
        Output out = new StubOutput();
        ValidateInput validateInput = new ValidateInput(in, out);
        int selected = validateInput.askInt("Enter menu: ");
        assertThat(selected, is(1));
    }

    @Test
    public void whenMultiplyValidInput() {
        Input in = new StubInput(new String[] {"0", "1", "2"});
        Output out = new StubOutput();
        ValidateInput validateInput = new ValidateInput(in, out);
        int selected = validateInput.askInt("Enter menu: ");
        assertThat(selected, is(0));
    }

    @Test()
    public void whenNegativeInput() {
        Input in = new StubInput(new String[] {"-1"});
        Output out = new StubOutput();
        ValidateInput validateInput = new ValidateInput(in, out);
        int selected = validateInput.askInt("Enter menu: ");
        assertThat(selected, is(-1));
    }
}