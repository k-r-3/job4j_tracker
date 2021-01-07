package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void ride() {
        System.out.println("the bus is riding");
    }

    @Override
    public void passengers(int amount) {
        System.out.println(amount + " passengers got on the bus");
    }

    @Override
    public int fill(int fuelAmount) {
        return fuelAmount * 47;
    }
}
