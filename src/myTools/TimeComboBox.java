package myTools;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JComboBox;


public class TimeComboBox extends JPanel {

	private String[] Ore = { "hh", "06", "07", "08", "09", "10", 
			"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
			"21", "22", "23", "24",};

	private String[] Minuti = {"mm", "00", "5", "10", "15", "20", "30", "40", "45", "50", "55"};
	private JComboBox<String> HourComboBox;
	private JComboBox<String> MinuteComboBox;
	
	private String hh = "";
	private String mm = "";
	
	public TimeComboBox() {

		setBackground(new Color(255, 255, 255));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		HourComboBox = new JComboBox<String>();
		HourComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hh = (String)HourComboBox.getSelectedItem();
			}
		});
		HourComboBox.setModel(new DefaultComboBoxModel<String>(Ore));
		add(HourComboBox);
		
		MinuteComboBox = new JComboBox<String>();
		MinuteComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mm = (String)MinuteComboBox.getSelectedItem();
			}
		});
		MinuteComboBox.setModel(new DefaultComboBoxModel<String>(Minuti));
		add(MinuteComboBox);
	}
	
	public String gethhmm() {
		
		if (hh.isEmpty() || hh.equals("hh") || mm.isEmpty() || mm.equals("mm")) { return ""; }
		
		else { return hh + ":" + mm; }
	}
	
	public int getHour() { return HourComboBox.getSelectedIndex(); }
	
	public void setHour(int hour) { 
		System.out.println(hour);
		int index = hour - 5;
		System.out.println(index);
		HourComboBox.setSelectedIndex(index); }
	
	
	public int getMinute() { return MinuteComboBox.getSelectedIndex(); }
	
	public void setMinute(Integer minute) { 
		
		if (minute == 0) { MinuteComboBox.setSelectedItem("00"); } 
		
		else { MinuteComboBox.setSelectedItem(minute.toString()); }
	}
		
	
	
	public void resetFields() {
		
		HourComboBox.setSelectedIndex(0);
		MinuteComboBox.setSelectedIndex(0);
	}
}