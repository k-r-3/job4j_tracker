package ru.job4j.profession.doctor;

import ru.job4j.profession.Consumer;

public class Patient extends Consumer {
    private String disease;

    public Patient(String name, int age, int cashAccount, String disease) {
        super(name, age, cashAccount);
        this.disease = disease;
    }

    public void appointment() {}
}
