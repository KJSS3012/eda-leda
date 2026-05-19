package br.edu.ufcg.eda.tst.sort;

import java.util.Arrays;
import java.util.Scanner;

class BestPivot {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] array = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] values = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(findBestPivot(array, values));
    }

    private static int findBestPivot(int[] array, int[] values) {
        float summer = 0;
        for (int value : array) {
            summer += value;
        }

        float result = summer / array.length;

        float meanFistNumber = Math.abs(result - array[values[0]]);
        float meanSecondNumber = Math.abs(result - array[values[1]]);

        if (meanFistNumber == meanSecondNumber) {
            return values[0];
        } else if (meanFistNumber < meanSecondNumber){
            return  values[0];
        } else {
            return values[1];
        }
    }
}
