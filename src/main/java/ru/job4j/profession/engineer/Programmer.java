package ru.job4j.profession.engineer;

public class Programmer extends Engineer {

    public Programmer(String name, String surname, String education, int birthday) {
        super(name, surname, education, birthday);
    }

    public void development(Customer customer) {}
}
