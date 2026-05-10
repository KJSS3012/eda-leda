package br.edu.ufcg.eda.algorithms.sorting.logaritmica;

import br.edu.ufcg.eda.algorithms.interfaces.Algorithm;
import br.edu.ufcg.eda.algorithms.sorting.strategy.partition.LomutoPartition;
import br.edu.ufcg.eda.algorithms.sorting.strategy.partition.PartitionStrategy;
import br.edu.ufcg.eda.algorithms.sorting.strategy.pivot.FirstPivot;

public class QuickSort implements Algorithm {

    private final PartitionStrategy partitionStrategy;

    public QuickSort(PartitionStrategy partitionStrategy) {
        this.partitionStrategy = partitionStrategy;

    }

    public QuickSort() {
        this.partitionStrategy = new LomutoPartition(new FirstPivot());
    }

    @Override
    public void run(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int left, int right) {

        if (left < right) {

            int partitionIndex = partitionStrategy.partition(array, left, right);

            quickSort(array, left, partitionIndex - 1);

            quickSort(array, partitionIndex + 1, right);
        }
    }

    @Override
    public String toString() {
        return "QuickSort(" + partitionStrategy.getClass().getSimpleName() + "+"+ partitionStrategy.getPivotStrategy()+")";
    }
}