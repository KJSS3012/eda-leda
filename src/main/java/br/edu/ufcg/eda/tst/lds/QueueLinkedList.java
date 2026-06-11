package br.edu.ufcg.eda.tst.lds;

import java.util.Scanner;

class QueueLinkedList {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedList lk = new LinkedList();

        String[] input = in.nextLine().split(" ");

        while (!input[0].equals("end")) {
            switch (input[0]) {
                case "print":
                    System.out.println(lk.toString());
                    break;
                case "add":
                    lk.addLast(Integer.parseInt(input[1]));
                    break;
                case "element":
                    System.out.println(lk.getFirst());
                    break;
                case "remove":
                    if (lk.removeFirst().equals("empty"))
                    System.out.println("empty");
                    break;
                case "search":
                    System.out.println(lk.indexOf(Integer.parseInt(input[1])));
                    break;
            }
            input = in.nextLine().split(" ");
        }
    }


    static class LinkedList {
        Node head;
        Node tail;
        int size;

        public LinkedList() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        public boolean isEmpty() {
            return this.head == null;
        }

        public void addLast(int v) {
            Node nn = new Node(v);
            if (isEmpty()) {
                this.tail = nn;
                this.head = nn;
            } else {
                nn.prev = this.tail;
                this.tail.next = nn;
                this.tail = nn;
            }

            this.size++;
        }

        public String getFirst() {
            if (isEmpty()) {
                return "empty";
            }

            return Integer.toString(this.head.value);
        }

        public String removeFirst() {
            if (isEmpty()) {
                return "empty";
            }

            if (this.size == 1) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = this.head.next;
                this.head.prev = null;
            }
            this.size--;

            return "";
        }

        public String indexOf(int search) {
            return Integer.toString(indexOf(this.head, search, 0));
        }

        private int indexOf(Node head, int search, int idx) {
            if (head == null) return -1;

            if (head.value == search) return idx;

            return indexOf(head.next, search, idx + 1);
        }

        public String toString() {
            return toString(this.head).trim();
        }

        private String toString(Node head) {
            if (isEmpty()) return "empty";

            if (head == null) return "";

            return head.value + " " + toString(head.next);
        }
    }

    static class Node {
        Node next;
        Node prev;
        int value;

        public Node(int v) {
            this.next = null;
            this.prev = null;
            this.value = v;
        }
    }
}
