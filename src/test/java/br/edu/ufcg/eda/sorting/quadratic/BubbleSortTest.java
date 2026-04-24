package br.edu.ufcg.eda.sorting.quadratic;

import br.edu.ufcg.eda.algorithms.sorting.quadratic.BubbleSort;
import br.edu.ufcg.eda.sorting.AbstractSortTest;
import br.edu.ufcg.eda.algorithms.Algorithm;

public class BubbleSortTest extends AbstractSortTest {
    @Override
    protected Algorithm getImplementation() {
        return new BubbleSort();
    }
}
