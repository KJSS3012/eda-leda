package br.edu.ufcg.eda.tst.elementary;

import java.util.Scanner;

class RecursiveLinearSearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] array = in.nextLine().split(" ");
        String target = in.nextLine();

        System.out.println(linearSearch(array, target, 0));

    }

    public static int linearSearch(String[] array, String target, int start) {
        if (start >= array.length) return -1;

        if (array[start].equals(target)) return start;

        return linearSearch(array, target, start + 1);
    }
}
