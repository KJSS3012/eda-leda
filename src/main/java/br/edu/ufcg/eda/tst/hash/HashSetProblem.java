package br.edu.ufcg.eda.tst.hash;

import java.util.Scanner;

class HashSetProblem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int capacity = Integer.parseInt(in.nextLine());

        HashSet hs = new HashSet(capacity);

        String[] options = in.nextLine().split(" ");

        while (!options[0].equals("end")) {
            switch (options[0]) {
                case "put":
                    hs.put(Integer.parseInt(options[1]));
                    System.out.println(hs);
                    break;
                case "remove":
                    hs.remove(Integer.parseInt(options[1]));
                    System.out.println(hs);
                    break;
                case "contains":
                    System.out.println(hs.contains(Integer.parseInt(options[1])));
                    break;
            }

            options = in.nextLine().split(" ");
        }
    }

    private static class HashSet {
        private Integer[] array;
        private int size;

        private static final Integer DELETED = Integer.MIN_VALUE;

        public HashSet(int capacity) {
            this.array = new Integer[capacity];
            this.size = 0;
        }

        public boolean isFull() {
            return this.size == this.array.length;
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        public void remove(int key) {
            if (isEmpty()) {
                return;
            }

            int sondagem = 0;

            while (sondagem < this.array.length) {
                int hash = (hash(key) + sondagem) % this.array.length;

                if (this.array[hash] == null) {
                    return;
                }

                if (this.array[hash] == key) {
                    this.array[hash] = DELETED;
                    this.size -= 1;
                    return;
                }

                sondagem += 1;
            }
        }

        public void put(int key) {
            int sondagem = 0;

            while (sondagem < this.array.length) {
                int hash = (hash(key) + sondagem) % this.array.length;

                if (isFull() || contains(key)) {
                    return;
                }

                if (this.array[hash] == null || this.array[hash] == Integer.MIN_VALUE) {
                    this.array[hash] = key;
                    this.size += 1;
                    return;
                }

                if (this.array[hash] == key) {
                    return;
                }

                sondagem += 1;
            }
        }

        private int hash(int key) {
            return key % this.array.length;
        }

        public String toString() {
            String result = "[";
            for (Integer v : this.array) {
                if (v == null || v == Integer.MIN_VALUE) {
                    result += "null, ";
                } else {
                    result += v + ", ";
                }
            }

            result = result.trim().substring(0, result.length() - 2);

            return result + "]";
        }

        public boolean contains(int key) {
            int sondagem = 0;

            while (sondagem < this.array.length) {

                int hash = (hash(key) + sondagem) % this.array.length;

                if (this.array[hash] == null) {
                    return false;
                }

                if (this.array[hash] == key) {
                    return true;
                }

                sondagem += 1;
            }

            return false;
        }


    }
}
