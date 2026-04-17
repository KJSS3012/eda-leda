package br.edu.ufcg.eda.tst.elementary;

import java.util.Scanner;

class DownN {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] array = in.nextLine().split(" ");
        int quantityElements = Integer.parseInt(in.nextLine());

        bubbleSort(array);

        System.out.println(getNSmallerElements(quantityElements, array));
    }

    public static void bubbleSort(String[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if(Integer.parseInt(array[j]) > Integer.parseInt(array[j + 1])) {
                    String aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                }
            }
        }
    }

    public static String getNSmallerElements(int quantityElements, String[] array) {
        String out = "";
        for (int i = 0; i < quantityElements; i++) {
            out += array[i] + " ";
        }

        return out.trim();
    }
}