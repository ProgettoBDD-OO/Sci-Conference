package myTools;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DateComboBox extends JPanel{

	private String[] Giorni = { "G","01", "02", "03", "04", "05", "06", "07", "08", "09", "10", 
			"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
			"21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};

	private String[] Mesi = {"M","01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};

	private String[] Anni = {"A","22", "23", "24", "25", "26"};
	
	private String gg = "";
	private String mm = "";
	private String aa = "";
	
	
	public DateComboBox() {
		
		setBackground(new Color(255, 255, 255));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JComboBox<String> DayComboBox = new JComboBox<String>();
		DayComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gg = ((String)DayComboBox.getSelectedItem());
			}
		});
		DayComboBox.setMaximumSize(new Dimension(55, 25));
		DayComboBox.setPreferredSize(new Dimension(40, 22));
		DayComboBox.setModel(new DefaultComboBoxModel<String>(Giorni));
		add(DayComboBox);
		
		JComboBox<String> MonthComboBox = new JComboBox<String>();
		MonthComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mm = ((String)MonthComboBox.getSelectedItem());
			}
		});
		MonthComboBox.setMaximumSize(new Dimension(55, 25));
		MonthComboBox.setPreferredSize(new Dimension(40, 22));
		MonthComboBox.setModel(new DefaultComboBoxModel<String>(Mesi));
		add(MonthComboBox);
		
		JComboBox<String> YearComboBox = new JComboBox<String>();
		YearComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aa = "20" + ((String)YearComboBox.getSelectedItem());
			}
		});
		YearComboBox.setMaximumSize(new Dimension(55, 25));
		YearComboBox.setPreferredSize(new Dimension(40, 22));
		YearComboBox.setModel(new DefaultComboBoxModel<String>(Anni));
		add(YearComboBox);
		
	}
	
	public String getGGMMAA() { 
		
		if (aa.isEmpty() || mm.isEmpty() || gg.isEmpty()) {
		
			return "";
		
		} else { return aa + "-" + mm + "-" + gg; }
	}
}