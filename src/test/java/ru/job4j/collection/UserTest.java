package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void whenAsc() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 32));
        users.add(new User("Ivan", 31));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Ivan", 31)));
        assertThat(it.next(), is(new User("Petr", 32)));
    }

    @Test
    public void whenComparePertVSIvan() {
        int rsl = new User("Petr", 32)
                .compareTo(
                        new User("Ivan", 31)
                );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompareAlekseyVSAleksandr() {
        int rsl = new User("Aleksey", 32)
                .compareTo(
                        new User("Aleksandr", 31)
                );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenDifferentNamesLength() {
        int rsl = new User("Alekseev", 32)
                .compareTo(
                        new User("Alekseeva", 31)
                );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenAscWithoutName() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 31));
        users.add(new User("Petr", 32));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Petr", 31)));
        assertThat(it.next(), is(new User("Petr", 32)));
    }
}