package br.edu.ufcg.eda.tst.lds;

import java.util.Arrays;
import java.util.Scanner;

class InvertStack {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int capacity = Integer.parseInt(in.nextLine());
        int[] array = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Stack st = new Stack(capacity);

        for (int v : array) {
            st.push(v);
        }

        Stack aux = new Stack(capacity);

        while (!st.isEmpty()) {
            aux.push(st.pop());
        }

        while (!aux.isEmpty()) {
            int popValue = aux.pop();

            System.out.println(popValue);

            st.push(popValue);
        }
    }

    static class Stack {
        private int top;
        private int[] stack;

        public Stack(int capacity) {
            this.top = -1;
            this.stack = new int[capacity];
        }

        public boolean isEmpty() {
            return this.top == -1;
        }

        public void push(int v) {
            this.stack[++this.top] = v;
        }

        public int pop() {
            return this.stack[this.top--];
        }
    }
}
