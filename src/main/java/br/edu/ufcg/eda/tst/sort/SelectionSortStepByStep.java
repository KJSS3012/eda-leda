package br.edu.ufcg.eda.tst.sort;

import java.util.Arrays;
import java.util.Scanner;

class SelectionSortStepByStep {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] array = in.nextLine().split(" ");

        fixArray(array);
    }

    public static void fixArray(String[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int smaller = i;
            for (int j = i + 1; j < array.length; j++) {
                if (Integer.parseInt(array[j]) < Integer.parseInt(array[smaller])) {
                    smaller = j;
                }
            }
            if (smaller != i) {
                String aux = array[i];
                array[i] = array[smaller];
                array[smaller] = aux;
                System.out.println(Arrays.toString(array));
            }
        }
    }
}
