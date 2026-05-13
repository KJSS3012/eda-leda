package br.edu.ufcg.eda.benchmark;

import br.edu.ufcg.eda.algorithms.interfaces.Algorithm;
import br.edu.ufcg.eda.algorithms.sorting.linear.CountingSort;
import br.edu.ufcg.eda.algorithms.sorting.logaritmica.QuickSort;
import br.edu.ufcg.eda.algorithms.sorting.quadratic.SelectionSort;
import br.edu.ufcg.eda.algorithms.sorting.strategy.partition.HoarePartition;
import br.edu.ufcg.eda.algorithms.sorting.strategy.partition.LomutoPartition;
import br.edu.ufcg.eda.algorithms.sorting.strategy.pivot.FirstPivot;
import br.edu.ufcg.eda.algorithms.sorting.strategy.pivot.MedianOfThreePivot;
import br.edu.ufcg.eda.algorithms.sorting.strategy.pivot.RandomPivot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class CalculateAlgorithm {

    // Execuções de warmup feitas UMA VEZ por algoritmo antes do loop de arrays.
    // Força o JIT a compilar o código para nativo antes de qualquer medição.
    // Custo fixo pequeno — não se repete para cada tamanho de entrada.
    private static final int WARMUP_EXECUTIONS = 5;

    // Percentual descartado em cada extremo para calcular a média aparada.
    // Com 50 execuções e 10%, descarta 5 amostras de cada lado (picos de SO/GC)
    // e calcula a média das 40 restantes — mais robusto que a mediana simples.
    private static final double TRIM_RATIO = 0.10;

    public static void main(String[] args) throws Exception {

        int executions = 50;

        if (args.length > 0) {
            executions = Integer.parseInt(args[0]);
        }

        // Lê todos os arrays antes de começar qualquer medição,
        // evitando que o custo de I/O contamine as amostras de tempo.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<int[]> arrays = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (!line.isEmpty()) {
                arrays.add(parseArray(line));
            }
        }

        Algorithm[] algorithms = {
                //new QuickSort(new LomutoPartition(new FirstPivot())),
                new QuickSort(new LomutoPartition(new RandomPivot())),
                //new QuickSort(new LomutoPartition(new MedianOfThreePivot())),

                //new QuickSort(new HoarePartition(new FirstPivot())),
                new QuickSort(new HoarePartition(new RandomPivot())),
                //new QuickSort(new HoarePartition(new MedianOfThreePivot()))
                new CountingSort()
        };

        System.out.println("Algorithm Time Samples");

        for (Algorithm algorithm : algorithms) {

            // Warmup feito uma única vez por algoritmo, usando o menor array disponível
            // para não desperdiçar tempo em entradas grandes.
            if (!arrays.isEmpty()) {
                int[] warmupArray = arrays.get(0);
                for (int i = 0; i < WARMUP_EXECUTIONS; i++) {
                    algorithm.run(Arrays.copyOf(warmupArray, warmupArray.length));
                }
            }

            // GC uma única vez por algoritmo, antes de começar a medir.
            // Reduz chance de coleta de lixo acontecer no meio das amostras
            // sem o custo de chamar GC a cada execução individual.
            System.gc();

            for (int[] array : arrays) {
                testAlgorithm(algorithm.toString(), algorithm, array, executions);
            }
        }
    }

    public static void testAlgorithm(
            String algorithmName,
            Algorithm algorithm,
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

        System.out.println(
                algorithmName + " " +
                        trimmedMean(times, TRIM_RATIO) + " " +
                        original.length
        );
    }

    // Descarta os extremos e retorna a média do intervalo central.
    // Mais robusto que a mediana: aproveita todas as amostras centrais
    // em vez de depender de um único ponto.
    private static long trimmedMean(long[] times, double trimRatio) {
        Arrays.sort(times);
        int cut = (int) (times.length * trimRatio);
        long sum = 0;
        for (int i = cut; i < times.length - cut; i++) {
            sum += times[i];
        }
        return sum / (times.length - 2 * cut);
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