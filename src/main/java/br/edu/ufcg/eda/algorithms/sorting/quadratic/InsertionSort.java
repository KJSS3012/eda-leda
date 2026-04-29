package br.edu.ufcg.eda.algorithms.sorting.quadratic;

import br.edu.ufcg.eda.algorithms.Algorithm;

public class InsertionSort implements Algorithm {

    @Override
    public void run(int[] array) {
        for (int i = 0; i < array.length; i++) {

            int j = i;

            while (j > 0 && array[j] < array[j - 1]) {
                int aux = array[j];
                array[j] = array[j - 1];
                array[j -1] = aux;
                j--;
            }
        }
    }
}