package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {
    private List<Integer> list = new ArrayList<>();

    @BeforeEach
    public void helper() {
        list = Arrays.asList(1,2,4,2,5);
    }

    @Test
    public void sum() {
        ListAggregator aggregator = new ListAggregator(list);

        int sum = aggregator.sum();

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {
        ListAggregator aggregator = new ListAggregator(list);

        int max = aggregator.max();

        Assertions.assertEquals(5, max);
    }

    @Test
    public void min() {
        ListAggregator aggregator = new ListAggregator(list);

        int min = aggregator.min();

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {
        /*class StubDistinct implements IListDeduplicator {
            @Override
            public List<Integer> deduplicate(IListSorter listSorter) {
                return Arrays.asList(1,2,4,5);
            }
        }
        class StubDeduplicator implements IListSorter {
            @Override
            public List<Integer> sort() { return Arrays.asList(1,2,4,5); }
        }*/

        IListSorter sorter = Mockito.mock(IListSorter.class);
        List<Integer> sorted = Arrays.asList(1,2,4,5);
        Mockito.when(sorter.sort()).thenReturn(sorted);

        IListDeduplicator deduplicator = Mockito.mock(IListDeduplicator.class);
        List<Integer> deduplicated = Arrays.asList(1,2,4,5);
        Mockito.when(deduplicator.deduplicate(sorter)).thenReturn(deduplicated);

        ListAggregator aggregator = new ListAggregator(list);

        int distinct = aggregator.distinct(deduplicator, sorter);

        Assertions.assertEquals(4, distinct);
    }

    @Test
    public void max_bug_7263() {
        list = Arrays.asList(-1,-6,-5);

        ListAggregator aggregator = new ListAggregator(list);

        int max = aggregator.max();

        Assertions.assertEquals(-1,max);
    }

    @Test
    public void max_bug_8726() {

        /*class StubDistinct implements IListDeduplicator {
            @Override
            public List<Integer> deduplicate(IListSorter listSorter) {
                return Arrays.asList(1,2,4);
            }
        }
        class StubDeduplicator implements IListSorter {
            @Override
            public List<Integer> sort() { return Arrays.asList(1,2,2,4); }
        }*/

        IListSorter sorter = Mockito.mock(IListSorter.class);
        List<Integer> sorted = Arrays.asList(1,2,2,4);
        Mockito.when(sorter.sort()).thenReturn(sorted);

        IListDeduplicator deduplicator = Mockito.mock(IListDeduplicator.class);
        List<Integer> deduplicated = Arrays.asList(1,2,4);
        Mockito.when(deduplicator.deduplicate(sorter)).thenReturn(deduplicated);


        list = Arrays.asList(1,2,4,2);

        ListAggregator aggregator = new ListAggregator(list);

        int distinct = aggregator.distinct(deduplicator,sorter);

        Assertions.assertEquals(3,distinct);
    }
}
