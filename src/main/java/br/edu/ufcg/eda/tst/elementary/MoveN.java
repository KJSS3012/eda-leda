package br.edu.ufcg.eda.tst.elementary;

import java.util.Arrays;
import java.util.Scanner;

class MoveN {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] array = in.nextLine().split(" ");

        fixArray(findImpostor(array), array);
    }

    public static int findImpostor(String[] array) {
        int i = 0;
        while (i < array.length && Integer.parseInt(array[i]) < Integer.parseInt(array[i + 1])) {
            i++;
        }

        return ++i;
    }

    public static void fixArray(int impostorIdx, String[] array) {
        for (int i = impostorIdx; i < array.length; i++) {
            int j = i;
            while (j > 0 && Integer.parseInt(array[j]) < Integer.parseInt(array[j - 1])) {
                String aux = array[j];
                array[j] = array[j - 1];
                array[j - 1] = aux;
                j--;
                System.out.println(Arrays.toString(array));
            }
        }
    }
}