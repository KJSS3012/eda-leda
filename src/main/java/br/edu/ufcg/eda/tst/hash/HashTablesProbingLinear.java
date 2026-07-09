package br.edu.ufcg.eda.tst.hash;

import java.util.Arrays;
import java.util.Scanner;

class HashTablesProbingLinear {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int capacity = Integer.parseInt(in.nextLine());

        HashMap hm = new HashMap(capacity);

        String[] options = in.nextLine().split(" ");

        while (!options[0].equals("end")) {
            switch (options[0]) {
                case "put":
                    hm.put(Integer.parseInt(options[1]), options[2]);
                    System.out.println(hm);
                    break;
                case "remove":
                    hm.remove(Integer.parseInt(options[1]));
                    System.out.println(hm);
                    break;
                case "keys":
                    System.out.println(hm.keys());
                    break;
                case "values":
                    System.out.println(hm.values());
                    break;
            }

            options = in.nextLine().split(" ");
        }
    }

    public static class HashMap {
        private Pair[] array;
        private int size;

        private static final Pair DELETED = new Pair(Integer.MIN_VALUE, "DELETED");

        public HashMap(int capacity) {
            this.array = new Pair[capacity];
            this.size = 0;
        }

        public int hash(int key) {
            return key % this.array.length;
        }

        public boolean contains(int key) {
            int sondagem = 0;

            while (sondagem < this.array.length) {
                int hash = (hash(key) + sondagem) % this.array.length;
                Pair value = this.array[hash];

                if (value == null) {
                    return false;
                }

                if (value.getId() ==  key) {
                    return true;
                }

                sondagem++;
            }

            return false;
        }

        public boolean isFull() {
            return this.size == this.array.length;
        }

        public void remove(int key) {
            int sondagem = 0;

            while (sondagem < this.array.length) {
                int hash = (hash(key) + sondagem) % this.array.length;
                Pair value = this.array[hash];

                if (value == null) {
                    return;
                }

                if (value.getId() == key) {
                    this.array[hash] = DELETED;
                    this.size--;
                    return;
                }

                sondagem++;
            }
        }

        public void put(int key, String name) {
            int sondagem = 0;

            while (sondagem < this.array.length) {
                int hash = (hash(key) + sondagem) % this.array.length;
                Pair value = this.array[hash];

                if (value != null && value.getId() == key) {
                    this.array[hash] = new Pair(key, name);
                    return;
                }

                if (isFull()) {
                    return;
                }

                if (value == null || (value.getId() == Integer.MIN_VALUE && !contains(key))) {
                    this.array[hash] = new Pair(key, name);
                    this.size++;
                    return;
                }

                sondagem++;
            }
        }

        public String keys() {
            int tam = 0;

            for (Pair p : this.array) {
                if (p != null && p.getId() != Integer.MIN_VALUE) {
                    tam++;
                }
            }

            int[] values = new int[tam];

            int i = 0;
            for (Pair p : this.array) {
                if (p != null && p.getId() != Integer.MIN_VALUE) {
                    values[i] = p.getId();
                    i++;
                }
            }


            Arrays.sort(values);

            return Arrays.toString(values);
        }

        public String values() {
            int tam = 0;

            for (Pair p : this.array) {
                if (p != null && p.getId() != Integer.MIN_VALUE) {
                    tam++;
                }
            }

            String values[] = new String[tam];

            int i = 0;
            for (Pair p : this.array) {
                if (p != null && p.getId() != Integer.MIN_VALUE) {
                    values[i] = p.name;
                    i++;
                }
            }
            Arrays.sort(values);

            return Arrays.toString(values);
        }

        public String toString() {
            String result = "[";

            for (Pair p : this.array) {
                if (p == null || p.getId() == Integer.MIN_VALUE) {
                    result += "null, ";
                } else {
                    result += p.toString() + ", ";
                }
            }
            result = result.trim().substring(0, result.length() - 2);

            return result + "]";
        }
    }


    public static class Pair {
        private int id;
        private String name;

        public Pair(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public int getId() {
            return this.id;
        }

        public String toString() {
            return String.format("<%d, %s>", this.id, this.name);
        }
    }
}
