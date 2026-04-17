package br.edu.ufcg.eda.tst.elementary;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class ContainsDuplicate {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] array = in.nextLine().split(" ");
        System.out.println(checkDuplicateLinear(array));
    }

    public static boolean checkDuplicateQuadratic(String[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].equals(array[j])) return true;
            }
        }
        return false;
    }

    public static boolean checkDuplicateLinear(String[] array) {
        Set<String> set = new HashSet<>();

        for (String s : array) {
            if (set.contains(s)) {
                return true;
            } else {
                set.add(s);
            }
        }
        return false;
    }
}
