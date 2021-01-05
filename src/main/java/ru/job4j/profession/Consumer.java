package ru.job4j.profession;

public class Consumer {
    private String name;
    private int age;
    private int cashAccount;

    public Consumer(String name, int age, int cashAccount) {
        this.name = name;
        this.age = age;
        this.cashAccount = cashAccount;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getCashAccount() {
        return cashAccount;
    }
}
