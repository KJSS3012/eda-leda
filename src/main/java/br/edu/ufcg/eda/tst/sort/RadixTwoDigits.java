package br.edu.ufcg.eda.tst.sort;

import java.util.Arrays;
import java.util.Scanner;

class RadixTwoDigits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] array = Arrays.stream(in.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int d = Integer.parseInt(in.nextLine());

        int exp = 1;

        for (int i = 0; i < d/2; i++) {
            countingSort(array, exp);
            exp *= 100;;
        }
    }

    private static void countingSort(int[] array, int exp) {

        int[] cumulative = new int[100];

        for (int value : array) {
            int digit = (value / exp) % 100;
            cumulative[digit]++;
        }

        for (int i = 1; i < cumulative.length; i++) {
            cumulative[i] += cumulative[i - 1];
        }

        int[] result = new int[array.length];

        for (int i = array.length - 1; i >= 0; i--) {
            int digit = (array[i] / exp) % 100;
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
