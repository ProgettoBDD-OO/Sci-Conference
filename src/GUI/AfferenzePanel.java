package GUI;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import linker.Controller;
import myTools.myTemplates;

import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import java.awt.event.MouseMotionAdapter;

public class AfferenzePanel extends JPanel {
	
	private Controller controller;
	
	myTemplates t = new myTemplates();
	private JPanel PercentualiAfferenze;
	DefaultPieDataset dataset;
	PiePlot plot;
	int n = 1;
	
	public AfferenzePanel(Controller contr, int month, int year) {
		
		controller = contr;
		
		setBackground(new Color(255, 255, 255));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		PercentualiAfferenze = new JPanel();
		PercentualiAfferenze.setBackground(new Color(255, 255, 255));
		PercentualiAfferenze.setPreferredSize(new Dimension(400, 10));
		add(PercentualiAfferenze);
		PercentualiAfferenze.setLayout(new BoxLayout(PercentualiAfferenze, BoxLayout.Y_AXIS));

		
	    	dataset = new DefaultPieDataset();
	  
	        JFreeChart chart = ChartFactory.createPieChart("", dataset, false, true, false);
	
	        plot = (PiePlot) chart.getPlot();
	        plot.setOutlinePaint(t.white);
	        plot.setBackgroundPaint(t.white);
	        plot.setSectionOutlinePaint(t.white);
	        plot.setSectionOutlineStroke(new BasicStroke(4));
	        plot.setShadowPaint(null);
	        plot.setLabelGenerator(null);
	        
	        ChartPanel PieChartConteiner = new ChartPanel(chart);
	        add(PieChartConteiner);
	        
	        if (month == -1) { controller.fooo2(this, year); } 
	        
	        else { controller.fooo(this, month, year); }
	}
	
	public void addValue(String name, double percentage) {
		
		dataset.setValue(name, percentage);
		
		switch (n) {
		
		case 1:
			plot.setSectionPaint(name, t.scBlue);
			break;

		case 2:
			plot.setSectionPaint(name, new Color(100, 240, 255));
			break;
			
		case 3:
			plot.setSectionPaint(name, t.dBlue);
			break;
		
		case 4:
			plot.setSectionPaint(name, new Color(240, 240, 255));
			break;
			
		case 5:
			plot.setSectionPaint(name, new Color(0, 0, 80));
			break;
			
		case 6:
			plot.setSectionPaint(name, new Color(100, 200, 255));
			break;
			
		case 7:
			plot.setSectionPaint(name, new Color(60, 60, 200));
			break;
			
		case 8:
			plot.setSectionPaint(name, new Color(248, 248, 255));
		default:
			break;
		}
		
		n++;
	}
	
	public JPanel getPercentualiAfferenze() { return PercentualiAfferenze; }
}