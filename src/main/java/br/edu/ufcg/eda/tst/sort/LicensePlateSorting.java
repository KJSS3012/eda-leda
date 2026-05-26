package br.edu.ufcg.eda.tst.sort;

import java.util.Arrays;
import java.util.Scanner;

class LicensePlateSorting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] array = in.nextLine().split(",");

        int limit = 8;
        for (int i = 0; i < 4; i++) {
            radixSort(array, limit);
            limit--;
        }
        System.out.println(Arrays.toString(array));
    }

    private static void radixSort(String[] array, int limit) {
        int[] cumulative = new int[10];

        for (String value: array) {
            cumulative[Integer.parseInt(value.substring(limit - 1, limit))]++;
        }

        for (int i = 1; i < cumulative.length; i++) {
            cumulative[i] += cumulative[i - 1];
        }

        String[] result = new String[array.length];

        for (int i = array.length - 1; i > -1 ; i--) {
            int digit = Integer.parseInt(array[i].substring(limit - 1, limit));
            int idx = cumulative[digit] - 1;
            result[idx] = array[i];
            cumulative[digit]--;
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = result[i];
        }
    }
}
