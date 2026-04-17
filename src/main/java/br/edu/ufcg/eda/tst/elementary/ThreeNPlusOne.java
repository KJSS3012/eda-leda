package br.edu.ufcg.eda.tst.elementary;

import java.util.Scanner;

class ThreeNPlusOne {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String out = "";
        int i = Integer.parseInt(in.nextLine());
        int j = Integer.parseInt(in.nextLine());

        out += getMaxSequenceLength(i, j);

        System.out.println(out.trim());
    }

    public static int calculateSequenceLength(int number) {
        int summer = 1;

        while (number != 1) {
            if (number % 2 == 0) {
                number /= 2;
            } else {
                number  = number * 3 + 1;
            }
            summer += 1;
        }
        return summer;
    }

    public static int getMaxSequenceLength(int i, int j) {
        int bigger = 0;
        for (int k = i; k <= j ; k++) {
            bigger = Math.max(calculateSequenceLength(k), bigger);
        }
        return bigger;
    }
}
