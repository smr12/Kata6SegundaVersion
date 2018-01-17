package kata6.view;
import java.awt.Dimension;
import javax.swing.JPanel;
import kata6.model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
public class HistogramDisplay<T> extends ApplicationFrame{
    private final Histogram <T> histogram;
    private final String nameEjeX;
    public HistogramDisplay(Histogram<T> histogram, String nameEjeX){
        super("Kata3 : Histograma");
        this.histogram = histogram;
        this.nameEjeX = nameEjeX;
        setContentPane(createPanel());
        pack();
    }
    public void execute(){
        setVisible(true);
    }
    private JPanel createPanel(){
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(500,400));
        return chartPanel;
    }
    private JFreeChart createChart(DefaultCategoryDataset dataset){
         JFreeChart chart =
                ChartFactory.createBarChart(
                "JfreeChart",
                "Dominios email",
                "Nº email",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                rootPaneCheckingEnabled,
                rootPaneCheckingEnabled);
        return chart;        
    }
    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        dataSet.addValue(15, "", "ulpgc.es");
        dataSet.addValue(8, "", "ull.es");
        dataSet.addValue(2, "", "hotmail.com");
        dataSet.addValue(6, "", "gmail.com");
        for(T key : histogram.keySet()){
            dataSet.addValue(histogram.get(key), "",(Comparable) "key");
        }
        return dataSet;
    }
}