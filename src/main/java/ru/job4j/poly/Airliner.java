package ru.job4j.poly;

public class Airliner implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " flies above the ground");
    }

    @Override
    public void kind() {
        System.out.print("Passenger's ");
    }
}
