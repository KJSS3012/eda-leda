package br.edu.ufcg.eda.tst.elementary;

import java.util.Scanner;

class ElementFrequency {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String target = in.nextLine();
        String[] array = in.nextLine().split(" ");

        System.out.println(countFrequency(array, target));
    }

    public static int countFrequency(String[] array, String target) {
        int counter = 0;
        for (String s : array) {
            if (s.equals(target)) {
                counter++;
            }
        }
        return counter;
    }
}
