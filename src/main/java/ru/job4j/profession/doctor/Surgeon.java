package ru.job4j.profession.doctor;

public class Surgeon extends Doctor {

    public Surgeon(String name, String surname, String education, int birthday) {
        super(name, surname, education, birthday);
    }

    public void surgery(Patient patient) { }

}
