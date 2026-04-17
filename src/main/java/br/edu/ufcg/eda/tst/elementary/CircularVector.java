package br.edu.ufcg.eda.tst.elementary;

import java.util.Scanner;

class CircularVector {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] array = in.nextLine().split(" ");
        int rounds = Integer.parseInt(in.nextLine());

        System.out.println(executeCircularVector(rounds, array));
    }

    public static String executeCircularVector(int rounds, String[] array) {
        int index = 0;
        String out = "";
        for (int i = 0; i < rounds; i++) {
            out += array[index] + " ";
            index = ++index % array.length;
        }

        return  out.trim();
    }
}
