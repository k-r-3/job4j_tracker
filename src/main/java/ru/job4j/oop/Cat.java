package ru.job4j.oop;

public class Cat {
    private String name;

    private String food;

    public void giveNik(String nik) {
        this.name = nik;
    }

    public void eat(String food) {
        this.food = food;
    }

    public void show() {
        System.out.println(name + " съел " + food);
    }

    public static void main(String[] args) {
        Cat peppy = new Cat();
        Cat sparky = new Cat();
        sparky.giveNik("Sparky");
        sparky.eat("Kitekat");
        sparky.show();
        peppy.giveNik("Peppy");
        peppy.eat("Whiskas");
        peppy.show();
    }
}
