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
 * @author morai
 */
public class LineChart extends JFrame{
    
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
    
    private DefaultCategoryDataset createDataset(double [] histogram, String user ) {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
      
        for (int i = 0; i < 24; i++) {
            dataset.addValue(histogram[i], user, new Integer(i));
        }
      /*
      dataset.addValue( 15 , "schools" , "1970" );
      
      
      dataset.addValue( 30 , "schools" , "1980" );
      dataset.addValue( 60 , "schools" ,  "1990" );
      dataset.addValue( 120 , "schools" , "2000" );
      dataset.addValue( 240 , "schools" , "2010" );
      dataset.addValue( 300 , "schools" , "2014" );*/
      return dataset;
   }
    
    public void plot(){
        pack();
        RefineryUtilities.centerFrameOnScreen(this);
        setVisible(true);
    }
    
}
