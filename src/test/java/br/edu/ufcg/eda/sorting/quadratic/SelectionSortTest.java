package br.edu.ufcg.eda.sorting.quadratic;

import br.edu.ufcg.eda.algorithms.Algorithm;
import br.edu.ufcg.eda.algorithms.sorting.quadratic.SelectionSort;
import br.edu.ufcg.eda.sorting.AbstractSortTest;

public class SelectionSortTest extends AbstractSortTest {
    @Override
    protected Algorithm getImplementation() {
        return new SelectionSort();
    }
}
