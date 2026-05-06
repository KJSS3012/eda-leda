package br.edu.ufcg.eda.tst.elementary;

import java.util.Scanner;

class BinarySearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] array = in.nextLine().split(" ");
        int target = Integer.parseInt(in.nextLine());

        find(array, target);
    }

    public static int find(String[] array, int target) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int midValue = Integer.parseInt(array[mid]);

            System.out.println(mid);

            if (target == midValue) return mid;

            if (target < midValue) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(-1);
        return -1;
    }
}
