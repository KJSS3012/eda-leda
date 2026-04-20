package br.edu.ufcg.eda.tst.sort;

import java.util.Scanner;

class MarianaAndTheBooks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] arrays = in.nextLine().split(",");

        fixArray(arrays);
    }
    
    public static void fixArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j].compareTo(array[j - 1]) < 0) {
                String aux = array[j];
                array[j] = array[j - 1];
                array[j - 1] = aux;
                j--;
            }
            System.out.println(String.join(", ", array));
        }
    }
}