package ru.job4j.oop;

public class College {

    public static void main(String[] args) {
//        повышающее приведение типов
        Freshman freshman = new Freshman();
        Student petya = freshman;
        Object student = petya;
    }
}
