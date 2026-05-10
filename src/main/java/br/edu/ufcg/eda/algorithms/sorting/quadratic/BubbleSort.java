package br.edu.ufcg.eda.algorithms.sorting.quadratic;

import br.edu.ufcg.eda.algorithms.interfaces.Algorithm;

public class BubbleSort implements Algorithm {

    @Override
    public void run(int[] array) {

        if (array == null || array.length <= 1) {
            return;
        }

        int n = array.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - 1 - i; j++) {

                if (array[j] > array[j + 1]) {

                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "BubbleSort";
    }
}