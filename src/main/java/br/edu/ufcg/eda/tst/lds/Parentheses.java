package br.edu.ufcg.eda.tst.lds;

import java.util.Scanner;

class Parentheses {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();

        System.out.println(verifySequence(input));
    }

    private static String verifySequence(String input) {
        Stack stk = new Stack(input.length());

        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);

            if (character == '(') {
                stk.push("(");
            } else if (stk.pop().equals("f")) {
                return "N";
            }
        }
        if (!stk.isEmpty())
            return "N";

        return "S";
    }

    static class Stack {
        private int top;
        private String[] array;

        public Stack(int size) {
            this.top = -1;
            this.array = new String[size];
        }

        public void push(String value) {
            this.array[++top] = value;
        }

        public String pop() {
            if (isEmpty()) {
                return "f";
            }

            String result = this.array[top];
            top--;
            return result;
        }

        public boolean isEmpty() {
            return this.top == -1;
        }
    }
}
