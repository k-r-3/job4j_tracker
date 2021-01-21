package ru.job4j.pojo;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Ivanov Ivan Ivanovich");
        student.setGroup(1);
        student.setEnrolled(2000, 9, 1);
        System.out.println("Student " + student.getName() + " was enrolled in university on "
                + student.getEnrolled());
    }
}
