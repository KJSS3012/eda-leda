package br.edu.ufcg.eda.tst.elementary;

import java.util.Scanner;

class FindElement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String target = in.nextLine();
        String[] array = in.nextLine().split(" ");

        System.out.println(findElement(array, target));
    }

    public static String findElement(String[] array, String target) {
        for (String element: array) {
            if (element.equals(target)) {
                return "sim";
            }
        }
        return "nao";
    }
}
