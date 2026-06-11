package br.edu.ufcg.eda.tst.lds;

import java.util.Scanner;

class ReversePhrase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] array = in.nextLine().split(" ");

        Stack st = new Stack(array.length);

        for (String v : array) {
            st.push(v);
        }

        StringBuilder sb = new StringBuilder();
        Stack aux = new Stack(array.length);

        while (!st.isEmpty()) {
            String popValue = st.pop();

            sb.append(popValue).append(" ");
            aux.push(popValue);
        }

        while (!aux.isEmpty()) {
            st.push(aux.pop());
        }

        System.out.println(sb.toString().trim());
    }

    static class Stack {
        private int top;
        private String[] stack;

        public Stack(int capacity) {
            this.top = -1;
            this.stack = new String[capacity];
        }

        public boolean isEmpty() {
            return this.top ==  -1;
        }

        public void push(String v) {
            this.stack[++this.top] = v;
        }

        public String pop() {
            return this.stack[this.top--];
        }
    }
}
