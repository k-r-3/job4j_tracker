package ru.job4j.profession.doctor;

import ru.job4j.profession.Profession;

public class Doctor extends Profession {

    public Doctor(String name, String surname, String education, int birthday) {
        super(name, surname, education, birthday);
    }

    public void getReceipt(Patient patient) { }
}
