package br.edu.ufcg.eda.tst.elementary;

import java.util.Arrays;
import java.util.Scanner;

class ChangeNeighbors {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] arrays = in.nextLine().split(" ");

        changeNeighbors(arrays);

        System.out.println(Arrays.toString(arrays));
    }

    public static void changeNeighbors(String[] array) {
        int end = array.length % 2 == 0 ? array.length : array.length - 2;

        for (int i = 0; i < end; i += 2) {
            String aux = array[i];
            array[i] = array[i + 1];
            array[i + 1] =  aux;
        }
    }
}
