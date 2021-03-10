package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListSorterTest {
    List<Integer> list = new ArrayList<>();
    List<Integer> expected = new ArrayList<>();


    @BeforeEach
    public void helper() {
        list = Arrays.asList(1,2,4,2);
        expected = Arrays.asList(1,2,2,4);
    }

    @Test
    public void sort() {
        ListSorter sorter = new ListSorter(list);
        List<Integer> sorted = sorter.sort();

        Assertions.assertEquals(expected, sorted);
    }
}
