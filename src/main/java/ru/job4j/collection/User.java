package ru.job4j.collection;

import java.util.Objects;

public class User implements Comparable<User> {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
//
//    @Override
//    public int compareTo(User o) {
//        if (name.equals(o.name)) {
//            return Integer.compare(age, o.age);
//        }
//        int index = 0;
//        for(char letter : name.toCharArray()) {
//            int result = Integer.compare(letter, o.name.charAt(index));
//            if(result != 0) {
//                return result;
//            }
//            index++;
//        }
//        return name.length() - o.name.length();

    @Override
    public int compareTo(User o) {
        if (name.equals(o.name)) {
            return Integer.compare(age, o.age);
        }
        return this.name.compareTo(o.name);
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return age == user.age
                && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}