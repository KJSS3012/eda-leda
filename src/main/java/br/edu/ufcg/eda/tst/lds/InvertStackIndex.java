package br.edu.ufcg.eda.tst.lds;

import java.util.Arrays;
import java.util.Scanner;

class InvertStackIndex {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int capacity = Integer.parseInt(in.nextLine());
        int[] array = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int index = Integer.parseInt(in.nextLine());

        Stack st = new Stack(capacity);
        Stack aux = new Stack(capacity);

        for (int v : array) {
            st.push(v);
        }

        String result = "";

        for (int i = 0; i <= index; i++) {
            aux.push(st.pop());
        }

        System.out.println("-");

        while (!aux.isEmpty()) {
            System.out.println(aux.pop());
        }

        while (!st.isEmpty()) {
            System.out.println(st.pop());
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

        public int peek() {
            return this.stack[this.top];
        }
    }
}
