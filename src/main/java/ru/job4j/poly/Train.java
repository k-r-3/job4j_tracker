package ru.job4j.poly;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " run along a railroad");
    }

    @Override
    public void kind() {
        System.out.print("Cargo ");
    }
}
