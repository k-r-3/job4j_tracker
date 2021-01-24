package ru.job4j.collection;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {
    @Test
    public void whenMissed() {
        List<String> input = Arrays.asList("k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenMissedSecondLayer() {
        List<String> input = Arrays.asList("k1", "k1/sk1/ssk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1", "k1/sk1/ssk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = Arrays.asList("k1", "k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenAscSort() {
        List<String> input = Arrays.asList("k1/sk1/ssk1", "k1/sk1", "k1");
        List<String> expect = Arrays.asList("k1", "k1/sk1", "k1/sk1/ssk1");
        Departments.sortAsc(input);
        assertThat(input, is(expect));
    }

    @Test
    public void whenRandomDecsSort1() {
        List<String> input = Arrays.asList("k2/sk1", "k2", "k1/sk1", "k1");
        List<String> expect = Arrays.asList("k2", "k2/sk1", "k1", "k1/sk1");
        Departments.sortDesc(input);
        assertThat(input, is(expect));
    }

    @Test
    public void whenRandomDecsSort2() {
        List<String> input = Arrays.asList("k2/sk1", "k1/sk1", "k2", "k2/sk1/ssk1", "k1");
        List<String> expect = Arrays.asList("k2", "k2/sk1", "k2/sk1/ssk1", "k1", "k1/sk1");
        Departments.sortDesc(input);
        assertThat(input, is(expect));
    }

    @Test
    public void whenRandomDecsSort3() {
        List<String> input = Arrays.asList("k2/sk1", "k1/sk1", "k2", "k2/sk1/ssk2",
                "k1/sk1/ssk1", "k2/sk1/ssk1", "k1", "k1/sk1/ssk2");
        List<String> expect = Arrays.asList("k2", "k2/sk1", "k2/sk1/ssk1",
                "k2/sk1/ssk2", "k1", "k1/sk1", "k1/sk1/ssk1", "k1/sk1/ssk2");
        Departments.sortDesc(input);
        assertThat(input, is(expect));
    }
}