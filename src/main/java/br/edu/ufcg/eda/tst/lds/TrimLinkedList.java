package br.edu.ufcg.eda.tst.lds;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

class TrimLinkedList {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedList lk = new LinkedList();

        int[] array = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int deletions = Integer.parseInt(in.nextLine());

        for (int v : array) {
            lk.addLast(v);
        }

        for (int i = 0; i < deletions; i++) {
            lk.removeFirst();
            lk.removeLast();
        }

        System.out.println(lk.toString());
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

        public void addLast(int value) {
            Node nn = new Node(value);

            if (isEmpty()) {
                this.tail = nn;
                this.head = nn;
            } else {
                this.tail.next = nn;
                nn.prev = this.tail;
                this.tail = nn;
            }

            this.size++;
        }

        public void removeFirst() {
            if (isEmpty())
                throw new NoSuchElementException();

            if (this.size == 1) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = this.head.next;
                this.head.prev = null;
            }

            this.size--;
        }

        public void removeLast() {
            if (isEmpty())
                throw new NoSuchElementException();

            if (this.size == 1) {
                this.head = null;
                this.tail = null;
            } else {
                this.tail = this.tail.prev;
                this.tail.next = null;
            }

            this.size--;
        }

        public String toString() {
            Node aux = this.head;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < this.size; i++) {
                sb.append(aux.value).append(" ");
                aux = aux.next;
            }

            String result = sb.toString();

            if (result.isEmpty())
                return "vazia";

            return sb.toString().trim();
        }
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
}
