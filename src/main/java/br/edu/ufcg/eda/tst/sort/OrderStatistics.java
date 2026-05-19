package br.edu.ufcg.eda.tst.sort;

import java.util.Arrays;
import java.util.Scanner;

class OrderStatistics {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] array = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(findOrderStatistics(array));
    }

    private static int findOrderStatistics(int[] array) {
        int target = array[0];
        int i = 0;
        for (int j = 1; j < array.length; j++) {
            if (array[j] <= target) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, 0, i);

        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }
}
