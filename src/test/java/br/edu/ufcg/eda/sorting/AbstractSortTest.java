package br.edu.ufcg.eda.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public abstract class AbstractSortTest {

    protected Sorter implementation;
    protected abstract Sorter getImplementation();

    @BeforeEach
    void setup() {
        this.implementation = getImplementation();
    }

    @Test
    void testIntArray() {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        implementation.sort(array);
        assertThat(array).isSorted();
    }

    @Test
    void testDoubleArray() {
        double[] array = {9.78, 8.3, 8.4, 9.134, 9.133, 0.8, 7.0, 23.2, 1.345};
        implementation.sort(array);
        assertThat(array).isSorted();
    }

    @Test
    void testStringArray() {
        String[] array = {"Kaique", "Jessé", "Emanuel", "Pedro", "Leonel", "Neto"};
        implementation.sort(array);
        assertThat(array).isSorted();
    }

    @Test
    void testEmptyArray() {
        int[] array = {};
        implementation.sort(array);
        assertThat(array).isEmpty();
    }

    @Test
    void testAlreadySorted() {
        int[] array = {1, 2, 3, 4, 5};
        implementation.sort(array);
        assertThat(array).isSorted().containsExactly(1, 2, 3, 4, 5);
    }
}
