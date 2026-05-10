package br.edu.ufcg.eda.sorting.logaritmica;

import br.edu.ufcg.eda.algorithms.interfaces.Algorithm;
import br.edu.ufcg.eda.algorithms.sorting.logaritmica.MergeSort;
import br.edu.ufcg.eda.sorting.AbstractSortTest;

public class MergeSortTest extends AbstractSortTest {
    @Override
    protected Algorithm getImplementation() {
        return new MergeSort();
    }
}
