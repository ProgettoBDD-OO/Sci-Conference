package myTools;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Dimension;
import java.awt.Color;

public class DateComboBox extends JPanel{

	private String[] Giorni = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", 
			"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
			"21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};

	private String[] Mesi = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};

	private String[] Anni = {"22", "23", "24", "25", "26", "27"};
	
	
	public DateComboBox() {
		setBackground(new Color(255, 255, 255));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JComboBox<String> DayComboBox = new JComboBox<String>();
		DayComboBox.setMaximumSize(new Dimension(55, 25));
		DayComboBox.setPreferredSize(new Dimension(40, 22));
		DayComboBox.setModel(new DefaultComboBoxModel<String>(Giorni));
		add(DayComboBox);
		
		JComboBox<String> MonthComboBox = new JComboBox<String>();
		MonthComboBox.setMaximumSize(new Dimension(55, 25));
		MonthComboBox.setPreferredSize(new Dimension(40, 22));
		MonthComboBox.setModel(new DefaultComboBoxModel<String>(Mesi));
		add(MonthComboBox);
		
		JComboBox<String> YearComboBox = new JComboBox<String>();
		YearComboBox.setMaximumSize(new Dimension(55, 25));
		YearComboBox.setPreferredSize(new Dimension(40, 22));
		YearComboBox.setModel(new DefaultComboBoxModel<String>(Anni));
		add(YearComboBox);
		
	}
}