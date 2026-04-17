package br.edu.ufcg.eda.tst.elementary;

import java.util.Arrays;
import java.util.Scanner;

class MoveImpostor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] input = in.nextLine().split(" ");
        int[] array = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        fixArrayWithImpostor(findImpostor(array), array);

        System.out.println(Arrays.toString(array));
    }

    public static int findImpostor(int[] array) {
        int i = 0;

        while (i < array.length - 1 && array[i + 1] > array[i]) {
            i++;
        }

        return i + 1;
    }

    public static void fixArrayWithImpostor(int impostorIdx, int[] array) {
        int i = impostorIdx;

        while (i > 0 && array[i - 1] > array[i]) {
            int aux = array[i];
            array[i] = array[i - 1];
            array[i - 1] = aux;
            i--;
        }
    }
}