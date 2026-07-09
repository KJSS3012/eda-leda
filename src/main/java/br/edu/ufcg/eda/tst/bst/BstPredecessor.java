package br.edu.ufcg.eda.tst.bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class BstPredecessor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] array = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(in.nextLine());

        BST bst = new BST();
        for (int i = 0; i < array.length; i++) {
            bst.add(array[i]);
        }

        bst.predecessor(bst.search(target));
        System.out.println(bst.toArray());

    }

    public static class BST {
        private Node root;
        private List<Integer> list;

        public BST() {
            this.list = new ArrayList<>();
        }

        public boolean isEmpty() {
            return root == null;
        }

        public boolean isLeaf(Node node) {
            return node != null && node.right == null && node.left == null;
        }

        public int height() {
            if (isEmpty()) return -1;

            return height(this.root);
        }

        private int height(Node node) {
            if (node == null) return -1;

            return 1 + Math.max(height(node.right), height(node.left));
        }

        public Node search(int v) {
            if (isEmpty()) return null;
            list.add(v);

            return search(this.root, v);
        }

        private Node search(Node node, int v) {
            if (node == null) return null;

            if (node.value == v) return node;

            if (node.value < v) {
                return search(node.right, v);
            } else {
                return search(node.left, v);
            }
        }

        public Node min() {
            if (isEmpty()) return null;

            return min(this.root);
        }

        private Node min(Node node) {
            if (node.left == null) {
                list.add(node.value);
                return node;
            };

            return min(node.left);
        }

        public Node max() {
            if (isEmpty()) return null;

            return max(this.root);
        }

        private Node max(Node node) {
            list.add(node.value);

            if (node.right == null) {
                return node;
            };

            return max(node.right);
        }

        public void add(int v) {

            Node newNode = new Node(v);

            if (isEmpty()) {
                this.root = new Node(v);
                return;
            }

            Node aux = this.root;

            while (aux != null) {

                if (v > aux.value) {
                    if (aux.right == null) {
                        aux.right = newNode;
                        newNode.parent = aux;
                        return;
                    }

                    aux = aux.right;
                } else {
                    if (aux.left == null) {
                        aux.left = newNode;
                        newNode.parent = aux;
                        return;
                    }

                    aux = aux.left;
                }
            }
        }

        public Node predecessor(Node node) {
            if (node == null) return null;

            if (node.left != null) {
                return max(node.left);
            }

            Node aux = node.parent;

            while (aux != null && aux.value > node.value) {
                list.add(aux.value);
                aux = aux.parent;
            }

            if (aux != null)
                list.add(aux.value);

            return aux;
        }

        public Node sucessor(Node node) {
            if (node == null) return null;

            if (node.right != null)
                return min(node.right);
            else {
                Node aux = node.parent;

                while (aux != null && aux.value < node.value)
                    aux = aux.parent;

                return aux;
            }
        }

        public String toArray() {
            return Arrays.toString(list.toArray());
        }
    }

    public static class Node {
        public Node parent;
        public Node left;
        public Node right;
        public int value;

        public Node(int value) {
            this.value = value;
        }
    }
}
