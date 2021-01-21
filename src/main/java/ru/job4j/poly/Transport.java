package ru.job4j.poly;

public class Transport {
    public static void main(String[] args) {
        Vehicle airliner = new Airliner();
        Vehicle bus = new Bus();
        Vehicle train = new Train();
        Vehicle[] vehicles = {airliner, bus, train};
        for (Vehicle vehicle : vehicles) {
            vehicle.kind();
            vehicle.move();
        }
    }
}
