package br.edu.ufcg.eda.tst.elementary;

import java.util.Scanner;

class MultiplyByN {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        String[] array = in.nextLine().split(" ");

        System.out.println(multiplyArray(n, array));
    }

    public static String multiplyArray(int n, String[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = String.format("%d", Integer.parseInt(array[i]) * n);
        }
        return String.join(" ", array);
    }
}