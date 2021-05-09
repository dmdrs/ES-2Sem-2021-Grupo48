package application;


import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;



public class Chart extends JDialog {
	DefaultPieDataset dataset = null;


    public void createChart(int VP, int FP, int VN, int FN, String CodeSmell) {
        dataset=createDataset(VP,FP,VN,FN);
        JFreeChart chart = createChart(dataset, CodeSmell);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("Pie chart");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public DefaultPieDataset createDataset(int VP, int FP, int VN, int FN) {

        var dataset = new DefaultPieDataset();
        dataset.setValue("Verdadeiros Positivos (VP) = "+VP , VP );
        dataset.setValue("Falsos Positivos (FP) = "+FP, FP  );
        dataset.setValue("Verdadeiros Negativos (VN) = "+VN,  VN );
        dataset.setValue("Falsos Negativos (FN) = "+FN,  FN  );

        return dataset;
    }

    public JFreeChart createChart(DefaultPieDataset dataset, String CodeSmells) {

        JFreeChart pieChart = ChartFactory.createPieChart(
                "Avaliação da qualidade de deteção de code smells - " + CodeSmells,
                dataset,
                false, true, false);

        return pieChart;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var ex = new Chart();
            ex.setVisible(true);
        });
    }
}
