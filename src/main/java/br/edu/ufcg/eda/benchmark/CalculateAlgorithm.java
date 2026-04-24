package br.edu.ufcg.eda.benchmark;

import br.edu.ufcg.eda.algorithms.sorting.Sorter;
import br.edu.ufcg.eda.algorithms.sorting.quadratic.BubbleSort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CalculateAlgorithm {

    public static void main(String[] args) throws Exception {

        int executions = 100;

        if (args.length > 0) {
            executions = Integer.parseInt(args[0]);
        }

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String line;

        System.out.println("Algorithm Time Samples");

        while ((line = reader.readLine()) != null) {

            line = line.trim();

            if (line.isEmpty()) {
                continue;
            }

            int[] array = parseArray(line);

            testAlgorithm(
                    "BubbleSort",
                    new BubbleSort(),
                    array,
                    executions
            );
        }
    }

    public static void testAlgorithm(
            String algorithmName,
            Sorter algorithm,
            int[] original,
            int executions
    ) {

        long[] times = new long[executions];

        for (int i = 0; i < executions; i++) {

            int[] copy = Arrays.copyOf(original, original.length);

            long start = System.nanoTime();

            algorithm.run(copy);

            long end = System.nanoTime();

            times[i] = end - start;
        }

        Arrays.sort(times);

        long median = times[times.length / 2];

        System.out.println(
                algorithmName + " " +
                        median + " " +
                        original.length
        );
    }

    public static int[] parseArray(String line) {

        String[] values = line.split(" ");

        int[] array = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            array[i] = Integer.parseInt(values[i]);
        }

        return array;
    }
}