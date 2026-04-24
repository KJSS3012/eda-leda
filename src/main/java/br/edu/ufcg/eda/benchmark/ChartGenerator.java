package br.edu.ufcg.eda.benchmark;

import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.XYSeries;

import java.util.*;

public class ChartGenerator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextLine()) {
            System.out.println("No input received.");
            return;
        }

        scanner.nextLine();

        Map<String, List<Integer>> xData = new LinkedHashMap<>();
        Map<String, List<Long>> yData = new LinkedHashMap<>();

        while (scanner.hasNext()) {

            String algorithm = scanner.next();

            if (!scanner.hasNextLong()) break;
            long time = scanner.nextLong();

            if (!scanner.hasNextInt()) break;
            int samples = scanner.nextInt();

            xData.putIfAbsent(algorithm, new ArrayList<>());
            yData.putIfAbsent(algorithm, new ArrayList<>());

            xData.get(algorithm).add(samples);
            yData.get(algorithm).add(time);
        }

        if (xData.isEmpty()) {
            System.out.println("No benchmark data found.");
            return;
        }

        XYChart chart = new XYChartBuilder()
                .width(1200)
                .height(800)
                .title("Algorithm Benchmark")
                .xAxisTitle("Samples")
                .yAxisTitle("Time (ns)")
                .build();


        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
        chart.getStyler().setMarkerSize(6);
        chart.getStyler().setDefaultSeriesRenderStyle(
                XYSeries.XYSeriesRenderStyle.Line
        );

        for (String algorithm : xData.keySet()) {
            chart.addSeries(
                    algorithm,
                    xData.get(algorithm),
                    yData.get(algorithm)
            );
        }

        try {
            BitmapEncoder.saveBitmap(chart, "benchmark-chart", BitmapEncoder.BitmapFormat.PNG);
        } catch (Exception e) {
            System.out.println("Could not save image.");
        }

        new SwingWrapper<>(chart).displayChart();
    }
}