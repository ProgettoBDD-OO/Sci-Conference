package myTools;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;


public class TimeComboBox extends JPanel {

	private String[] Ore = { "06", "07", "08", "09", "10",
							 "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
							 "21", "22", "23", "24",};

	private Integer[] Minuti = { 0, 5, 10, 15, 20, 30, 40, 45, 50, 55};
	private JComboBox<String> HourComboBox;
	private JComboBox<Integer> MinuteComboBox;

	private String hh = "06";
	private Integer mm = 0;

	public TimeComboBox() {

		setBackground(new Color(255, 255, 255));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		HourComboBox = new JComboBox<>(Ore);
		add(HourComboBox);
		HourComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hh = (String)HourComboBox.getSelectedItem();
			}
		});

		MinuteComboBox = new JComboBox<>(Minuti);
		add(MinuteComboBox);
		MinuteComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mm = (Integer)MinuteComboBox.getSelectedItem();
			}
		});
	}

	public String gethhmm() {

		return hh + ":" + mm;
	}

	public int getHour() { return HourComboBox.getSelectedIndex() + 5; }

	public void setHour(int hour) {

		int index = hour - 5;
		HourComboBox.setSelectedIndex(index);
	}

	public Integer getMinute() { return (Integer) MinuteComboBox.getSelectedItem(); }

	public void setMinute(Integer minute) {

		if (minute == 0) { MinuteComboBox.setSelectedItem(0); }

		else { MinuteComboBox.setSelectedItem(minute.toString()); }
	}

	
	public void resetFields() {

		HourComboBox.setSelectedIndex(0);
		MinuteComboBox.setSelectedIndex(0);
	}
}