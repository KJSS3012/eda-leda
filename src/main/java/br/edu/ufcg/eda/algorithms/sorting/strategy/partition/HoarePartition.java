package br.edu.ufcg.eda.algorithms.sorting.strategy.partition;

import br.edu.ufcg.eda.algorithms.sorting.strategy.pivot.PivotStrategy;

public class HoarePartition implements PartitionStrategy {

    private final PivotStrategy pivotStrategy;

    public HoarePartition(PivotStrategy pivotStrategy) {
        this.pivotStrategy = pivotStrategy;
    }

    @Override
    public int partition(int[] array, int left, int right) {

        int pivotIndex = pivotStrategy.getPivotIndex(array, left, right);

        int pivot = array[pivotIndex];

        swap(array, left, pivotIndex);

        int i = left + 1;
        int j = right;

        while (i <= j) {

            while (i <= j && array[i] <= pivot) {
                i++;
            }

            while (i <= j && array[j] > pivot) {
                j--;
            }

            if (i < j) {
                swap(array, i, j);
            }
        }

        swap(array, left, j);

        return j;
    }



    private void swap(int[] array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }

    @Override
    public String getPivotStrategy() {
        return this.pivotStrategy.getClass().getSimpleName();
    }
}