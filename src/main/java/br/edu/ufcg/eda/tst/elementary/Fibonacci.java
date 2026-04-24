package br.edu.ufcg.eda.tst.elementary;

import java.util.Scanner;

class Fibonacci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());

        System.out.println(fibonacci(n));
    }

    public static int fibonacci(int n) {
        if(n == 0) return 0;

        if (n == 1) return 1;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}