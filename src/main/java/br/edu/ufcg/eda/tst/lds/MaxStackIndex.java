package br.edu.ufcg.eda.tst.lds;

import java.util.Arrays;
import java.util.Scanner;

class MaxStackIndex {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] array = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int index = Integer.parseInt(in.nextLine());

        Stack stk = new Stack(array.length);

        for (int value : array) {
            stk.push(value);
        }

        int bigger = -1;
        Stack aux = new Stack(index + 1);
        for (int i = 0; i <= index; i++) {
            int popValue = stk.pop();
            aux.push(popValue);
            if (popValue > bigger) {
                bigger = popValue;
            }
        }

        for (int i = 0; i <= index; i++) {
            stk.push(aux.pop());
        }

        System.out.println(bigger);
    }

    static class Stack {
        private int top;
        private int[] array;

        public Stack(int size) {
            this.top = -1;
            this.array = new int[size];
        }

        public void push(int v) {
            this.array[++top] = v;
        }

        public int pop() {
            int result = this.array[top];

            this.top--;

            return result;
        }

        public int peek() {
            return this.array[top];
        }
    }
}
