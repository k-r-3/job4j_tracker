package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FlattingMapTest {

    @Test
    public void whenFlastting() {
        FlattingMap fm = new FlattingMap();
        Integer[][] example = {{3,4}, {5,6}};
        List<Integer> input = fm.flatting(example);
        Assert.assertEquals(input, List.of(3,4,5,6));
    }

}