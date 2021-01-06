package ru.job4j.pojo;

import java.util.Date;
import java.time.LocalDate;

public class Student {
    private String name;
    private int group;
    private LocalDate enrolled;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public LocalDate getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(int year, int month, int date) {
        this.enrolled = LocalDate.of(year, month, date);
    }
}
