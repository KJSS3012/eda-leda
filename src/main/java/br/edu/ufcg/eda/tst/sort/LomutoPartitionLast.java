package br.edu.ufcg.eda.tst.sort;

import java.util.Arrays;
import java.util.Scanner;

class LomutoPartitionLast {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] array = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        lomutoPartition(array);

    }

    private static void lomutoPartition(int[] array) {

        int i = array.length - 1;
        int pivot = array[i];

        for (int j = i - 1; j >= 0; j--) {
            if (array[j] > pivot) {
                i--;
                swap(array, i, j);
            }
        }

        swap(array, array.length - 1, i);

        System.out.println(Arrays.toString(array));
    }

    private static void swap(int[] array, int i, int j) {
        int aux = array[i];
        array[i] =  array[j];
        array[j] = aux;
        System.out.println(Arrays.toString(array));
    }
}
