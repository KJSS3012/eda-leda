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

        // ==========================================
        // CUSTOMIZAÇÃO VISUAL (DARK THEME & FONTES)
        // ==========================================
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        // Configuração de Fontes (Arial, tamanhos maiores)
        Font titleFont = new Font("Arial", Font.BOLD, 24);
        Font axisLabelFont = new Font("Arial", Font.BOLD, 16);
        Font tickLabelFont = new Font("Arial", Font.PLAIN, 14);
        Font legendFont = new Font("Arial", Font.PLAIN, 14);

        chart.getTitle().setFont(titleFont);
        plot.getDomainAxis().setLabelFont(axisLabelFont);
        plot.getDomainAxis().setTickLabelFont(tickLabelFont);
        plot.getRangeAxis().setLabelFont(axisLabelFont);
        plot.getRangeAxis().setTickLabelFont(tickLabelFont);
        chart.getLegend().setItemFont(legendFont);

        // Configuração de Cores (Fundo Escuro e Textos Claros)
        Color darkBackground = new Color(43, 43, 43);      // Fundo externo da janela
        Color plotBackground = new Color(50, 53, 55);      // Fundo da área do gráfico
        Color gridColor = new Color(100, 100, 100);        // Linhas de grade sutis
        Color textColor = new Color(230, 230, 230);        // Texto quase branco

        chart.setBackgroundPaint(darkBackground);
        plot.setBackgroundPaint(plotBackground);

        // Aplicando cor clara aos textos e eixos para contrastar com o fundo escuro
        chart.getTitle().setPaint(textColor);
        plot.getDomainAxis().setLabelPaint(textColor);
        plot.getDomainAxis().setTickLabelPaint(textColor);
        plot.getDomainAxis().setAxisLinePaint(textColor);

        plot.getRangeAxis().setLabelPaint(textColor);
        plot.getRangeAxis().setTickLabelPaint(textColor);
        plot.getRangeAxis().setAxisLinePaint(textColor);

        chart.getLegend().setBackgroundPaint(darkBackground);
        chart.getLegend().setItemPaint(textColor);

        // Adicionando margem para descolar a legenda da borda inferior (Top, Left, Bottom, Right)
        chart.getLegend().setMargin(0, 20, 15, 0);

        // Linhas de grade do gráfico
        plot.setRangeGridlinePaint(gridColor);
        plot.setDomainGridlinePaint(gridColor);

        // Faz com que cada linha tenha pontos visíveis (markers) e ajusta a espessura
        for (int i = 0; i < dataset.getSeriesCount(); i++) {
            renderer.setSeriesShapesVisible(i, true);
            renderer.setSeriesStroke(i, new BasicStroke(2.5f)); // Linha um pouco mais grossa para maior destaque
        }

        plot.setRenderer(renderer);

        // ==========================================
        // SALVAR E EXIBIR
        // ==========================================
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

            // Fundo da janela Swing
            frame.getContentPane().setBackground(darkBackground);

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