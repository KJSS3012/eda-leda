package br.edu.ufcg.eda.tst.lds;

import java.util.Scanner;

class QueueWithArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int capacity = Integer.parseInt(in.nextLine());

        Queue queue = new Queue(capacity);

        String[] input;
        do {
            input = in.nextLine().split(" ");

            switch (input[0]) {
                case "print":
                    System.out.println(queue.print());
                    break;
                case "add":
                    queue.addLast(Integer.parseInt(input[1]));
                    break;
                case "remove":
                    queue.removeFirst();
                    break;
                case "element":
                    System.out.println(queue.getFirst());
                    break;
            }
        } while (!input[0].equals("end"));
    }

    static class Queue {
        private int head;
        private int tail;
        private int size;
        private int[] queue;

        public Queue(int capacity) {
            this.head = -1;
            this.tail = -1;
            this.size = 0;
            this.queue = new int[capacity];
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        public boolean isFull() {
            return this.size == this.queue.length;
        }

        public String getFirst() {
            if (this.isEmpty()) {
                return "empty";
            }

            return Integer.toString(this.queue[this.head]);
        }

        public void addLast(int v) {
            if (isFull()) {
                System.out.println("full");
            } else if (this.size == 0){
                this.head = 0;
                this.tail = 0;
                this.queue[this.tail] = v;
                this.size++;
            } else {
                this.tail = (this.tail + 1) % this.queue.length;
                this.queue[this.tail] = v;
                this.size++;
            }
        }

        public void removeFirst() {
            if (this.isEmpty()) {
                System.out.println("empty");
            } else if (this.size == 1) {
                this.head = -1;
                this.tail = -1;
                this.size = 0;
            } else {
                this.head = (this.head + 1) % this.queue.length;
                this.size--;
            }
        }

        public String print() {
            if (this.isEmpty()) {
                return "empty";
            }

            String result = "";

            for (int i = 0; i < this.size; i++) {
                int idx = (this.head + i) % this.queue.length;
                result += this.queue[idx] + " ";
            }

            return result.trim();
        }
    }
}
