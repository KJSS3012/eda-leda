package br.edu.ufcg.eda.tst.sort;

import java.util.Arrays;
import java.util.Scanner;

class RecursiveInsertionSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] array = in.nextLine().split(" ");

        fixArray(array, 1);
    }

    public static void fixArray(String[] array, int start) {
        if (start >= array.length) return;
        int i = start;
        while (i > 0 && Integer.parseInt(array[i]) < Integer.parseInt(array[i - 1])) {
            String aux = array[i];
            array[i] = array[i - 1];
            array[i - 1] = aux;
            i--;
        }

        System.out.println(Arrays.toString(array));

        fixArray(array, start + 1);
    }
}