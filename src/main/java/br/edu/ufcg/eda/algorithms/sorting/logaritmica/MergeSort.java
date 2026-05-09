package br.edu.ufcg.eda.algorithms.sorting.logaritmica;

import br.edu.ufcg.eda.algorithms.Algorithm;

public class MergeSort implements Algorithm {
    @Override
    public void run(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int left, int right) {
        if (left >= right) return;

        int middle = (left + right) / 2;

        mergeSort(array, left, middle);
        mergeSort(array, middle + 1, right);
        merge(array, left, right);
    }

    public void merge(int[] v, int left, int right) {
        int rightHelper = right - left;
        int[] helper = new int[rightHelper + 1];

        for (int i = 0; i <= rightHelper; i++) {
            helper[i] = v[left + i];
        }

        int middleHelper = rightHelper / 2;

        int i = 0;
        int j = middleHelper + 1;
        int k = left;

        while (i <= middleHelper && j <= rightHelper) {

            if (helper[i] <= helper[j]) {
                v[k] = helper[i];
                i++;
            } else {
                v[k] = helper[j];
                j++;
            }

            k++;
        }

        while (i <= middleHelper) {
            v[k] = helper[i];
            i++;
            k++;
        }
    }
}
