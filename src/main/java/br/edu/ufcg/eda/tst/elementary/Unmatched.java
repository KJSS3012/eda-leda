package br.edu.ufcg.eda.tst.elementary;

import java.util.Arrays;
import java.util.Scanner;

class Unmatched {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] array = in.nextLine().split(" ");
        int[] newArray = Arrays.stream(array).mapToInt(Integer::parseInt).toArray();

        insertionSort(newArray);

        System.out.println(findUnmatchedNumber(newArray));
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j] > array[j - 1]) {
                int aux = array[j];
                array[j] = array[j - 1];
                array[j - 1] = aux;
                j--;
            }
        }
    }

    public static int findUnmatchedNumber(int[] array) {
        int i = 0;
        while (i + 1 < array.length - 1) {
            if (array[i] != array[i + 1]) {
                return array[i];
            }
            i += 2;
        }
        return array[array.length-1];
    }
}
