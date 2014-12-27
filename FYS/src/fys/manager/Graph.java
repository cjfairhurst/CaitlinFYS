package fys.manager;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Paint;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class Graph extends JPanel {
    private DefaultCategoryDataset dataset;
    private JFreeChart chart;

    public Graph(String windowTitle) {
        this.dataset = new DefaultCategoryDataset();
    }


    /**
     * Adds values of an array to the dataset
     * @param rowValue Array containing the values (one per column)
     * @param seriesName Name of the series
     * @param colName Names of the columns
     */
    public void addSeries(int[] rowValue, String seriesName, String[] colName) {
        for (int i = 0; i < rowValue.length; i++) {
            this.dataset.addValue(rowValue[i], seriesName, colName[i]);
        }
    }

    /**
     * Creates a chart. This can be a line chart or a stacked bar chart
     * @param title Title of the Chart
     * @param xAxisString Title of the x Axis
     * @param yAxisString Title of the y Axis
     * @param width width of the graph
     * @param height height of the graph
     * @param bgColor background color of the graph
     * @param container
     */
    public void createChart(String title, String xAxisString, String yAxisString, int width, int height, Paint bgColor, JPanel container) {
      
        this.chart = ChartFactory.createLineChart(title, xAxisString, yAxisString, this.dataset, PlotOrientation.VERTICAL, true, true, false);
        
//        this.chart = ChartFactory.createStackedBarChart(title, xAxisString, yAxisString, this.dataset, PlotOrientation.VERTICAL, true, true, false);
        
        chart.setBackgroundPaint(bgColor);
        ChartPanel chartPanel = new ChartPanel(this.chart);
        chartPanel.setPreferredSize(new Dimension(width, height));
        container.add(chartPanel, BorderLayout.CENTER);
        container.validate();
    }

    /**
     * Changes thickness of series line
     * @param seriesIndex index of series
     * @param thickness thickness of line
     */
    public void setSeriesThickness(int seriesIndex, int thickness) {
        CategoryPlot plot = (CategoryPlot) this.chart.getPlot();
        CategoryItemRenderer renderer = plot.getRenderer();
        renderer.setSeriesStroke(seriesIndex, new BasicStroke(thickness));
    }

    /**
     * Changes color of series
     * @param seriesIndex index of series
     * @param color the chosen color
     */
    public void setSeriesColor(int seriesIndex, Paint color) {
        CategoryPlot plot = (CategoryPlot) this.chart.getPlot();
        CategoryItemRenderer renderer = plot.getRenderer();
        renderer.setSeriesPaint(seriesIndex, color);
    }

    /**
     * Changes colors of the plot
     * @param bgColor the wanted background color
     * @param gridlineColor the color if the horizontal grid lines
     */
    public void setGraphBackgroudColors(Paint bgColor, Paint gridlineColor) {
        CategoryPlot plot = (CategoryPlot) this.chart.getPlot();
        plot.setBackgroundPaint(bgColor);
        plot.setRangeGridlinePaint(gridlineColor);
    }
}
