package br.edu.ufcg.eda.tst.sort;

import java.util.Arrays;
import java.util.Scanner;

class NegativeCoutingSortStepByStep {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] array = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(in.nextLine());
        int smaller = Integer.parseInt(in.nextLine());

        negativeCountingSort(array, k, smaller);
    }

    private static void negativeCountingSort(int[] array, int k, int smaller) {
        int[] cumulative = new int[k - smaller + 1];

        for (int i = 0; i < array.length; i++) {
            int idx = array[i] - smaller;
            cumulative[idx] += 1;
            System.out.println(Arrays.toString(cumulative));
        }

        for (int i = 1; i < cumulative.length; i++) {
            cumulative[i] += cumulative[i -1];
        }

        System.out.println("Cumulativa do vetor de contagem - " + Arrays.toString(cumulative));

        int[] result = new int[array.length];

        for (int i = array.length - 1; i >= 0; i--) {
            int idx = array[i] - smaller;
            result[cumulative[idx] - 1] = array[i];
            cumulative[idx] -= 1;
        }

        System.out.println(Arrays.toString(cumulative));
        System.out.println(Arrays.toString(result));
    }
}
