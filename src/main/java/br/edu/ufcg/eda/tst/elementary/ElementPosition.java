package br.edu.ufcg.eda.tst.elementary;

import java.util.Scanner;

class ElementPosition {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String target = in.nextLine();
        String[] arrays = in.nextLine().split(" ");

        System.out.println(checkIndexElement(target, arrays));
    }

    public static String checkIndexElement(String target, String[] arrays) {
        String out = "";
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].equals(target)) {
                out += i + " ";
            }
        }

        if (out.isEmpty()) return "-1";

        return out.trim();
    }
 }
