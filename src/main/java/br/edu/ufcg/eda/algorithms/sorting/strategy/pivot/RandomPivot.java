package br.edu.ufcg.eda.algorithms.sorting.strategy.pivot;

public class RandomPivot implements PivotStrategy {

    @Override
    public int getPivotIndex(int[] array, int left, int right) {

        int range = right - left + 1;

        return (int)(Math.random() * range) + left;
    }
}