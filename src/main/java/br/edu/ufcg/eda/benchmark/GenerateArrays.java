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
                5100, 5200, 5300, 5400, 5500,
                5600, 5700, 5800, 5900, 6000,
                6100, 6200, 6300, 6400, 6500,
                6600, 6700, 6800, 6900, 7000,
                7100, 7200, 7300, 7400, 7500,
                7600, 7700, 7800, 7900, 8000,
                8100, 8200, 8300, 8400, 8500,
                8600, 8700, 8800, 8900, 9000,
                9100, 9200, 9300, 9400, 9500,
                9600, 9700, 9800, 9900, 10000
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