package br.edu.ufcg.eda.tst.lds;

import java.util.Arrays;
import java.util.Scanner;

class RemoveIndexLinkedList {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] values = Arrays.stream(in.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int index = Integer.parseInt(in.nextLine());

        LinkedList lista = new LinkedList();

        for (int value : values) {
            lista.addLast(value);
        }

        lista.remove(index);

        System.out.println(lista.toString().trim());
    }

    static class LinkedList {

        protected Node head;
        protected Node tail;
        private int size;

        public LinkedList() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        public boolean isEmpty() {
            return this.head == null;
        }

        public void addLast(int value) {

            Node nn = new Node(value);

            if (isEmpty()) {
                this.head = nn;
                this.tail = nn;

            } else {
                nn.prev = this.tail;
                this.tail.next = nn;
                this.tail = nn;
            }

            this.size++;
        }

        public int remove(int index) {

            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }


            Node aux = this.head;


            if (index == 0) {
                return removeFirst();

            } else if (index == size - 1) {
                return removeLast();

            } else {

                for (int i = 0; i < index; i++) {
                    aux = aux.next;
                }

                aux.prev.next = aux.next;
                aux.next.prev = aux.prev;

                size--;

                return aux.value;
            }
        }

        public int removeFirst() {

            Node aux = this.head;

            if (aux.next == null) {

                this.head = null;
                this.tail = null;

            } else {

                this.head = aux.next;
                this.head.prev = null;
            }

            size--;

            return aux.value;
        }

        public int removeLast() {

            Node aux = this.tail;

            if (aux.prev == null) {

                this.head = null;
                this.tail = null;

            } else {

                this.tail = aux.prev;
                this.tail.next = null;
            }

            size--;

            return aux.value;
        }

        public int size() {
            return this.size;
        }

        public String toString() {

            Node aux = this.head;
            String answer = "";

            while (aux != null) {
                answer += aux.value + " ";
                aux = aux.next;
            }

            return answer;
        }

        static class Node {

            protected Node next;
            protected Node prev;
            protected int value;

            public Node(int value) {
                this.value = value;
                this.next = null;
                this.prev = null;
            }
        }
    }
}