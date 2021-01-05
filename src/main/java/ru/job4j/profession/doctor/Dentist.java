package ru.job4j.profession.doctor;

public class Dentist extends Doctor {

    public Dentist(String name, String surname, String education, int birthday) {
        super(name, surname, education, birthday);
    }

    public void toothHealing (Patient patient) {}
}
