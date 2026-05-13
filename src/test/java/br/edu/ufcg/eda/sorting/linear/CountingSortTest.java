package br.edu.ufcg.eda.sorting.linear;

import br.edu.ufcg.eda.algorithms.interfaces.Algorithm;
import br.edu.ufcg.eda.algorithms.sorting.linear.CountingSort;
import br.edu.ufcg.eda.sorting.AbstractSortTest;

public class CountingSortTest extends AbstractSortTest {
    @Override
    protected Algorithm getImplementation() {
        return new CountingSort();
    }
}
