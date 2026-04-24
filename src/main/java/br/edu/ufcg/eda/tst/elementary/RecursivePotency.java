package br.edu.ufcg.eda.tst.elementary;

import java.util.Scanner;

class RecursivePotency {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int i = Integer.parseInt(in.nextLine());
        int j = Integer.parseInt(in.nextLine());

        System.out.println(potency(i, j, 1,0));
    }

    public static int potency(int base, int exponent, int summer, int start) {
        if (start == exponent) return summer;

        return potency(base, exponent, summer * base, start + 1);
    }
}