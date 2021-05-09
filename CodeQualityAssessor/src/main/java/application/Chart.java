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

/**
 * Classe com métodos para criar piechart numa JDialog
 * @author rgmpo-iscte
 *
 */


public class Chart extends JDialog {
	DefaultPieDataset dataset = null;

/**
 * Mostra o piechart criado numa JDialog depois de correr o método createDataset e createChart com os parametros que recebe
 * @param VP
 * @param FP
 * @param VN
 * @param FN
 * @param CodeSmell
 */
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
/**
 * Cria o dataset para a PieChart com os indicadores recebidos
 * @param VP
 * @param FP
 * @param VN
 * @param FN
 * @return dataset
 */
    public DefaultPieDataset createDataset(int VP, int FP, int VN, int FN) {

        var dataset = new DefaultPieDataset();
        dataset.setValue("Verdadeiros Positivos (VP) = "+VP , VP );
        dataset.setValue("Falsos Positivos (FP) = "+FP, FP  );
        dataset.setValue("Verdadeiros Negativos (VN) = "+VN,  VN );
        dataset.setValue("Falsos Negativos (FN) = "+FN,  FN  );

        return dataset;
    }
/**
 * Cria o piechart com o dataset criado e o nome para o piechart
 * @param dataset
 * @param CodeSmells
 * @return piechart
 */
    public JFreeChart createChart(DefaultPieDataset dataset, String CodeSmells) {

        JFreeChart pieChart = ChartFactory.createPieChart(
                "Avaliação da qualidade de deteção de code smells - " + CodeSmells,
                dataset,
                false, true, false);

        return pieChart;
    }

}
