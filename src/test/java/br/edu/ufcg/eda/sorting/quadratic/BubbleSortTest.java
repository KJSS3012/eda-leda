package br.edu.ufcg.eda.sorting.quadratic;

import br.edu.ufcg.eda.algorithms.sorting.quadratic.BubbleSort;
import br.edu.ufcg.eda.sorting.AbstractSortTest;
import br.edu.ufcg.eda.algorithms.sorting.Sorter;

public class BubbleSortTest extends AbstractSortTest {
    @Override
    protected Sorter getImplementation() {
        return new BubbleSort();
    }
}
