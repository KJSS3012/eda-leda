package br.edu.ufcg.eda.tst.sort;

import java.util.Arrays;
import java.util.Scanner;

class QuickSortStepByStep {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] array = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) return;

        int idxPivot = lomutoPartition(array, left, right);

        quickSort(array, left, idxPivot - 1);
        quickSort(array, idxPivot+ 1, right);
    }

    private static int lomutoPartition(int[] array, int left, int right) {
        int pivot = array[left];
        int i = left;

        for (int j = left + 1; j <= right; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, left, i);
        System.out.println(printArray(array));
        return i;
    }

    private static String printArray(int[] array) {
        return Arrays.stream(array)
                .mapToObj(String::valueOf)
                .collect(java.util.stream.Collectors.joining(" "));
    }

    private static void swap(int[] array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }
}
