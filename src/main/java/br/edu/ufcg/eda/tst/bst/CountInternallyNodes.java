package br.edu.ufcg.eda.tst.bst;

import java.util.Arrays;
import java.util.Scanner;

class CountInternallyNodes {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] array = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        BST bst = new BST();

        for (int j : array) {
            bst.add(j);
        }

        System.out.println(bst.countInternallyNodes());
    }

    public static class BST {
        private Node root;

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
                return node;
            };

            return min(node.left);
        }

        public Node max() {
            if (isEmpty()) return null;

            return max(this.root);
        }

        private Node max(Node node) {
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
                aux = aux.parent;
            }

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

        public int countInternallyNodes() {
            if (isEmpty()) return 0;

            return countInternallyNodes(this.root);
        }

        private int countInternallyNodes(Node node) {
            if (node == null) return 0;

            if (!isLeaf(node)) return 1 + countInternallyNodes(node.right) + countInternallyNodes(node.left);

            return 0;
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
