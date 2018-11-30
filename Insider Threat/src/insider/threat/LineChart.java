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
 * Plot dos histogramas
 * Based on this: https://www.tutorialspoint.com/jfreechart/jfreechart_line_chart.htm
 * @author Felipe Morais da Silva
 * @author Daniel Henrique Ferreira Gomes
 */
public class LineChart extends JFrame{
    
    /**
     * Construtor relativo ao histograma de um nó
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
     * Construtor relativo à dois usuários
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
    
    /**
     * Cria um conjunto de dados com base no histograma e usuário passado
     * @param histogram
     * @param user
     */
    private DefaultCategoryDataset createDataset(double [] histogram, String user ) {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
      
        for (int i = 0; i < 24; i++) {
            dataset.addValue(histogram[i], user, new Integer(i));
        }

      return dataset;
    }
    
    /**
     * Cria um conjunto de dados relativos a dois usuários
     * @param histogram1
     * @param user1
     * @param histogram2
     * @param user2
     */
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
     * Exibe o histograma
     */
    public void plot(){
        pack();
        RefineryUtilities.centerFrameOnScreen(this);
        setVisible(true);
    }
    
}
