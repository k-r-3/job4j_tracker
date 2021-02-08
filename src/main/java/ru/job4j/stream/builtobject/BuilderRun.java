package ru.job4j.stream.builtobject;

public class BuilderRun {
    public static void main(String[] args) {
        Pojo pojo = new Pojo.Builder().buildName("Ivan")
                .buildSurname("Ivanov")
                .buildMarried(false)
                .buildSalary((short) 1000)
                .setPosition("developer")
                .build();
        System.out.println(pojo);

    }
}
