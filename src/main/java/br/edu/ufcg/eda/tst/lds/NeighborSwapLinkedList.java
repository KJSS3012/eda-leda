package br.edu.ufcg.eda.tst.lds;

import java.util.Arrays;
import java.util.Scanner;

class NeighborSwapLinkedList {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] array = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int index = Integer.parseInt(in.nextLine());

        LinkedList lk = new LinkedList();

        for (int value : array) {
            lk.addLast(value);
        }

        lk.swap(index);

        System.out.println(lk);
    }

    public static class LinkedList {

        private int size;
        private Node head;
        private Node tail;

        public LinkedList() {
            this.size = 0;
            this.head = null;
            this.tail = null;
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


        static class Node {

            Node next;
            Node prev;
            int value;

            public Node(int value) {
                this.next = null;
                this.prev = null;
                this.value = value;
            }
        }

        public void swap(int index) {

            Node aux = this.head;

            for (int i = 0; i < index; i++) {
                aux = aux.next;
            }

            Node neighbor = aux.next;

            if (aux.prev != null) {
                aux.prev.next = neighbor;
            } else {
                this.head = neighbor;
            }

            neighbor.prev = aux.prev;


            aux.next = neighbor.next;

            if (neighbor.next != null) {
                neighbor.next.prev = aux;
            } else {
                this.tail = aux;
            }

            neighbor.next = aux;
            aux.prev = neighbor;
        }

        public String toString() {
            String result = "";

            Node aux = this.head;
            for (int i = 0; i < this.size; i++) {
                result += aux.value + " ";
                aux = aux.next;
            }
            return result.trim();
        }
    }
}