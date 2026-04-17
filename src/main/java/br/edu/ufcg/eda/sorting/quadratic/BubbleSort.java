package br.edu.ufcg.eda.sorting.quadratic;

import br.edu.ufcg.eda.sorting.Sorter;

public class BubbleSort implements Sorter {
    @Override
    public void sort(int[] array) {

        if (array == null || array.length <= 1) {
            return;
        }

        int n = array.length;
        boolean isSwapped;

        for (int i = 0; i < n - 1; i++) {
            isSwapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    isSwapped = true;
                }
            }
            if (!isSwapped) break;

        }
    }

    @Override
    public void sort(double[] array) {

        if (array == null || array.length <= 1) {
            return;
        }

        int n = array.length;
        boolean isSwapped;

        for (int i = 0; i < n - 1; i++) {
            isSwapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    isSwapped = true;
                }
            }
            if (!isSwapped) break;

        }
    }

    @Override
    public void sort(String[] array) {

        if (array == null || array.length <= 1) {
            return;
        }

        int n = array.length;
        boolean isSwapped;

        for (int i = 0; i < n - 1; i++) {
            isSwapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j].compareTo(array[j + 1]) >= 1) {
                    String temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    isSwapped = true;
                }
            }
            if (!isSwapped) break;

        }
    }


}
