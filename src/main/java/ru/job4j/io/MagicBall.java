package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {

    public static void main(String[] args) {
        int probability = new Random().nextInt(3);
        System.out.print("Я великий Оракул. Что ты хочешь узнать?\n");
        Scanner sc = new Scanner(System.in);
        String question = sc.nextLine();
        System.out.println(answer(probability));
    }
    public static String answer(int probability) {
         switch(probability){
            case 0 :
              return  "Да";
            case 1 :
               return "Нет";
            default:
                return "Может быть";
        }
    }
}
