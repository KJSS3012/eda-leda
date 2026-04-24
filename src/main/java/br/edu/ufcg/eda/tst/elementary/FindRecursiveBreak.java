package br.edu.ufcg.eda.tst.elementary;

import java.util.Scanner;

class FindRecursiveBreak {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] array = in.nextLine().split(" ");

        System.out.println(findBreak(array, 0));
    }

    public static int findBreak(String[] array, int start) {
        if (start >= array.length -1) {
            return -1;
        }

        if (Integer.parseInt(array[start]) > Integer.parseInt(array[start + 1])) {
            return start + 1;
        }

        return findBreak(array, ++start);
    }
}
