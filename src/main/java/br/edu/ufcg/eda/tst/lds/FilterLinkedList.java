package br.edu.ufcg.eda.tst.lds;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

class FilterLinkedList {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] array = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int removeElement = Integer.parseInt(in.nextLine());

        LinkedList lk = new LinkedList();

        for (int v : array) {
            lk.addLast(v);
        }

        int stop = 0;
        while (stop != -1) {
            stop = lk.indexOf(removeElement);
            lk.remove(stop);
        }

        System.out.println(lk.toString());
    }

    static class LinkedList {
        private Node head;
        private Node tail;
        private int size;

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
                this.head = nn;
                this.tail = nn;
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
                this.tail = null;
                this.head = null;
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
                this.tail = null;
                this.head = null;
            } else {
                this.tail = this.tail.prev;
                this.tail.next = null;
            }

            this.size--;
        }

        public int indexOf(int value) {
            return indexOf(this.head, value, 0);
        }

        private int indexOf(Node node, int value, int index) {
            if (node == null) {
                return -1;
            }

            if (node.value == value) {
                return index;
            }

            return indexOf(node.next, value, index + 1);
        }

        public boolean remove(int index) {
            return remove(this.head, index, 0);
        }

        private boolean remove(Node head, int index, int count) {
            if (head == null) return false;

            if (index == 0) {
                removeFirst();
                return true;
            } else if (index == this.size -1) {
                removeLast();
                return true;
            } else if (index == count) {
                head.next.prev = head.prev;
                head.prev.next = head.next;
                this.size--;
                return true;
            }

            return remove(head.next, index, count + 1);
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
