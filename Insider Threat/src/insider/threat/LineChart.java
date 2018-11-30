/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insider.threat;

import javax.swing.JFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * Based on this: https://www.tutorialspoint.com/jfreechart/jfreechart_line_chart.htm
 * @author morai
 */
public class LineChart extends JFrame{
    
    /**
     *
     * @param title
     * @param chartTitle
     * @param histogram
     * @param user
     */
    public LineChart(String title, String chartTitle, double[] histogram, String user) {
        super(title);
        
        JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "Hours of day","Frequency",
         createDataset(histogram, user),
         PlotOrientation.VERTICAL,
         true,true,false);
         
      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      setContentPane( chartPanel );
    }
    
    /**
     *
     * @param title
     * @param chartTitle
     * @param histogram1
     * @param user1
     * @param histogram2
     * @param user2
     */
    public LineChart(String title, String chartTitle, double[] histogram1, String user1, double[] histogram2, String user2) {
        super(title);
        
        JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "Hours of day","Frequency",
         createDataset(histogram1, user1, histogram2, user2),
         PlotOrientation.VERTICAL,
         true,true,false);
         
      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      setContentPane( chartPanel );
    }
    
    private DefaultCategoryDataset createDataset(double [] histogram, String user ) {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
      
        for (int i = 0; i < 24; i++) {
            dataset.addValue(histogram[i], user, new Integer(i));
        }

      return dataset;
    }
    
    private DefaultCategoryDataset createDataset(double [] histogram1, String user1, 
                                                 double [] histogram2, String user2 ) {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
      
        for (int i = 0; i < 24; i++) {
            dataset.addValue(histogram1[i], user1, new Integer(i));
            dataset.addValue(histogram2[i], user2, new Integer(i));
        }
        
      return dataset;
   }
    
    /**
     *
     */
    public void plot(){
        pack();
        RefineryUtilities.centerFrameOnScreen(this);
        setVisible(true);
    }
    
}
