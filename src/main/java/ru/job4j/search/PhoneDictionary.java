package ru.job4j.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> filterName = (Person) -> Person.getName().compareTo(key) == 0
                || Person.getSurname().compareTo(key) == 0;
        Predicate<Person> filterPhone = (Person) -> Person.getPhone().compareTo(key) == 0
                || Person.getAddress().compareTo(key) == 0;
        Predicate<Person> combine = filterName.or(filterPhone);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
