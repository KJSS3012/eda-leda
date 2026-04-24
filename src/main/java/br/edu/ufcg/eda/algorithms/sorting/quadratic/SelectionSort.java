package br.edu.ufcg.eda.algorithms.sorting.quadratic;

import br.edu.ufcg.eda.algorithms.Algorithm;

public class SelectionSort implements Algorithm {
    @Override
    public void run(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int smaller = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[smaller]) {
                    smaller = j;
                }
            }

            int aux = array[i];
            array[i] = array[smaller];
            array[smaller] = aux;
        }
    }
}
