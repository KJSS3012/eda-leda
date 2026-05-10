package br.edu.ufcg.eda.benchmark;

import java.util.Random;

public class GenerateArrays {

    private static final Random random = new Random();

    public static void main(String[] args) {
        int[] inputs = {
                100, 200, 300, 400, 500,
                600, 700, 800, 900, 1000,
                1100, 1200, 1300, 1400, 1500,
                1600, 1700, 1800, 1900, 2000,
                2100, 2200, 2300, 2400, 2500,
                2600, 2700, 2800, 2900, 3000,
                3100, 3200, 3300, 3400, 3500,
                3600, 3700, 3800, 3900, 4000,
                4100, 4200, 4300, 4400, 4500,
                4600, 4700, 4800, 4900, 5000,
                5200, 5400, 5600, 5800, 6000,
                6200, 6400, 6600, 6800, 7000,
                7200, 7400, 7600, 7800, 8000,
                8200, 8400, 8600, 8800, 9000,
                9200, 9400, 9600, 9800, 10000,
                10500, 11000, 11500, 12000,
                12500, 13000, 13500, 14000,
                14500, 15000,
                16000, 17000, 18000, 19000, 20000,
                22500, 25000, 27500, 30000,
                35000, 40000, 45000, 50000,
                60000, 70000, 80000, 90000, 100000,
        };

        for (int size : inputs) {

            //int[] sorted = generateSorted(size);
            //printArray(sorted);

            //int[] randomArray = generateRandom(size);
            //printArray(randomArray);

            int[] reversedArray = generateReversed(size);
            printArray(reversedArray);
        }
    }

    public static int[] generateSorted(int size) {
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }

        return array;
    }

    public static int[] generateReversed(int size) {
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = size - i;
        }

        return array;
    }

    public static int[] generateRandom(int size) {
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size) + 1;
        }

        return array;
    }

    public static void printArray(int[] array) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);

            if (i < array.length - 1) {
                sb.append(" ");
            }
        }

        System.out.println(sb);
    }
}