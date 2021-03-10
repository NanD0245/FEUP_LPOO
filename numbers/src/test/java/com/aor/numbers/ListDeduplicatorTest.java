package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {
    List<Integer> list = new ArrayList<>();
    List<Integer> expected = new ArrayList<>();


    @BeforeEach
    public void helper() {
        list = Arrays.asList(1,2,4,2);
        expected = Arrays.asList(1,2,4);
    }

    @Test
    public void deduplicate() {
        /*class StubDeduplicator implements IListSorter {
            @Override
            public List<Integer> sort() {
                return Arrays.asList(1,2,2,4);
            }
        }*/
        IListSorter sorter = Mockito.mock(IListSorter.class);
        List<Integer> sorted = Arrays.asList(1,2,2,4);
        Mockito.when(sorter.sort()).thenReturn(sorted);

        ListDeduplicator deduplicator = new ListDeduplicator(list);
        List<Integer> distinct = deduplicator.deduplicate(sorter);

        Assertions.assertEquals(expected, distinct);
    }
}
