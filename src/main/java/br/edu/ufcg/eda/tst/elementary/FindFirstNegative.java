package br.edu.ufcg.eda.tst.elementary;

import java.util.Arrays;
import java.util.Scanner;

class FindFirstNegative {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] array = in.nextLine().split(" ");

        System.out.println(checkFirstNegativeRecursive(array));
    }

    public static String checkFirstNegativeRecursive(String[] array) {
        if (array.length == 0) return "-";

        if(array[0].compareTo("0") < 0) return array[0];

        return checkFirstNegativeRecursive(Arrays.copyOfRange(array, 1, array.length));
    }
}
