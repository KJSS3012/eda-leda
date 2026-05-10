package br.edu.ufcg.eda.algorithms.sorting.strategy.pivot;

public interface PivotStrategy {

    int getPivotIndex(int[] array, int left, int right);

}