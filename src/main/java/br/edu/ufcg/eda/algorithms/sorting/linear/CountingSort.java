package br.edu.ufcg.eda.algorithms.sorting.linear;

import br.edu.ufcg.eda.algorithms.interfaces.Algorithm;

public class CountingSort implements Algorithm {

    @Override
    public void run(int[] array) {

        if (array.length == 0) return;

        int[] extremes = findExtremes(array);

        int k = extremes[1];
        int smaller = extremes[0];

        int[] c = new int[k - smaller + 1];

        for (int i = 0; i < array.length; i++) {
            c[array[i] - smaller] += 1;
        }

        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }
        int[] b = new int[array.length];

        for (int i = array.length - 1; i >= 0; i--) {
            b[c[array[i] - smaller] - 1] = array[i];
            c[array[i] - smaller] -= 1;
        }

        for (int i = 0; i < b.length; i++) {
            array[i] = b[i];
        }
    }

    private int[] findExtremes(int[] array) {
        int smaller = array[0];
        int bigger = array[0];

        for(int i : array) {
            if (i < smaller) {
                smaller = i;
            }

            if (i > bigger) {
                bigger = i;
            }
        }

        return new int[]{smaller, bigger};
    }

    @Override
    public String toString() {
        return "CountingSort";
    }
}
