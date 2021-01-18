package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for(Person search : persons) {
            if (key.contains(search.getAddress()) ||
            key.contains(search.getSurname()) ||
            key.contains(search.getName())) {
                result.add(search);
            }
        }
        return result;
    }
}