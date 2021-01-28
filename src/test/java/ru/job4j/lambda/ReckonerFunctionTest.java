package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReckonerFunctionTest {
    ReckonerFunction function = new ReckonerFunction();

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        List<Double> result = function.diapason(1, 5, x -> 2 * Math.pow(x, 2) + 1 * x + 1);
        List<Double> expected = Arrays.asList(4D, 11D, 22D, 37D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        List<Double> result = function.diapason(2, 5, x -> Math.pow(3, x));
        List<Double> expected = Arrays.asList(9D, 27D, 81D);
        assertThat(result, is(expected));
    }

}