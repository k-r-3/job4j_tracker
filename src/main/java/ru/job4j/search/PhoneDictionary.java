package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> filterName = (Person) -> Person.getName().contains(key);
        Predicate<Person> filterSurname = (Person) -> Person.getSurname().contains(key);
        Predicate<Person> filterPhone = (Person) -> Person.getPhone().contains(key);
        Predicate<Person> filterAddress = (Person) -> Person.getAddress().contains(key);
        Predicate<Person> combine = filterName.or(filterSurname).or(filterPhone).or(filterAddress);
        var result = new ArrayList<Person>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
