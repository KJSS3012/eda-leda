package br.edu.ufcg.eda.benchmark;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ChartGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextLine()) {
            System.out.println("No input received.");
            return;
        }

        // Pula o cabeçalho se houver
        scanner.nextLine();

        // O Dataset do JFreeChart funciona como um Map interno de séries
        XYSeriesCollection dataset = new XYSeriesCollection();
        Map<String, XYSeries> algorithmSeries = new HashMap<>();

        while (scanner.hasNext()) {
            try {
                String algorithm = scanner.next();
                if (!scanner.hasNextLong()) break;
                long time = scanner.nextLong();
                if (!scanner.hasNextInt()) break;
                int samples = scanner.nextInt();

                // Cria a série para o algoritmo se ela ainda não existir
                algorithmSeries.putIfAbsent(algorithm, new XYSeries(algorithm));
                algorithmSeries.get(algorithm).add(samples, time);
            } catch (Exception e) {
                break;
            }
        }

        if (algorithmSeries.isEmpty()) {
            System.out.println("No benchmark data found.");
            return;
        }

        // Adiciona todas as séries criadas ao dataset principal
        algorithmSeries.values().forEach(dataset::addSeries);

        // Cria o gráfico de linhas (XY Line Chart)
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Algorithm Benchmark",   // Título
                "Samples (N)",           // Eixo X
                "Time (ns)",             // Eixo Y
                dataset,
                PlotOrientation.VERTICAL,
                true,                    // Legenda
                true,                    // Tooltips
                false                    // URLs
        );

        // Customização Visual (Simulando o estilo detalhado)
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        // Faz com que cada linha tenha pontos visíveis (markers)
        for (int i = 0; i < dataset.getSeriesCount(); i++) {
            renderer.setSeriesShapesVisible(i, true);
            renderer.setSeriesStroke(i, new BasicStroke(2.0f)); // Linha um pouco mais grossa
        }

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.BLACK);
        plot.setDomainGridlinePaint(Color.BLACK);

        // Salva o arquivo PNG
        try {
            ChartUtils.saveChartAsPNG(new File("benchmark-chart.png"), chart, 1200, 800);
            System.out.println("Chart saved as benchmark-chart.png");
        } catch (Exception e) {
            System.err.println("Error saving chart: " + e.getMessage());
        }

        // Exibe na tela (Swing)
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Benchmark Visualization");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(1200, 800));
            chartPanel.setMouseWheelEnabled(true); // Habilita zoom com o scroll
            frame.add(chartPanel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
