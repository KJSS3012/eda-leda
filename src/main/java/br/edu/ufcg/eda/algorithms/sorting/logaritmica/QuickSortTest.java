package br.edu.ufcg.eda.algorithms.sorting.logaritmica;

import java.util.Arrays;

public class QuickSortTest {
    public static void main(String[] args) {
        int[] array = {10,9,8,7,6,5,4,3,2,1};

        mergeSort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) return;

        int idxPivot = hoare(array, left, right);

        quickSort(array, left, idxPivot - 1);
        quickSort(array, idxPivot + 1, right);
    }

    private static int lomuto(int[] array, int left, int right) {
        int idx = randomPivot(left, right);

        swap(array, left, idx);

        int pivot = array[left];

        int k = left;
        for (int i = left + 1; i <= right; i++) {
            if (array[i] <= pivot) {
                k++;
                swap(array, i, k);
            }
        }

        swap(array, k, left);

        return k;
    }

    private static int randomPivot(int left, int right) {
        int range = (right - left) + 1;
        return (int) (Math.random() * range) + left;
    }

    private static int hoare(int[] array, int left, int right) {
        int idx = medianOfThree(array, left, right);

        swap(array, left, idx);

        int pivot = array[left];
        int i = left + 1;
        int j = right;
        while (i <= j) {
            while (i <= j && array[i] <= pivot) {
                i++;
            }

            while (i <= j && array[j] > pivot) {
                j--;
            }

            if (i < j) {
                swap(array, i, j);
            }
        }

        swap(array, left, j);
        return j;
    }

    private static int medianOfThree(int[] array, int left, int right) {
        int a = array[0];
        int b = array[(right + left)/2];
        int c = array[right];

        if ((a > b) != (a > c)) {
            return a;
        } else if ((b > a) != (b > c)) {
            return b;
        } else {
            return c;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left >= right) return;

        int middle = (right + left) / 2;

        mergeSort(array, left, middle);
        mergeSort(array, middle + 1, right);
        merge(array, left, right);
    }

    private static void merge(int[] array, int left, int right) {
        int rightHelper = right - left;
        int[] helper = new int[rightHelper + 1];

        for (int i = 0; i <= rightHelper; i++) {
            helper[i] = array[left + i];
        }

        int middleHelper = rightHelper / 2;

        int i = 0;
        int j = middleHelper + 1;
        int k = left;

        while (i <= middleHelper && j <= rightHelper) {
            if (helper[i] <= helper[j]) {
                array[k] = helper[i];
                i++;
            } else {
                array[k] = helper[j];
                j++;
            }
            k++;
        }

        while (i <= middleHelper) {
            array[k++] = helper[i++];
        }
    }
}
