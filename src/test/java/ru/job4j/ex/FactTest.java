package ru.job4j.ex;

import org.junit.Test;

import static org.junit.Assert.*;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenNegative1() {
        Fact fact = new Fact();
        fact.calc(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNegative2() {
        Fact fact = new Fact();
        fact.calc(-2);
    }
}