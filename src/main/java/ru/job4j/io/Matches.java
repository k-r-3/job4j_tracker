package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class Matches {

    public static void main(String[] args) {
        int matches = 11;
        int player;
        Scanner sc = new Scanner(System.in);
        while(matches > 0) {
            int ai = new Random().nextInt(2) + 1;
            System.out.println("matches amount = " + matches);
            System.out.println("player's turn... ");
            player =Integer.parseInt(sc.nextLine());
            matches -= player;
            System.out.println("matches amount = " + matches);
            if (matches == 0) {
                System.out.println("Player win!");
                break;
            }
            System.out.println("AI's turn...");
            System.out.println(ai);
            matches -= ai;
            if (matches == 0) {
                System.out.println("matches amount = " + matches);
                System.out.println("AI win!");
                break;
            }

        }
    }
}
