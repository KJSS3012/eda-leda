package br.edu.ufcg.eda.tst.sort;

import java.util.Arrays;
import java.util.Scanner;

class RecursiveSelectionSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] array = in.nextLine().split(" ");

        fixArray(array, 0);
    }

    public static void fixArray(String[] array, int start) {
        if (start >= array.length - 1) return;

        int smaller = start;
        for (int i = start; i < array.length; i++) {
            if (Integer.parseInt(array[i]) < Integer.parseInt(array[smaller])) {
                smaller = i;
            }
        }

        if (smaller != start) {
            String aux = array[start];
            array[start] = array[smaller];
            array[smaller] = aux;
        }

        System.out.println(Arrays.toString(array));

        fixArray(array, start + 1);
    }
}


