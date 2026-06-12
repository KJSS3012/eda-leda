package br.edu.ufcg.eda.tst.lds;

import java.util.Arrays;
import java.util.Scanner;

class SortStackByReversing {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int capacity = Integer.parseInt(in.nextLine());
        int[] array = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Stack st = new Stack(capacity);

        for (int v : array) {
            st.push(v);
        }

        System.out.println("-");

        Stack aux = new Stack(capacity);
        while (!st.isEmpty()) {
            int maxIdx = st.getMax();
            st.invert(maxIdx);

            aux.push(st.pop());
        }

        while (!aux.isEmpty()) {
            System.out.println(aux.pop());
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

        public int getMax() {
            Stack aux = new Stack(this.stack.length);

            int idx = 0;
            int bigger = peek();

            int count = 0;

            while (!this.isEmpty()) {
                int value = this.pop();

                if (value > bigger) {
                    bigger = value;
                    idx = count;
                }

                aux.push(value);
                count++;
            }

            while (!aux.isEmpty()) {
                this.push(aux.pop());
            }

            return idx;
        }

        public void invert(int index) {
            Stack aux = new Stack(index + 1);
            Stack temp = new Stack(this.stack.length);

            for (int i = 0; i <= index; i++) {
                aux.push(this.pop());
            }

            while (!aux.isEmpty()) {
                temp.push(aux.pop());
            }

            while (!temp.isEmpty()) {
                this.push(temp.pop());
            }
        }
    }
}
