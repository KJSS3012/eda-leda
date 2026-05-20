package br.edu.ufcg.eda.tst.sort;

import java.util.Arrays;
import java.util.Scanner;

class RadixThreeDigits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] array = Arrays.stream(in.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int d = Integer.parseInt(in.nextLine());

        int exp = 1;

        for (int i = 0; i < d/3; i++) {
            countingSort(array, exp);
            exp *= 1000;
        }
    }

    private static void countingSort(int[] array, int exp) {

        int[] cumulative = new int[1000];

        for (int value : array) {
            int digit = (value / exp) % 1000;
            cumulative[digit]++;
        }

        for (int i = 1; i < cumulative.length; i++) {
            cumulative[i] += cumulative[i - 1];
        }

        int[] result = new int[array.length];

        for (int i = array.length - 1; i >= 0; i--) {
            int digit = (array[i] / exp) % 1000;
            int idx = cumulative[digit] - 1;
            result[idx] = array[i];
            cumulative[digit]--;
        }

        for (int i = 0; i < result.length; i++) {
            array[i] = result[i];
        }

        System.out.println(Arrays.toString(array));
    }
}
