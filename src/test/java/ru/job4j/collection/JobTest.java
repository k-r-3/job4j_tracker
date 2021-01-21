package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName()
                .thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAndProrityIncrease() {
        Comparator<Job> cmpNamePriority = new JobDescByName()
                .thenComparing(new JobDescByPriorityIncrease());
        int rsl = cmpNamePriority.compare(
                new Job("Task", 1),
                new Job("Task", 0)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByProrityAndName() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority()
                .thenComparing(new JobDescByName());
        int rsl = cmpNamePriority.compare(
                new Job("Task", 0),
                new Job("New Task", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByProrityAndNameIncrease() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority()
                .thenComparing(new JobDescByNameIncrease());
        int rsl = cmpNamePriority.compare(
                new Job("Task", 1),
                new Job("New Task", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByNameDecrease() {
        List<Job> jobs = new ArrayList<>(List.of(new Job("New Task", 0),
                new Job("Task", 0)));
        jobs.sort(new JobDescByName());
        assertThat(jobs.get(0).getName(), is("Task"));
    }

    @Test
    public void whenCompatorByNameIncrease() {
        List<Job> jobs = new ArrayList<>(List.of(new Job("Task", 0),
                new Job("New Task", 0)
                ));
        jobs.sort(new JobDescByNameIncrease());
        assertThat(jobs.get(0).getName(), is("New Task"));
    }

    @Test
    public void whenCompatorByPriorityDecrease() {
        List<Job> jobs = new ArrayList<>(List.of(new Job("New Task", 1),
                new Job("Task", 0)));
        jobs.sort(new JobDescByPriority());
        assertThat(jobs.get(0).getName(), is("New Task"));
    }

    @Test
    public void whenCompatorByPriorityIncrease() {
        List<Job> jobs = new ArrayList<>(List.of(new Job("New Task", 1),
                new Job("Task", 0)));
        jobs.sort(new JobDescByPriorityIncrease());
        assertThat(jobs.get(0).getName(), is("Task"));
    }
}