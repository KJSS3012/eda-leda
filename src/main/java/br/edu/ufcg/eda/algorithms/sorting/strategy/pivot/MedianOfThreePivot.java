package br.edu.ufcg.eda.algorithms.sorting.strategy.pivot;

public class MedianOfThreePivot implements PivotStrategy {

    @Override
    public int getPivotIndex(int[] array, int left, int right) {

        int middle = (left + right) / 2;

        int a = array[left];
        int b = array[middle];
        int c = array[right];

        if ((a > b) != (a > c)) {
            return left;
        }

        if ((b > a) != (b > c)) {
            return middle;
        }

        return right;
    }
}