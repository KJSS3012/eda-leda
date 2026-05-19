package br.edu.ufcg.eda.tst.sort;

import java.util.Arrays;
import java.util.Scanner;

class CountingSortStepByStep {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] array = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(in.nextLine());

        countingSort(array, k);
    }

    private static void countingSort(int[] array, int k) {
        int[] cumulative = new int[k + 1];

        for (int i = 0; i < array.length; i++) {
            cumulative[array[i]] += 1;
            System.out.println(printArray(cumulative));
        }

        for (int i = 1; i < cumulative.length; i++) {
            cumulative[i] += cumulative[i - 1];
        }

        System.out.println("Cumulativa do vetor de contagem - " + printArray(cumulative));

        int[] result = new int[array.length];

        for (int i = array.length - 1; i >= 0; i--) {
            int value = array[i];
            int position = cumulative[value] - 1;

            result[position] = value;
            cumulative[value] -= 1;
        }

        System.out.println(printArray(cumulative));
        System.out.println(printArray(result));
    }

    private static String printArray(int[] array) {
        return Arrays.stream(array)
                .mapToObj(String::valueOf)
                .collect(java.util.stream.Collectors.joining(" "));
    }
}