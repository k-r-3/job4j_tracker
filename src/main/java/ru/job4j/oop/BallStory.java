package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        BallStory tale = new BallStory();
        Ball ball = new Ball();
        Hare hare = new Hare();
        Wolf wolf = new Wolf();
        Fox fox = new Fox();
        ball.voyage(tale);
        hare.tryEat(ball);
        wolf.tryEat(ball);
        fox.tryEat(ball);
        fox.allure(ball);
        fox.eat(ball);
    }
}
