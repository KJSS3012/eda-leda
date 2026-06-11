package br.edu.ufcg.eda.tst.lds;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Scanner;

class MaxStack {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] array = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Stack st = new Stack(array.length);

        for (int v : array) {
            st.push(v);
        }

        int bigger = st.peek();
        Stack aux = new Stack(array.length);

        while (!st.isEmpty()) {
            int popValue = st.pop();

            if (popValue > bigger)
                bigger = popValue;

            aux.push(popValue);
        }

        while (!aux.isEmpty()) {
            st.push(aux.pop());
        }

        System.out.println(bigger);
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

        public boolean isFull() {
            return this.top == this.stack.length - 1;
        }

        public void push(int value) {
            if (isFull())
                throw new IllegalArgumentException();

            this.stack[++this.top] = value;
        }

        public int pop() {
            if (isEmpty())
                throw new EmptyStackException();

            return this.stack[this.top--];
        }

        public int peek() {
            return this.stack[this.top];
        }
    }
}
