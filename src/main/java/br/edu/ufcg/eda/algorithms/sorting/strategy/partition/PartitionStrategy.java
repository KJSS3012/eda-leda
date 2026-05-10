package br.edu.ufcg.eda.algorithms.sorting.strategy.partition;

public interface PartitionStrategy {

    int partition(int[] array, int left, int right);
    String getPivotStrategy();
}