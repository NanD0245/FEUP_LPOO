package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListFilterTest {
    private List<Integer> list = new ArrayList<>();
    @BeforeEach
    public void helper() {
        for (int i = -5; i < 6; i++)
            list.add(i);
    }

    @Test
    public void positive_filter(){
        PositiveFilter positiveFilter = new PositiveFilter();
        ListFilterer listFilterer = new ListFilterer(list);

        List<Integer> expected = Arrays.asList(1,2,3,4,5);

        Assertions.assertEquals(listFilterer.filter(positiveFilter),expected);
    }

    @Test
    public void divisible_filter() {
        DivisibleByFilter divisibleByFilter = new DivisibleByFilter(2);
        ListFilterer listFilterer = new ListFilterer(list);

        List<Integer> expected = Arrays.asList(-4,-2,0,2,4);

        Assertions.assertEquals(listFilterer.filter(divisibleByFilter),expected);
    }
}
