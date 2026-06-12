package br.edu.ufcg.eda.tst.lds;

import java.util.Arrays;
import java.util.Scanner;

class ElementAtStack {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] array = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int index = Integer.parseInt(in.nextLine());

        Stack st = new Stack(array.length);

        for (int v : array) {
            st.push(v);
        }

        int result = st.get(index);

        if (result == -1) {
            System.out.println("indice invalido");
        } else {
            System.out.println(st.get(index));
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
            this.stack[++top] = v;
        }

        public int pop() {
            return this.stack[this.top--];
        }

        public int size() {
            return this.top + 1;
        }

        public int get(int index) {
            if (index < 0 || index > this.top) {
                return -1;
            }

            Stack aux = new Stack(this.stack.length);

            for (int i = this.size() - 1; i >= 0; i--) {
                int popValue = this.pop();

                if (i == index) {
                    aux.push(popValue);

                    restructure(aux);

                    return popValue;
                }

                aux.push(popValue);
            }

            restructure(aux);

            return -1;
        }

        private void restructure(Stack aux) {
            while (!aux.isEmpty()) {
                this.push(aux.pop());
            }
        }

    }
}
