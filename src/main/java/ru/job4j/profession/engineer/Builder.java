package ru.job4j.profession.engineer;

public class Builder extends Engineer {

    public Builder(String name, String surname, String education, int birthday) {
        super(name, surname, education, birthday);
    }

    public void build (Customer customer) {}
}
