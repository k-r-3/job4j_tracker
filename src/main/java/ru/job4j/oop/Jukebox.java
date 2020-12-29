package ru.job4j.oop;

import java.util.Random;

public class Jukebox {
    static Random rand = new Random(47);
    public static void main(String[] args) {
    Jukebox sony = new Jukebox();
        for (int i = 0; i < 6; i++) {
            sony.music(rand.nextInt(4));
        }
    }

    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
        } else if (position == 2) {
            System.out.println("Спокойной ночи");
        } else {
            System.out.println("Песня не найдена");
        }
    }
}
