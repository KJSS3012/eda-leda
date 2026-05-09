package br.edu.ufcg.eda.tst.sort;

import java.util.Arrays;
import java.util.Scanner;

class MergeSortStepByStep {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] array = in.nextLine().split(" ");
        int[] convertedArray = Arrays.stream(array).mapToInt(Integer::parseInt).toArray();

        mergeSort(convertedArray, 0, convertedArray.length - 1);
    }

    private static void mergeSort(int[] array, int left, int right) {
        System.out.println(
                Arrays.toString(Arrays.copyOfRange(array, left, right + 1))
        );

        if (left >= right) {
            return;
        }

        int middle = (right + left) / 2;

        mergeSort(array, left, middle);
        mergeSort(array, middle + 1, right);
        merge(array, left, right);

        System.out.println(
                Arrays.toString(Arrays.copyOfRange(array, left, right + 1))
        );
    }

    private static void merge(int[] v, int left, int right) {
        int auxRight = right - left;
        int[] auxArray = new int[auxRight + 1];

        for (int i = 0; i <= auxRight; i++) {
            auxArray[i] = v[left + i];
        }

        int middle = auxRight / 2;
        int i = 0;
        int j = middle + 1;
        int idxRealArray = left;

        while (i <= middle && j <= auxRight) {
            if (auxArray[i] < auxArray[j]) {
                v[idxRealArray] = auxArray[i];
                i++;
            } else {
                v[idxRealArray] = auxArray[j];
                j++;
            }
            idxRealArray++;
        }

        while (i <= middle) {
            v[idxRealArray] = auxArray[i];
            i++;
            idxRealArray++;
        }
    }
}
