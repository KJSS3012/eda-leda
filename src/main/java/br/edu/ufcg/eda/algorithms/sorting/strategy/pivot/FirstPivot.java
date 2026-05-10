package br.edu.ufcg.eda.algorithms.sorting.strategy.pivot;

public class FirstPivot implements PivotStrategy {

    @Override
    public int getPivotIndex(int[] array, int left, int right) {
        return left;
    }
}