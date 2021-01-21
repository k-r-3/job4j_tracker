package ru.job4j.profession.engineer;

import ru.job4j.profession.Consumer;

public class Customer extends Consumer {
    private String order;

    public Customer(String name, int age, int cashAccount, String order) {
        super(name, age, cashAccount);
        this.order = order;
    }

    public void employment() { }
}
