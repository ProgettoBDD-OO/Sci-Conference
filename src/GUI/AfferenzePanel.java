package GUI;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import linker.Controller;
import myTools.myTemplates;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class AfferenzePanel extends JPanel {

	private Controller controller;

	private myTemplates t;
	
	private JPanel PercentualiAfferenze;
	private DefaultPieDataset Dataset;
	private PiePlot Plot;
	private int n = 1;
	private Color LightBlue;
	private Color DarkBlue;

	public AfferenzePanel(Controller c, int month, int year) {

		controller = c;
		t = new myTemplates();
		LightBlue = new Color(50, 150, 255);
		DarkBlue = new Color(0, 0, 200);
		
		setBackground(new Color(255, 255, 255));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		CardLayout AfferenzeCardLayout = new CardLayout();
		
		JPanel AfferenzeCardPanel = new JPanel();
		AfferenzeCardPanel.setBackground(new Color(255, 255, 255));
		AfferenzeCardPanel.setLayout(AfferenzeCardLayout);
		add(AfferenzeCardPanel, BorderLayout.CENTER);
		
		JLabel NoAfferenzeLbl = new JLabel();
		NoAfferenzeLbl.setForeground(new Color(0, 0, 200));
		NoAfferenzeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		NoAfferenzeLbl.setText("Nessun dato trovato in questo periodo.");
		NoAfferenzeLbl.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		AfferenzeCardPanel.add(NoAfferenzeLbl, "NoAfferenze");
		
		JPanel AfferenzeContainer = new JPanel();
		AfferenzeContainer.setBackground(new Color(255, 255, 255));
		AfferenzeContainer.setLayout(new BoxLayout(AfferenzeContainer, BoxLayout.X_AXIS));
		AfferenzeCardPanel.add(AfferenzeContainer, "Afferenze");


	    	Dataset = new DefaultPieDataset();

	        JFreeChart chart = ChartFactory.createPieChart("", Dataset, false, true, false);

	        Plot = (PiePlot) chart.getPlot();
	        Plot.setOutlinePaint(t.white);
	        Plot.setBackgroundPaint(t.white);
	        Plot.setSectionOutlinePaint(t.white);
	        Plot.setSectionOutlineStroke(new BasicStroke(4));
	        Plot.setShadowPaint(null);
	        Plot.setLabelGenerator(null);
	        
	        PercentualiAfferenze = new JPanel();
	        PercentualiAfferenze.setBackground(new Color(255, 255, 255));
	        PercentualiAfferenze.setLayout(new BoxLayout(PercentualiAfferenze, BoxLayout.Y_AXIS));
	        AfferenzeContainer.add(PercentualiAfferenze);

	        ChartPanel PieChartConteiner = new ChartPanel(chart);
	        PieChartConteiner.setPreferredSize(new Dimension(400, 420));
	        AfferenzeContainer.add(PieChartConteiner);

	        controller.addPercentualiAfferenze(this, month, year);
	        
	        if (getItemCount() != 0) {
				
				AfferenzeCardLayout.show(AfferenzeCardPanel, "Afferenze"); 
			}
	}

	public void addValue(String name, double percentage) {
			
			Dataset.setValue(name, percentage);

			if (n % 2 == 1) { Plot.setSectionPaint(name, DarkBlue); }
			
			else { Plot.setSectionPaint(name, LightBlue); }
			
			n++;
			DarkBlue = new Color(0, 0, DarkBlue.getBlue() - 15);
			LightBlue = new Color(LightBlue.getRed() + 15, LightBlue.getGreen() + 10, 255);
	}

	public JPanel getPercentualiAfferenze() { return PercentualiAfferenze; }
	
	public int getItemCount() { return Dataset.getItemCount(); }
}