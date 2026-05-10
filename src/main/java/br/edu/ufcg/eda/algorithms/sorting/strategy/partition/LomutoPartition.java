package br.edu.ufcg.eda.algorithms.sorting.strategy.partition;

import br.edu.ufcg.eda.algorithms.sorting.strategy.pivot.PivotStrategy;

public class LomutoPartition implements PartitionStrategy {

    private final PivotStrategy pivotStrategy;

    public LomutoPartition(PivotStrategy pivotStrategy) {
        this.pivotStrategy = pivotStrategy;
    }

    @Override
    public int partition(int[] array, int left, int right) {

        int pivotIndex = pivotStrategy.getPivotIndex(array, left, right);

        swap(array, left, pivotIndex);

        int pivot = array[left];
        int i = left;

        for (int j = left + 1; j <= right; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, left, i);

        return i;
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