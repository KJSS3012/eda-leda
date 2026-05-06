package br.edu.ufcg.eda.tst.elementary;

import java.util.Scanner;

class RecursiveBinarySearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] array = in.nextLine().split(" ");
        int target = Integer.parseInt(in.nextLine());

        binarySearch(array, target, 0, array.length - 1);
    }

    public static int binarySearch(String[] array, int target, int start, int end) {
        if (start > end) {
            System.out.println(-1);
            return -1;
        }

        int mid = (start + end) / 2;
        int midValue = Integer.parseInt(array[mid]);

        System.out.println(mid);

        if (midValue == target) {
            return mid;
        }

        if (target < midValue) {
            return binarySearch(array, target, start, mid - 1);
        } else {
            return binarySearch(array, target, mid + 1, end);
        }
    }
}