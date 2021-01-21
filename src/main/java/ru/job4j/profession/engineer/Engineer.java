package ru.job4j.profession.engineer;

import ru.job4j.profession.Profession;

public class Engineer extends Profession {

    public Engineer(String name, String surname, String education, int birthday) {
        super(name, surname, education, birthday);
    }

    public void execute(Customer customer) { }

}
